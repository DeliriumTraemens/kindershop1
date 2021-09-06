package org.nick.kindershop1.entity.product;

import javax.persistence.*;

@Entity
@Table(name ="oc_product")
public class Tovar {
	@Id
	@GeneratedValue
	@Column(name ="product_id")
	private int id;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "image")
	private String image;
	
	/*-------------------*/
	
	public Tovar() {
	}
	
	public Tovar(int id, float price, String image) {
		this.id = id;
		this.price = price;
		this.image = image;
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
	/*-------------------*/
	
	@Override
	public String toString() {
		return "\nTovar{" +
				       "id=" + id +
				       ", price=" + price +
				       ", image='" + image + '\'' +
				       '}';
	}
}
