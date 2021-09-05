package org.nick.kindershop1.entity.product;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int id;
	private int categoryId;
	private float price;
	private String name;
	private String description;
	private String imageUrl;
	
//	private List<String> imgArray=new ArrayList<>();
	
	private Iterable<ProdImage> imgArray=new ArrayList<>();
	
	public Product(){
	}
	
	public Product(int id, int categoryId, float price, String name, String description, String imageUrl, Iterable<ProdImage> imgArray) {
		this.id = id;
		this.categoryId = categoryId;
		this.price = price;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.imgArray = imgArray;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public Iterable<ProdImage> getImgArray() {
		return imgArray;
	}
	
	public void setImgArray(Iterable<ProdImage> imgArray) {
		this.imgArray = imgArray;
	}
	
	@Override
	public String toString() {
		return "\nProduct{" +
				       "id=" + id +
				       ", categoryId=" + categoryId +
				       ", price=" + price +
				       ", name='" + name + '\'' +
				       ", description='" + description + '\'' +
				       ", imageUrl='" + imageUrl + '\'' +
				       ", imgArray=" + imgArray +
				       '}';
	}
}

