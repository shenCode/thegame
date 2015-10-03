package com.shencode.thegame.model;

public class Data {
	
	private static final Data instance = new Data();
	
	public static Data getInstance() {
		return instance;
	}
	
	/*****************************************************/

	private static final String VERSION = "517 Flow Version 0.0.1";

	private static final String API_KEY = "dcbfc3f697694f5070bea1d97fe06f086791cab0be7195995a991d48af2ee81a";
	private static final String SECRET_KEY = "5ef58cbf9923b6e76af073d077640558d9d977257bb9cc449ecb27e9585b8360";
	
	public static String getVersion() { return VERSION;	}
    public static String getApiKey() { return API_KEY; }
    public static String getSecretKey() { return SECRET_KEY; }
}
