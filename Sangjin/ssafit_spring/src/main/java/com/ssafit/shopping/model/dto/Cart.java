package com.ssafit.shopping.model.dto;

public class Cart {

	private int cartId;
	private String cartUserId;
	private int cartProductId;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartId, String cartUserId, int cartProductId) {
		super();
		this.cartId = cartId;
		this.cartUserId = cartUserId;
		this.cartProductId = cartProductId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCartUserId() {
		return cartUserId;
	}

	public void setCartUserId(String cartUserId) {
		this.cartUserId = cartUserId;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartUserId=" + cartUserId + ", cartProductId=" + cartProductId + "]";
	}
	
	

}
