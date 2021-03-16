package com.oms.product.dto;

import com.oms.product.entity.SubscribedProduct;

public class SubscribedProductDTO {
	
	private long subId;
	private long buyerId;
	private long prodId;
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
	
	public SubscribedProduct createEntity() {
		SubscribedProduct subProd = new SubscribedProduct();
		subProd.setBuyerId(buyerId);
		subProd.setProdId(prodId);
		subProd.setQuantity(quantity);
		subProd.setSubId(subId);
		return subProd;
	}
	
	public static SubscribedProductDTO valueOf(SubscribedProduct subProduct) {
		SubscribedProductDTO subProdDTO = new SubscribedProductDTO();
		subProdDTO.setBuyerId(subProduct.getBuyerId());
		subProdDTO.setProdId(subProduct.getProdId());
		subProdDTO.setQuantity(subProduct.getQuantity());
		subProdDTO.setSubId(subProduct.getSubId());
		return subProdDTO;
	}
	@Override
	public String toString() {
		return "SubscribedProductDTO [subId=" + subId + ", buyerId=" + buyerId + ", prodId=" + prodId + ", quantity="
				+ quantity + "]";
	}
	
}
