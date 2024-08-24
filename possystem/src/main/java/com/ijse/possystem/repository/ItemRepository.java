package com.ijse.possystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.possystem.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    Item findItemByName(String name);
    Item findItemByBarcode(String barcode);

}
