package com.ssafit.shopping.model.dto;

public class Product {

	private int productId;
	private String productName;
	private String productImg;
	private int productPrice;
	private int productStock;
	private int reviewCnt;
	private int likeCnt;
	
	public Product() {
	}
	
	public Product(int productId, String productName, String productImg, int productPrice, int productStock,
			int reviewCnt, int likeCnt) {
		this.productId = productId;
		this.productName = productName;
		this.productImg = productImg;
		this.productPrice = productPrice;
		this.productStock = productStock;
		this.reviewCnt = reviewCnt;
		this.likeCnt = likeCnt;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productImg=" + productImg
				+ ", productPrice=" + productPrice + ", productStock=" + productStock + ", reviewCnt=" + reviewCnt
				+ ", likeCnt=" + likeCnt + "]";
	}
	
	
	
	
}
