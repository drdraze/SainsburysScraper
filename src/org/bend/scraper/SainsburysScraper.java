package org.bend.scraper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SainsburysScraper {
//main class for the app. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Page page = new Page ("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html","productLister gridView");
		page.init();
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        System.out.println(gson.toJson(page.getProductList()));
         
		
	}

}
