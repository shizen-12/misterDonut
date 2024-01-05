package model;

import java.io.Serializable;

public class Item implements Serializable{
	private String name;
	private int price;
	private int kcal;
	private String imgPath;
	private String category;
	
	
	public Item() {
		
	}
	
	public Item(String name, int price, int kcal, String imgPath, String category) {
		this.name = name;
		this.price = price;
		this.kcal = kcal;
		this.imgPath = imgPath;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
