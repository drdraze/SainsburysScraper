package org.bend.scraper;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SainsburysScraper {
//main class for the app. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Page page = new Page ("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html","gridItem");
		page.init();
		
		GsonBuilder builder = new GsonBuilder();
        builder.disableHtmlEscaping();
        Gson gson = builder.setPrettyPrinting().create();
        
        ArrayList<Product> results=new ArrayList<Product>();
		
        try {
			results = page.genProductList();
		} catch (IOException e) {
			System.out.println("cannot connect to url");
		}
        
        double grossTotal=0;
        
        for(Product p : results) {
        	grossTotal += Double.parseDouble(p.getUnit_price());
        }
        Total total = new Total(grossTotal);       
        
        JsonObj json = new JsonObj(results, total);
        
        System.out.println(gson.toJson(json));  
	}

}
