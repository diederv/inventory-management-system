package com.okit.ims.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.okit.ims.domain.Category;
import com.okit.ims.domain.Item;
import com.okit.ims.service.ItemService;;

/**
 *  
 * This Controller abstracts the implementation that is responsible for handling 
 * storage and retrieval of Items and their Categories
 * 
 * @author Diederick Verweij
 */
@RestController
public class InventoryController {

	@Autowired
	private ItemService itemService;
		
	/**
	 * 
	 * @return a list of all the available Items
	 */
	@RequestMapping("/items")
	public List<Item> getAllItems() {
		return itemService.getAllItems(); 
	}
	
	/**
	 * 
	 * @return a list of all available Categories
	 */
	@RequestMapping("/categories")
	public List<Category> getCategories() {
		return itemService.getAllCategories(); 
	}
	
	/**
	 * 
	 * @param id the Id of the requested Item
	 * @return the Item
	 */
	@RequestMapping("/items/{id}")
	public Item getItem(@PathVariable Long id) {
		return itemService.getItem(id);
	}
	
	/**
	 * 
	 * @param item the Item that needs to be added to the repository 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/items")
	public void addItem(@RequestBody Item item) {
		itemService.addItem(item);
	}
	
	/**
	 * 
	 * @param category the Category that needs to be added to the repository
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/categories")
	public void addCategory(@RequestBody Category category) {
		itemService.addCategory(category);
	}
	
	/**
	 * 
	 * @param item the item that needs to be updated
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/items")
	public void updateItem(@RequestBody Item item) {
		itemService.updateItem(item);
	}
}
