package org.nick.kindershop1.entity.category;

import javax.persistence.*;

@Entity
@Table(name = "oc_category")
@SecondaryTable(name = "oc_category_description",pkJoinColumns = @PrimaryKeyJoinColumn(name = "category_id"))
//	pkJoinColumns = @PrimaryKeyJoinColumn(name = "category_id") -- имя поля из Description!!!
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int id;
	@Column(name = "parent_id")
	private int parentId;
	@Column(name = "image")
	private String imageUrl;
	@Column(name = "status")
	private short status;
	@Column(name = "name",table="oc_category_description")
	private String catName;
	@Column(name = "description",table="oc_category_description")
	private String catDescription;
	
	
	/*-----<<<<<<>>>>>>-----*/
	
	public Category() {
	}
	
	public Category(int id, int parentId, String imageUrl, short status, String catName, String catDescription) {
		this.id = id;
		this.parentId = parentId;
		this.imageUrl = imageUrl;
		this.status = status;
		this.catName = catName;
		this.catDescription = catDescription;
	}
	
	/*-----<<<<<<>>>>>>-----*/
	
	
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
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public short getStatus() {
		return status;
	}
	
	public void setStatus(short status) {
		this.status = status;
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
	
	/*-----<<<<<<>>>>>>-----*/
	
	@Override
	public String toString() {
		return "\nCategory{" +
				       "id=" + id +
				       ", parentId=" + parentId +
				       ", imageUrl='" + imageUrl + '\'' +
				       ", status=" + status +
				       ", catName='" + catName + '\'' +
				       ", catDescription='" + catDescription + '\'' +
				       '}'+"\n";
	}
}
