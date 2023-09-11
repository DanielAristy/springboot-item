package com.springboot.app.item.service;

import com.springboot.app.item.models.Item;
import com.springboot.app.item.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ItemServiceImpl implements ItemService {

    private static final String LISTAR = "http://localhost:8001/listar";
    private static final String VER = "http://localhost:8001/ver/{id}";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Product> productos = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(LISTAR, Product[].class)));
        return productos.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer amount) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Product product = restTemplate.getForObject(VER, Product.class, pathVariables);
        return new Item(product, amount);
    }
}
