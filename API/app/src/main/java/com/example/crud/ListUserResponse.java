package com.example.crud;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListUserResponse{
	@SerializedName("per_page")
	private int perPage;

	private int total;

	private List<DataItemUser> data;

	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	public int getPerPage(){
		return perPage;
	}

	public int getTotal(){
		return total;
	}

	public List<DataItemUser> getData(){
		return data;
	}

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

	@Override
	public String toString() {
		return "ListUserResponse{" +
				"per_page=" + perPage +
				", total=" + total +
				", data=" + data +
				", page=" + page +
				", total_pages=" + totalPages +
				'}';
	}
}