package org.nick.kindershop1.entity.product;

public class ProdImage{
	private String name;
	private String url="/path_to_image";
	
	public ProdImage() {
	}
	
	public ProdImage(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "ProdImage{" +
				       "name='" + name + '\'' +
				       ", url='" + url + '\'' +
				       '}';
	}
}
