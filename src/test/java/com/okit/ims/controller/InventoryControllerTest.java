package com.okit.ims.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.okit.ims.domain.Category;
import com.okit.ims.domain.Item;
import com.okit.ims.service.ItemService;

/**
 * 
 * @author Diederick Verweij
 *
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class InventoryControllerTest {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * This test makes sure that all entities, listed in the data.sql
	 * resource-file are being stored and reloaded
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInventory() throws Exception {
		assertEquals(3, itemService.getAllCategories().size());
		assertEquals(7, itemService.getAllItems().size());
	}
	
	/**
	 * This test makes sure that the cascade-type of Item.category
	 * can handle the mrging of an instance in an already existing 
	 * entry in the DB
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCascadeType() throws Exception {
		List<Item> items = itemService.getAllItems();
		assertNotNull("itemService.getAllItems() returned a null object", items);
		assertNotEquals(0, items.size());
		Item item = items.get(0);
		assertNotNull("itemService.getAllItems().get(0) returned a null object", item);
		Category category = item.getCategory();
		assertNotNull("item.getCategory() returned a null object", category);
	}
	
	/**
	 * This test makes sure that the adding of a new Item works as expected
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddingItem() throws Exception {
		int countBefore = itemService.getAllItems().size();
		Category category = new Category("food");
		itemService.addCategory(category);
		itemService.addItem(new Item(category, "football", 1, 1));
		assertEquals(countBefore +1,  itemService.getAllItems().size());
	}
	
	/**
	 * This test makes sure that the adding of a new Category works as expected
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddingCategory() throws Exception {
		int countBefore = itemService.getAllCategories().size();
		List<Item> items = itemService.getAllItems();
		Item item = items.get(0);
		Category category = new Category("newer category");
		itemService.addCategory(category);
		item.setCategory(category);
		itemService.updateItem(item);
		assertEquals(countBefore +1, itemService.getAllCategories().size());
	}
}
