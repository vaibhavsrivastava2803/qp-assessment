package com.example.grocery.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grocery.Model.BookedItem;

public interface BookedItemRepository extends JpaRepository<BookedItem, Long>{
	
	

}
