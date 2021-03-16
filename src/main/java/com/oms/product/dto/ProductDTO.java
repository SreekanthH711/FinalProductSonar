package com.oms.product.dto;

import java.math.BigDecimal;

import com.oms.product.entity.Product;

public class ProductDTO {

	private Long prodId;
	private String brand;
	private String category;
	private String description;
	private String image;
	private BigDecimal price;
	private String productName;
	private Long rating;
	private Long sellerId;
	private Integer stock;
	private String subcategory;
	
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
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
	
	public Product createProduct() {
		Product product = new Product();
		product.setProdid(prodId);
		product.setBrand(brand);
		product.setCategory(category);
		product.setDescription(description);
		product.setImage(image);
		product.setPrice(price);
		product.setProductName(productName);
		product.setRating(rating);
		product.setSellerId(sellerId);
		product.setStock(stock);
		product.setSubcategory(subcategory);
		return product;
	}
	
	public static ProductDTO valueOf(Product product) {
		ProductDTO prodDTO = new ProductDTO();
		prodDTO.setProdId(product.getProdid());
		prodDTO.setBrand(product.getBrand());
		prodDTO.setCategory(product.getCategory());
		prodDTO.setDescription(product.getDescription());
		prodDTO.setImage(product.getImage());
		prodDTO.setPrice(product.getPrice());
		prodDTO.setProductName(product.getProductName());
		prodDTO.setRating(product.getRating());
		prodDTO.setSellerId(product.getSellerId());
		prodDTO.setStock(product.getStock());
		prodDTO.setSubcategory(product.getSubcategory());
		return prodDTO;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ProductDTO [prodId=" + prodId + ", productName=" + productName + ", brand=" + brand
				+ ", category=" + category + ", price=" + price + "]";
	}
	
	
}
