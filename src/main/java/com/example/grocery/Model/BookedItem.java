package com.example.grocery.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookedItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long groceryItemId;
	private String userName;
	private int quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGroceryItemId() {
		return groceryItemId;
	}
	public void setGroceryItemId(Long groceryItemId) {
		this.groceryItemId = groceryItemId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	  public BookedItem(Long groceryItemId, String userName, int quantity) {
	        this.groceryItemId = groceryItemId;
	        this.userName = userName;
	        this.quantity = quantity;
	    }
	  
	  public BookedItem() {
	       
	    }
}
