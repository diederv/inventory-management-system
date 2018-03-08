package com.okit.ims.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.okit.ims.domain.Category;

/**
 * 
 * @author Diederick Verweij
 *
 */		
@RepositoryRestResource
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface CategoryRepository extends CrudRepository<Category, String>{
	
}
