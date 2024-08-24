package com.ijse.possystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.possystem.dto.UserDto;
import com.ijse.possystem.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    ResponseEntity<?> saveUser(@RequestBody UserDto dto) {
        try {
            UserDto userDto = userService.saveUser(dto);
            return ResponseEntity.status(200).body(userDto);
        } catch (DataIntegrityViolationException e) {
            String duplicateValue = extractDuplicateValue(e.getMessage());
            String errorMessage = "Duplicate entry! This user already exists with the value: " + duplicateValue;
            return ResponseEntity.status(400).body(Map.of("error", errorMessage));
        }

    }

    @GetMapping("/user")
    ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> dtos = userService.getAllUsers();
        return dtos == null ? ResponseEntity.status(404).body(null) : ResponseEntity.status(200).body(dtos);
    }

    @DeleteMapping("/user/{userId}")
    void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }
    @PutMapping("/user")
    ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto){
       UserDto userDto= userService.updateUser(dto);
       return userDto==null?ResponseEntity.status(404).body(null):ResponseEntity.status(200).body(userDto);
    }

    @GetMapping("/user/{username}")
    ResponseEntity<UserDto> getUserByUsername(@PathVariable String username){
       UserDto dto= userService.getUserByUsername(username);
       return dto==null?ResponseEntity.status(404).body(null):ResponseEntity.status(200).body(dto);
    }

    private String extractDuplicateValue(String exceptionMessage) {
        return exceptionMessage.substring(exceptionMessage.indexOf("Duplicate entry '") + 17,
                exceptionMessage.lastIndexOf("' for key"));
    }
}
