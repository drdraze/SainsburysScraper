package org.bend.scraper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTests {

	@Test
	void initPageTest() {
		Page page = new Page ("https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html","productLister gridView");
		assertTrue(page.init());
	}

}
