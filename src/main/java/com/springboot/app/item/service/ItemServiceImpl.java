package com.springboot.app.item.service;

import com.springboot.app.item.models.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findById(Long id, Integer amount) {
        return null;
    }
}
