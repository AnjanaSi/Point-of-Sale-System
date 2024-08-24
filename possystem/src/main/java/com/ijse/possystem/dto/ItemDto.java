package com.ijse.possystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Integer itemCode;
    private String name;
    private Double itemCost;
    private Double markedPrice;
    private Double ourPrice;
    private String barcode;
    private String supplier;
    private String category;
    private LocalDateTime updatedDate;
    private String updatingUser;

}
