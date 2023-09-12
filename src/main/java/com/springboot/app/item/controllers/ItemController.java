package com.springboot.app.item.controllers;

import com.springboot.app.item.models.Item;
import com.springboot.app.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemService.findAll();
    }

    @GetMapping("/ver/{id}/cantidad/{amount}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer amount){
        return itemService.findById(id, amount);
    }
}
