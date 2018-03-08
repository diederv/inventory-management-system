package com.okit.ims.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This entity represents a warehouse item of a certain Category
 * 
 * @author Diederick Verweij
 */
@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Category category;
	
	private String name;	
	private int minimal;	
	private int count;
	
	public Item() {	}
	
	public Item(Category category, String name, int minimal, int count) {
		this.category = category;
		this.name = name;
		this.minimal = minimal;
		this.count = count;
	}
	
	@JsonProperty
	public int getOverflow() {
		return count - minimal;
	}
	
	@JsonProperty
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonProperty
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@JsonProperty
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public int getMinimal() {
		return minimal;
	}
	public void setMinimal(int minimal) {
		this.minimal = minimal;
	}
	
	@JsonProperty
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
