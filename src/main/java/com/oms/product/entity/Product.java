package com.oms.product.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "prodid", length=11)
	private Long prodId;
	@Column(nullable = false, length = 255)
	private String brand;
	@Column(nullable = false, length = 255)
	private String category;
	@Column(nullable = false, length = 255)
	private String description;
	@Column(nullable = false, length = 255)
	private String image;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;
	@Column(name = "productname", nullable = false, length = 255)
	private String productName;
	@Column(nullable = true, length = 11)
	private Long rating;
	@Column(name = "sellerid", nullable = false)
	private Long sellerId;
	@Column(nullable = false, length = 11)
	private Integer stock;
	private String subcategory;
	
	
	public Long getProdid() {
		return prodId;
	}
	public void setProdid(Long prodId) {
		this.prodId = prodId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
}
