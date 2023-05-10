package com.scripter.javajackson.model;

import java.util.Date;

public class Car {
	private String brand = null;
    private int doors = 0;
    private Date date = null;

    public String getBrand() { return this.brand; }
    public void   setBrand(String brand){ this.brand = brand;}

    public int  getDoors() { return this.doors; }
    public void setDoors (int doors) { this.doors = doors; }
    

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", doors=" + doors + "]";
	}    
}
