package com.ijse.possystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private Integer age;

    @Column(nullable = false,unique = true)
    private Integer contactNo;

    private String address;
    private String remark;

    @Column(nullable = false)
    private Double creditLimit;

    @Column(nullable = false)
    private String customerType;

}
