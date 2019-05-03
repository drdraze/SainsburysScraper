package org.bend.scraper;

import static org.junit.jupiter.api.Assertions.*;

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
		Product p = page.createProduct(page.products.first());
		
		assertTrue(p.getTitle().equals("Sainsbury's Strawberries 400g"));
		assertTrue(p.getUnit_price().equals("£1.75/unit"));
		assertTrue(p.getKcal_per_100g().equals("33kcal"));
		assertTrue(p.getDescription().equals("by Sainsbury's strawberries"));
	}
}
