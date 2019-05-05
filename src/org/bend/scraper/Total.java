package org.bend.scraper;

public class Total {
	
private String gross,vat;

public Total(double gross) {
	this.gross=String.format("%.2f", gross);
	this.vat = String.format("%.2f", gross*0.2d);
}

public String getGross() {
		return gross;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}
}
