package org.bend.scraper;

import java.util.ArrayList;

public class JsonObj {

	private ArrayList<Product> results;
	private Total total;
	
	public JsonObj(ArrayList<Product> results, Total total) {
		
		this.results=results;
		this.total = total;
		
	}
	public Total getTotal() {
		return total;
	}
	public void setTotal(Total total) {
		this.total = total;
	}
	public ArrayList<Product> getResults() {
		return results;
	}
	public void setResults(ArrayList<Product> results) {
		this.results = results;
	}
	
	
}
