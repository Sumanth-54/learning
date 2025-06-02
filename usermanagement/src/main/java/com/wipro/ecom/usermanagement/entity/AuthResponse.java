package com.wipro.ecom.usermanagement.entity;

public class AuthResponse {

	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}

	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	@Override
	public String toString() {
		return "AuthResponse [jwt=" + jwt + "]";
	}

}
