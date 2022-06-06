package com.example.crud;

public class SingleUserResponse{
	private DataItemUser data;
	private Support support;

	public DataItemUser getData(){
		return data;
	}

	public void setSupport(Support support){
		this.support = support;
	}

	public Support getSupport(){
		return support;
	}

	@Override
 	public String toString(){
		return 
			"SingleUserResponse{" + 
			"data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}
