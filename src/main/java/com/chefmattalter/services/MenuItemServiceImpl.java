package com.chefmattalter.services;

import com.chefmattalter.models.MenuItem;
import com.chefmattalter.repositories.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }


    @Override
    public MenuItem getMenuItemById(UUID id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem getMenuItemByName(String name) {
        return menuItemRepository.findByName(name);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem updateMenuItem(UUID id, MenuItem menuItem) {
        if (menuItemRepository.existsById(id)) {
            menuItem.setId(id); // Ensure the ID is set for the update
            return menuItemRepository.save(menuItem);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteMenuItem(UUID id) {
        menuItemRepository.deleteById(id);
    }
}
