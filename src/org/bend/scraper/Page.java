package org.bend.scraper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Page {
//page class represents a page with a list of products
	String url;
	String productsElement;
	Elements products;
	
	public Page(String url, String productsElement) {
		
		this.url=url;
		this.productsElement=productsElement;
		
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
		
		String kcal_per_100g = doc.getElementsByClass("nutritionLevel1").first().text();
		String unit_price = element.getElementsByClass("pricePerUnit").first().text();
		String description = doc.getElementById("information").getElementsByTag("p").first().text();
		
		Product p= new Product(title, unit_price, kcal_per_100g, description); 

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
				Document doc = Jsoup.connect(url).get();
				products = doc.getElementsByClass("gridItem");
				if(products==null) {
					System.out.println("url does not have a productLister gridView element");
					return false;
				}
				else
					return true;
			}
			
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
}
