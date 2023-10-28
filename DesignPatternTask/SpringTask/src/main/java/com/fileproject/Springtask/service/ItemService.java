package com.fileproject.Springtask.service;

import com.fileproject.Springtask.model.Item;
import com.fileproject.Springtask.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ItemService {
    @Autowired
    ItemRepo itemRepo;
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepo.findById(id);
    }

    public Item createItem(Item item) {
        return itemRepo.save(item);
    }

    public Item updateItem( Item updatedItem) {
        return itemRepo.save(updatedItem);

    }

    public void deleteItem(Long id) {
        itemRepo.deleteById(id);
    }
}
