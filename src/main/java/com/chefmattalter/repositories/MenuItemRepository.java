package com.chefmattalter.repositories;

import com.chefmattalter.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {
    @Query(value = "SELECT id, created_at, category, name, description, price FROM menu_items", nativeQuery = true)
    Optional<List<MenuItem>> getAllMenuItems();

    @Query(value = "SELECT id, created_at, category, name, description, price FROM menu_items WHERE name = :name", nativeQuery = true)
    MenuItem findByName(@Param("name") String name);
}
