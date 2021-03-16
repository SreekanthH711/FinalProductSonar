package com.oms.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscribedproduct")
public class SubscribedProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "subid")
	private long subId;
	@Column(name = "buyerid", nullable = false)
	private long buyerId;
	@Column(name = "prodid", nullable = false)
	private long prodId;
	@Column(nullable = false)
	private long quantity;
	
	public long getSubId() {
		return subId;
	}
	public void setSubId(long subId) {
		this.subId = subId;
	}
	public long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
	public long getProdId() {
		return prodId;
	}
	public void setProdId(long prodId) {
		this.prodId = prodId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
}
