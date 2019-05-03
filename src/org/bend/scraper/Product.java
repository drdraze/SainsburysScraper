package org.bend.scraper;

public class Product {

	String title;
	String unit_price;
	String kcal_per_100g;
	String description;
	
	public Product(String title, String unit_price, String kcal_per_100g, String description) {
		this.title=title;
		this.unit_price=unit_price;
		this.kcal_per_100g=kcal_per_100g;
		this.description=description;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}
	public String getKcal_per_100g() {
		return kcal_per_100g;
	}
	public void setKcal_per_100g(String kcal_per_100g) {
		this.kcal_per_100g = kcal_per_100g;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
