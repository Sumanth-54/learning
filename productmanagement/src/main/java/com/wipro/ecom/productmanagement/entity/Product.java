package com.wipro.ecom.productmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String prodName;
	private String prodDesc;
	private String prodCat;
	private String make;
	private int availableQty;
	private double price;
	private String uom;
	private double prodRating;
	private String imageURL;
	private LocalDate dateOfManufacture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdCat() {
		return prodCat;
	}

	public void setProdCat(String prodCat) {
		this.prodCat = prodCat;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public double getProdRating() {
		return prodRating;
	}

	public void setProdRating(double prodRating) {
		this.prodRating = prodRating;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public LocalDate getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(LocalDate dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodCat=" + prodCat
				+ ", make=" + make + ", availableQty=" + availableQty + ", price=" + price + ", uom=" + uom
				+ ", prodRating=" + prodRating + ", imageURL=" + imageURL + ", dateOfManufacture=" + dateOfManufacture
				+ "]";
	}

}
