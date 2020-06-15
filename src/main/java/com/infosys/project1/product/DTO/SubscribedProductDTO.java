package com.infosys.project1.product.DTO;

import com.infosys.project1.product.Entity.SubscribedProductEntity;

public class SubscribedProductDTO {
	int subId;
	int prodId;
	int buyerId;
	int quantity;
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public static SubscribedProductDTO valueof(SubscribedProductEntity p1) {
		SubscribedProductDTO p= new SubscribedProductDTO();
		p.setBuyerId(p1.getBuyerId());
		p.setProdId(p1.getProdId());
		p.setQuantity(p1.getQuantity());
		p.setSubId(p1.getSubId());
		return p;
	}
		
	

}
