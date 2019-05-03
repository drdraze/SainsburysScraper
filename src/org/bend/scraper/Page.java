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
	
	public Page(String url, String productsElement) {
		
		this.url=url;
		this.productsElement=productsElement;
		
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
				Elements products = doc.getElementsByClass(productsElement);
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
