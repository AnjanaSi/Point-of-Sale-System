package com.ijse.possystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer contactNumber;
    private String nicNumber;
    private String username;
    private String password;
    private String userRole;
}
