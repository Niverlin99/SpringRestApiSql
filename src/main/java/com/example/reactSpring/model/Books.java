package com.example.reactSpring.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int id;
	@Column(name = "book_name")
	private String name;
	@Column(name = "author_name")
	private String author;
	@Column(name = "book_price")
	private String price;
	@Column(name = "book_edition")
	private String edition;
	@Column(name = "customer_name")
	private String customer;

	public Books() {
	}

	public Books(String name, String author, String price, String edition, String customer) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.edition = edition;
		this.customer = customer;
	}

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

}
