package com.example.grocery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.grocery.Model.GroceryItem;
import com.example.grocery.Service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	    private UserRoleService userRoleService;
	 
	
	 
	 @GetMapping("/items")
	 public String viewAvailableItems(Model model){
		 List<GroceryItem> items = userRoleService.getAvailableItems();
		 model.addAttribute("items", items);
		 return "user/items";
		 
	 }
	 
	 @PostMapping("/book")
	 public String bookItems(@RequestParam List<Long> itemIds, @RequestParam String userName){
		  userRoleService.bookItems(itemIds, userName);
		  return "redirect:/user/items";
		  
	 }
	 
//	   @PostMapping("/logout")
//		 public String Logout(Model model) {
//			 return "redirect:/login";
//		 }
	 

}
