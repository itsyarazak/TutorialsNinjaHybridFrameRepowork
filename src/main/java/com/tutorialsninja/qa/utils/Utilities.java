package com.tutorialsninja.qa.utils;

import java.util.Date;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 15;
	public static final int PAGE_WAIT_TIME = 10;

	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "abdul" + timestamp + "@gmail.com";
	}

}
