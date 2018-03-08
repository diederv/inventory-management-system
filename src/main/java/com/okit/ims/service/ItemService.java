package com.okit.ims.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okit.ims.domain.Category;
import com.okit.ims.domain.Item;
import com.okit.ims.repositories.CategoryRepository;
import com.okit.ims.repositories.ItemRepository;

/**
 * This ServiceClass translates all functional logic
 * that is related to the storage and retrieval of Items
 * and their Categories to a JPA implementation
 *  
 * @author Diederick Verweij
 *
 */
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * 
	 * @return a list of all available Items
	 */
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		itemRepository.findAll().forEach(items::add);
		return items;
	}
	
	/**
	 * 
	 * @return a list of all available categories
	 */
	public List<Category> getAllCategories() {
		List<Category> items = new ArrayList<>();
		categoryRepository.findAll().forEach(items::add);
		return items;
	}
	
	/**
	 * 
	 * @param item the new Item that needs to be stored in the DB
	 */
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	/**
	 * 
	 * @param category the new Category that needs to be stored in the DB
	 */
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	/**
	 * 
	 * @param id the Id of the reguested Item
	 * @return the requested Item
	 */
	public Item getItem(Long id) {
		return itemRepository.findById(id).get();
	}
	
	/**
	 * 
	 * @param item the Item that needs to be updated
	 */
	public void updateItem(Item item) {
		itemRepository.save(item);
	}
	
	/**
	 * 
	 * @param id the Id of the Item that needs to be deleted
	 */
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
	}
}
