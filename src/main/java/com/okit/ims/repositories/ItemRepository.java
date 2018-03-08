package com.okit.ims.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.okit.ims.domain.Item;

/**
 * 
 * @author Diederick Verweij
 *
 */
@RepositoryRestResource
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface ItemRepository extends CrudRepository<Item, Long>{
	
	public List<Item> findByName(String category);
	public List<Item> findByCategoryName(String categoryId);

}
