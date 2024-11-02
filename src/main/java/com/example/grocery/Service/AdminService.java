package com.example.grocery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grocery.Model.GroceryItem;
import com.example.grocery.Repo.GroceryItemRepository;

@Service
public class AdminService {
	
	@Autowired
	private GroceryItemRepository groceryItemRepository;
	
	public GroceryItem addGroceryItem(GroceryItem item) {
		return groceryItemRepository.save(item);
	}
	
	public List<GroceryItem> viewAllItems(){
		return groceryItemRepository.findAll();	
	}
	
	public void removeGroceryItem(Long itemId) {
		  groceryItemRepository.deleteById(itemId);
	}
	
	public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
		Optional<GroceryItem> optionalItem = groceryItemRepository.findById(itemId);
		
		if(optionalItem.isPresent()) {
			GroceryItem item = optionalItem.get();
			
			item.setName(updatedItem.getName());
			item.setPrice(updatedItem.getPrice());
			item.setInventory(updatedItem.getInventory());
			
			return groceryItemRepository.save(item);
		}
		else {
	        throw new RuntimeException("Item not found");
	    }
	}
	

	public GroceryItem manageInventory(Long itemId, int inventory) {
		Optional<GroceryItem> optionalItem = groceryItemRepository.findById(itemId);
		
		if(optionalItem.isPresent()) {
			GroceryItem item = optionalItem.get();
			
			item.setInventory(inventory);
			
			return groceryItemRepository.save(item);
		}
		else {
			throw new RuntimeException("Item Not Found");
			
		}
	}

}
