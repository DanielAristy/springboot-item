package com.springboot.app.item.service;

import com.springboot.app.item.models.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();
    public Item findById(Long id, Integer amount);

}
