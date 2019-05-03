package org.bend.scraper;

public class Product {

	String title;
	int unit_price;
	int kcal_per_100g;
	String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	public int getKcal_per_100g() {
		return kcal_per_100g;
	}
	public void setKcal_per_100g(int kcal_per_100g) {
		this.kcal_per_100g = kcal_per_100g;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}