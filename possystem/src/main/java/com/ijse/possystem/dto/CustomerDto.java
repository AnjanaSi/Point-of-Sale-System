package com.ijse.possystem.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer contactNo;
    private String address;
    private String remark;
    private Double creditLimit;
    private String customerType;

}
