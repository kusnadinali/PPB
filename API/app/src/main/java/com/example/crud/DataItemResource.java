package com.example.crud;

import com.google.gson.annotations.SerializedName;

public class DataItemResource {

	@SerializedName("color")
	private String color;

	@SerializedName("year")
	private int year;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("pantone_value")
	private String pantoneValue;

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPantoneValue(String pantoneValue){
		this.pantoneValue = pantoneValue;
	}

	public String getPantoneValue(){
		return pantoneValue;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"color = '" + color + '\'' + 
			",year = '" + year + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",pantone_value = '" + pantoneValue + '\'' + 
			"}";
		}
}