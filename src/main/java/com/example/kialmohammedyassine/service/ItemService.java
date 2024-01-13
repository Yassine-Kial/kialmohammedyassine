package com.example.kialmohammedyassine.service;


import com.example.kialmohammedyassine.entity.Item;
import com.example.kialmohammedyassine.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;



    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return this.itemRepository.findById(id).get();
    }

    public void addItem(Item item) {
        this.itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        this.itemRepository.deleteById(id);
    }


    public void updateItem(Long id, Item item) {
        this.itemRepository.findById(id).map(i -> {
            i.setId(id);
            i.setDescription(item.getDescription());
            i.setShippingWeight(item.getShippingWeight());
             return this.itemRepository.save(i);
        }
        );
    }
}
