package org.nick.kindershop1.entity.product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="oc_product")
@SecondaryTables({
		@SecondaryTable(name="oc_product_description",pkJoinColumns=@PrimaryKeyJoinColumn(name="product_id")),
		@SecondaryTable(name="oc_product_to_category",pkJoinColumns=@PrimaryKeyJoinColumn(name="product_id"))
})
//@SecondaryTable(name = "oc_product_description",pkJoinColumns=@PrimaryKeyJoinColumn(name="product_id"))
public class Tovar {
	@Id
	@GeneratedValue
	@Column(name ="product_id")
	private int id;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "name",table = "oc_product_description")
	private String name;
	
	@Column(name = "description",table = "oc_product_description")
	private String description;
	
	@Column(name = "category_id",table = "oc_product_to_category")
//	@OneToMany
//	@JoinColumn(name = "product_id",table = "oc_product_to_category")
	private int categoryId;
//	private List<Integer> categoryId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private List<ProdImage> imgArray;
	
	/*-------------------*/
	
	public Tovar() {
	}
	
	
	public Tovar(int id, float price, String image, String name, String description) {
		this.id = id;
		this.price = price;
		this.image = image;
		this.name = name;
		this.description = description;
	}
	
	public Tovar(int id, float price, String image, String name, String description, int categoryId) {
		this.id = id;
		this.price = price;
		this.image = image;
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
	}
	
	public Tovar(int id, float price, String image, String name, String description, int categoryId, List<ProdImage> imgArray) {
		this.id = id;
		this.price = price;
		this.image = image;
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
		this.imgArray = imgArray;
	}
	
	/*-------------------*/
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
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
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public String toString() {
		return "\nTovar{" +
				       "\nid=" + id +
				       ", \nprice=" + price +
				       ", \nimage='" + image + '\'' +
				       ", \nname='" + name + '\'' +
				       ", \ndescription='" + description + '\'' +
				       ", \ncategoryId=" + categoryId +
				       ", \nimgArray=" + imgArray +
				       '}';
	}
	
	/*-------------------*/
	
//	@Override
//	public String toString() {
//		return "\nTovar{" +
//				       "\n\tid=" + id +
//				       ",\n\tprice=" + price +
//				       ", \n\timage='" + image + '\'' +
//				       ", \n\tname='" + name + '\'' +
//				       ", \n\tdescription='" + description + '\'' +
//				       '}';
//	}
	
	
}
