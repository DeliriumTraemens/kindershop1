package org.nick.kindershop1.entity.category;

public class Category {
	private int id;
	private int parentId;
	private String catName;
	private String catDescription;
	private String imageUrl;
	
	public Category() {
	}
	
	public Category(int id, int parentId, String catName, String catDescription, String imageUrl) {
		this.id = id;
		this.parentId = parentId;
		this.catName = catName;
		this.catDescription = catDescription;
		this.imageUrl = imageUrl;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public String getCatName() {
		return catName;
	}
	
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	public String getCatDescription() {
		return catDescription;
	}
	
	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "\nCategory{" +
				       "id=" + id +
				       ", parentId=" + parentId +
				       ", catName='" + catName + '\'' +
				       ", catDescription='" + catDescription + '\'' +
				       ", imageUrl='" + imageUrl + '\'' +
				       '}';
	}
}
