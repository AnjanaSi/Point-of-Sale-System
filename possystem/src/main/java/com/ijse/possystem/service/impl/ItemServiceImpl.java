package com.ijse.possystem.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijse.possystem.dto.ItemDto;
import com.ijse.possystem.entity.Item;
import com.ijse.possystem.entity.User;
import com.ijse.possystem.repository.ItemRepository;
import com.ijse.possystem.repository.UserRepository;
import com.ijse.possystem.service.ItemService;




@Service
public class ItemServiceImpl implements ItemService {
    

    @Autowired
    ItemRepository repository;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public ItemDto saveItem(ItemDto dto) {

        User user = userRepository.findByUsername(dto.getUpdatingUser()).orElse(null);

        Item item = new Item();
        item.setItemCost(dto.getItemCost());
        item.setName(dto.getName());
        item.setMarkedPrice(dto.getMarkedPrice());
        item.setOurPrice(dto.getOurPrice());
        item.setBarcode(dto.getBarcode());
        item.setCategory(dto.getCategory());
        item.setSupplier(dto.getSupplier());
        item.setUpdatedUser(user);
        item.setUpdatedDate(dto.getUpdatedDate());
        Item savedItem = repository.save(item);

        ItemDto dtoNew = new ItemDto();
        dtoNew.setItemCode(savedItem.getItemCode());
        dtoNew.setName(savedItem.getName());
        dtoNew.setItemCost(savedItem.getItemCost());
        dtoNew.setMarkedPrice(savedItem.getMarkedPrice());
        dtoNew.setOurPrice(savedItem.getOurPrice());
        dtoNew.setBarcode(savedItem.getBarcode());
        dtoNew.setSupplier(savedItem.getSupplier());
        dtoNew.setCategory(savedItem.getCategory());
        dtoNew.setUpdatedDate(savedItem.getUpdatedDate());
        dtoNew.setUpdatingUser(savedItem.getUpdatedUser().getUsername());

        return dtoNew;

    }

    @Override
    public ItemDto updateItem(ItemDto dto) {
        Item item=repository.findById(dto.getItemCode()).orElse(null);
        User user = userRepository.findByUsername(dto.getUpdatingUser()).orElse(null);
        item.setName(dto.getName());
        item.setItemCost(dto.getItemCost());
        item.setMarkedPrice(dto.getMarkedPrice());
        item.setOurPrice(dto.getOurPrice());
        item.setBarcode(dto.getBarcode());
        item.setSupplier(dto.getSupplier());
        item.setCategory(dto.getCategory());
        item.setUpdatedDate(LocalDateTime.now());
        item.setUpdatedUser(user);

        Item savedItem=repository.save(item);
        ItemDto dtoNew = new ItemDto();
        dtoNew.setItemCode(savedItem.getItemCode());
        dtoNew.setName(savedItem.getName());
        dtoNew.setItemCost(savedItem.getItemCost());
        dtoNew.setMarkedPrice(savedItem.getMarkedPrice());
        dtoNew.setOurPrice(savedItem.getOurPrice());
        dtoNew.setBarcode(savedItem.getBarcode());
        dtoNew.setSupplier(savedItem.getSupplier());
        dtoNew.setCategory(savedItem.getCategory());
        dtoNew.setUpdatedDate(savedItem.getUpdatedDate());
        dtoNew.setUpdatingUser(savedItem.getUpdatedUser().getUsername());

        return dtoNew;

    }

    @Override
    public void deleteItem(int id) {
        repository.deleteById(id);

    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = repository.findAll();
        List<ItemDto> dtos = new ArrayList<>();
        for (Item item : items) {
            ItemDto dto = new ItemDto();
            dto.setItemCode(item.getItemCode());
            dto.setName(item.getName());
            dto.setItemCost(item.getItemCost());
            dto.setMarkedPrice(item.getMarkedPrice());
            dto.setOurPrice(item.getOurPrice());
            dto.setBarcode(item.getBarcode());
            dto.setSupplier(item.getSupplier());
            dto.setCategory(item.getCategory());
            dto.setUpdatedDate(item.getUpdatedDate());
            dto.setUpdatingUser(item.getUpdatedUser().getUsername());
            dtos.add(dto);

        }
        return dtos;
    }

    @Override
    public ItemDto findItemByItemCode(int itemCode) {
        Item item=repository.findById(itemCode).orElse(null);
        if(item!=null){
            ItemDto dtoNew=new ItemDto();
            dtoNew.setItemCode(item.getItemCode());
            dtoNew.setName(item.getName());
            dtoNew.setItemCost(item.getItemCost());
            dtoNew.setMarkedPrice(item.getMarkedPrice());
            dtoNew.setOurPrice(item.getOurPrice());
            dtoNew.setBarcode(item.getBarcode());
            dtoNew.setSupplier(item.getSupplier());
            dtoNew.setCategory(item.getCategory());
            dtoNew.setUpdatedDate(item.getUpdatedDate());
            dtoNew.setUpdatingUser(item.getUpdatedUser().getUsername());
            return dtoNew;

        }
        return null;
    }

    @Override
    public ItemDto findItemByName(String name) {
        Item item=repository.findItemByName(name);
        if(item!=null){
            ItemDto dtoNew=new ItemDto();
            dtoNew.setItemCode(item.getItemCode());
            dtoNew.setName(item.getName());
            dtoNew.setItemCost(item.getItemCost());
            dtoNew.setMarkedPrice(item.getMarkedPrice());
            dtoNew.setOurPrice(item.getOurPrice());
            dtoNew.setBarcode(item.getBarcode());
            dtoNew.setSupplier(item.getSupplier());
            dtoNew.setCategory(item.getCategory());
            dtoNew.setUpdatedDate(item.getUpdatedDate());
            dtoNew.setUpdatingUser(item.getUpdatedUser().getUsername());
            return dtoNew;
        }
        return null;
    }

    @Override
    public ItemDto findItemByBarcode(String barcode) {
        Item item=repository.findItemByBarcode(barcode);
        if(item!=null){
            ItemDto dtoNew=new ItemDto();
            dtoNew.setItemCode(item.getItemCode());
            dtoNew.setName(item.getName());
            dtoNew.setItemCost(item.getItemCost());
            dtoNew.setMarkedPrice(item.getMarkedPrice());
            dtoNew.setOurPrice(item.getOurPrice());
            dtoNew.setBarcode(item.getBarcode());
            dtoNew.setSupplier(item.getSupplier());
            dtoNew.setCategory(item.getCategory());
            dtoNew.setUpdatedDate(item.getUpdatedDate());
            dtoNew.setUpdatingUser(item.getUpdatedUser().getUsername());
            return dtoNew;
        }
        return null;
    }
}


