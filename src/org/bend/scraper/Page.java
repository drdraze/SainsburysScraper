package org.bend.scraper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Page {
//page class represents a page with a list of products
	private String url;
	private String productsElement;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page(String url, String productsElement) {
		this.url=url;
		this.setProductsElement(productsElement);
	}
	
	public Product createProduct(Element element){
		
		Element titleElement = element.getElementsByTag("a").first();
		String title = titleElement.text();
		String itemLink = titleElement.attr("abs:href");
		Document doc=null;
		
		try {
			doc = Jsoup.connect(itemLink).get();
		}
		catch(IOException e)
		{
			System.out.println("Cannot connect to " + itemLink);
		}
		//omit kcal if its not there
		String kcal_per_100g=null;
		if(doc.getElementsByClass("nutritionLevel1").first()!=null) {
			kcal_per_100g = doc.getElementsByClass("nutritionLevel1").first().text();
		}
		
		String unit_price = element.getElementsByClass("pricePerUnit").first().text();
		String description = doc.getElementById("information").getElementsByTag("p").first().text();
		
		
		String[] parts = unit_price.split("/");
		String substring = parts[0];
		
		parts = substring.split("£");
		Double unitDouble = Double.parseDouble(parts[1]);
		
		String calDouble="N/A";
		if(kcal_per_100g!=null){
			parts = kcal_per_100g.split("k");
			calDouble = parts[0];
		}
		
		Product p = new Product(title, unitDouble, calDouble, description); 

		return p;
	}
	
	
	public boolean init()
	{
	
		try {
			URL address = new URL(this.url);   
			HttpURLConnection conn = (HttpURLConnection) address.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			if(!conn.getContentType().contains("text/html")) {
				System.out.println("url is not valid html doc");
				return false;
			}
			else {
				
			}
			return true;
			
		}
		catch(MalformedURLException e)
		{
			System.out.println("url is not correctly formed");
			return false;
		} catch (IOException e) {
			System.out.println("cannot connect to url");
			return false;
		}
		
	}
	
	public ArrayList<Product> genProductList() throws IOException{
		Document doc = Jsoup.connect(url).get();
		Elements products = doc.getElementsByClass(productsElement);
		if(products==null) {
			System.out.println(url+" does not have a "+productsElement+" element");
			return null;
		}
		else {
			
			ArrayList<Product> results = new ArrayList<Product>();
		
			for(Element product : products) {
				results.add(createProduct(product));
			}
			
			return results;
		}
			
	}
	public String getProductsElement() {
		return productsElement;
	}

	public void setProductsElement(String productsElement) {
		this.productsElement = productsElement;
	}
}
