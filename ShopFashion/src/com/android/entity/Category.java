package com.android.entity;

public class Category {
	private int id;
	
	private String categoryName;
	private String categoryUrl;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryUrl() {
		return categoryUrl;
	}
	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
}
