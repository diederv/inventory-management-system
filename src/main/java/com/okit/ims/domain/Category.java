package com.okit.ims.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This entity represents a Category of a warehouse item
 * 
 * @author Diederick Verweij
 */
@Entity
public class Category {
	
	@Id	
	private String name;
	
	public Category() { }
	
	public Category(String name) {
		this.name = name;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
