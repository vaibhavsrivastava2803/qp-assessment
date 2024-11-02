package com.example.grocery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.grocery.Model.BookedItem;
import com.example.grocery.Model.GroceryItem;
import com.example.grocery.Service.AdminService;
import com.example.grocery.Service.UserRoleService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserRoleService userService;
	
    @GetMapping("/view")
    public String viewAllGroceryItems(Model model) {
        List<GroceryItem> items = adminService.viewAllItems();
        model.addAttribute("groceryItems", items);
        return "admin/view"; 
    }

    
    @GetMapping("/add")
    public String showAddGroceryItemForm(Model model) {
        model.addAttribute("groceryItem", new GroceryItem());
        return "admin/add"; 
    }
	
	
	@PostMapping("/add")
		public String addGroceryItem(@ModelAttribute GroceryItem item) {
			adminService.addGroceryItem(item);
			return "redirect:/admin/view";
			
		}
	
	@PostMapping("/view")
	public List<GroceryItem> viewAllGroceryItems(){
		return adminService.viewAllItems();
	}
	
	@GetMapping("/remove/{id}")
	public String removeGroceryItem(@PathVariable Long id) {
		adminService.removeGroceryItem(id);
	    return "redirect:/admin/view";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateGroceryItemForm(@PathVariable Long id, Model model) {
	    List<GroceryItem> items = adminService.viewAllItems();
	    GroceryItem item = null;
	    for (GroceryItem groceryItem : items) {
	        if (groceryItem.getId().equals(id)) {
	            item = groceryItem;
	            break; 
	        }
	    }

	    if (item == null) {
	        throw new RuntimeException("Item not found");
	    }

	    model.addAttribute("groceryItem", item);
	    return "admin/update"; 
	}
	
	@PostMapping("/update/{id}")
	public String updateGroceryItem(@PathVariable Long id, @ModelAttribute GroceryItem updateItem) {
		adminService.updateGroceryItem(id, updateItem);
		return "redirect:/admin/view";
	}
	
	@PostMapping("/inventory/{id}")
	public String manageInventory(@PathVariable Long id, @RequestParam int inventory) {
		   adminService.manageInventory(id, inventory);
		   return "redirect:/admin/view";
	}
	
	@GetMapping("/booked")
	public String viewBookedItems(Model model) {
		List<BookedItem> items = userService.getAllBookedItems();
		model.addAttribute("bookedItems", items);
		return "admin/bookedItems";
	}
	

}
