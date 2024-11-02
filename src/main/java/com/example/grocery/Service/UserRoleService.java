package com.example.grocery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery.Model.BookedItem;
import com.example.grocery.Model.GroceryItem;
import com.example.grocery.Repo.BookedItemRepository;
import com.example.grocery.Repo.GroceryItemRepository;

@Service
public class UserRoleService {

	@Autowired 
	private GroceryItemRepository groceryItemRepository;
	
	@Autowired
	private BookedItemRepository bookedItemRepository;
	
	
	public List<GroceryItem> getAvailableItems(){
		return groceryItemRepository.findAll();
	}
	
	public List<GroceryItem> bookItems(List<Long> itemids){
		return groceryItemRepository.findAllById(itemids);
	}
	
	 public void bookItems(List<Long> itemIds, String userName) {
	        for (Long itemId : itemIds) {
	            BookedItem bookedItem = new BookedItem(itemId, userName, 1); 
	            bookedItemRepository.save(bookedItem);
	        }
	    }
	 
	 public List<BookedItem> getAllBookedItems() {
	        return bookedItemRepository.findAll();
	    }
}
