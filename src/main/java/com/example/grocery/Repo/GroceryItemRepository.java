package com.example.grocery.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grocery.Model.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {

}
