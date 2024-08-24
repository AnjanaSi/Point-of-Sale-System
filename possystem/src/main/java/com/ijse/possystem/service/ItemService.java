package com.ijse.possystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.possystem.dto.ItemDto;

@Service
public interface ItemService {
    ItemDto saveItem(ItemDto dto);
    ItemDto updateItem(ItemDto dto);
    void deleteItem(int id);
    List<ItemDto> getAllItems();
    ItemDto findItemByItemCode(int itemCode);
    ItemDto findItemByName(String name);
    ItemDto findItemByBarcode(String barcode);
}
