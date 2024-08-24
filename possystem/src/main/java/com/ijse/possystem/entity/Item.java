package com.ijse.possystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double itemCost;

    @Column(nullable = false)
    private Double markedPrice;

    @Column(nullable = false)
    private Double ourPrice;

    @Column(unique = true)
    private String barcode;

    @Column(nullable = false)
    private String supplier;

    @Column(nullable = false)
    private String category;

    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User updatedUser;


}
