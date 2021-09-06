package org.nick.kindershop1.entity.product;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;

@Entity
@Table(name = "oc_product_image")
public class ProdImage{
	
	@Id
	@GeneratedValue
	@Column(name="product_image_id")
	private int id;
	
	@Column(name="image")
	private String name;
	
	/*--------*/
	
	public ProdImage() {
	}
	
	public ProdImage(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/*--------*/
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/*--------*/
	
	@Override
	public String toString() {
		return "\n\tProdImage{" +
				       "\n\tid=" + id +
				       ", \n\tname='" + name + '\'' +
				       '}';
	}
}
