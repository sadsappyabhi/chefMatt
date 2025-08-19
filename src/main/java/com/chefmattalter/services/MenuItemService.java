package com.chefmattalter.services;

import com.chefmattalter.models.MenuItem;

import java.util.List;
import java.util.UUID;

public interface MenuItemService {
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem getMenuItemById(UUID id);
    MenuItem getMenuItemByName(String name);
    List<MenuItem> getAllMenuItems();
    MenuItem updateMenuItem(UUID id, MenuItem menuItem);
    void deleteMenuItem(UUID id);
}
