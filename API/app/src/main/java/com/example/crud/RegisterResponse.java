package com.example.crud;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("id")
	private int id;

	@SerializedName("token")
	private String token;

	private String error;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "RegisterResponse{" +
				"id=" + id +
				", token='" + token + '\'' +
				", error='" + error + '\'' +
				'}';
	}
}