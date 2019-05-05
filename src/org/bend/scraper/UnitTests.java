package org.bend.scraper;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class UnitTests {

	@Test
	void initPageTest() {
		Page page = new Page ("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html","productLister gridView");
		assertTrue(page.init());
	}
	
	@Test
	void createProductTest() {
		Page page = new Page ("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html","productLister gridView");
		page.init();
		
		Product p=null;
		
		try {
			p = page.genProductList().get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(p.getTitle().equals("Sainsbury's Strawberries 400g"));
		assertTrue(p.getUnit_price().contentEquals("1.75"));
		assertTrue(p.getKcal_per_100g().equals("33kcal"));
		assertTrue(p.getDescription().equals("by Sainsbury's strawberries"));
		
	}	
}
