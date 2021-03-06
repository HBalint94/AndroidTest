package io.student.application.demoapplication.util;

public enum CurrencyList {

	USD("usd",296),
	YEN("yen",3),
	EURO("euro",310);

	final String imageName;
	final int changeRate;

	CurrencyList(String imageName, int changeRate){
		this.imageName = imageName;
		this.changeRate = changeRate;
	}

	public String getImageName() {
		return imageName;
	}

	public int getChangeRate() {
		return changeRate;
	}

}
