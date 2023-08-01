package com.spring_crud_api.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {
	
   
	@Id
	private int id;
	private String name;
	private int qunty;
	private int price;
	private String descrip;
	
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
	public int getQunty() {
		return qunty;
	}
	public void setQunty(int qunty) {
		this.qunty = qunty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getdescrip() {
		return descrip;
	}
	public void setdescrip(String descrip) {
		this.descrip = descrip;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", qunty=" + qunty + ", price=" + price + ", descrip=" + descrip
				+ "]";
	}
	public Products(int id, String name, int qunty, int price, String descrip) {
		super();
		this.id = id;
		this.name = name;
		this.qunty = qunty;
		this.price = price;
		this.descrip = descrip;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
