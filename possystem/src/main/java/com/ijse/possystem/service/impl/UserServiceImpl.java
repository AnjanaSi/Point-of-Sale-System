package com.ijse.possystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijse.possystem.dto.UserDto;
import com.ijse.possystem.entity.User;
import com.ijse.possystem.repository.UserRepository;
import com.ijse.possystem.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto saveUser(UserDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        User userEntity = repository.save(mapper.convertValue(dto, User.class));

        return mapper.convertValue(userEntity, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = repository.findAll();
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (User eachUser : users) {

            userDtos.add(mapper.convertValue(eachUser, UserDto.class));
        }
        return userDtos;
    }

    @Override
    public void deleteUser(int userId) {
        User getDeleteUser = repository.findById(userId).orElse(null);
        if (getDeleteUser != null) {
            repository.delete(getDeleteUser);
        }
    }

    @Override
    public UserDto updateUser(UserDto dto) {
        if (dto.getPassword() == null) {
            User user = repository.findById(dto.getId()).orElse(null);
            dto.setPassword(user.getPassword());
            User updateUser = mapper.convertValue(dto, User.class);
            return mapper.convertValue(repository.save(updateUser), UserDto.class);
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        User updateUser = mapper.convertValue(dto, User.class);
        return mapper.convertValue(repository.save(updateUser), UserDto.class);
    }

    @Override
    public UserDto getUserByUsername(String username) {
       User user=repository.findByUsername(username).orElse(null);
       return mapper.convertValue(user,UserDto.class);
    }


}
