package com.ijse.possystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.possystem.dto.UserDto;


@Service
public interface UserService {
    UserDto saveUser(UserDto dto);

    List<UserDto> getAllUsers();

    void deleteUser(int userId);

    UserDto updateUser(UserDto dto);

    UserDto getUserByUsername(String username);


}
