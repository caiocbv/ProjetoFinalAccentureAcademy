package com.projeto.accenture.helpers;

public class Helper {
	
	public static boolean isNumber(String param) {
		try {
			Integer.parseInt(param);
			return true;
			
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
