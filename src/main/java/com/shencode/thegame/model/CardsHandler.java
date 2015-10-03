package com.shencode.thegame.model;

import org.w3c.dom.Document;

public class CardsHandler {
	
	public static void handleChannelTag(Document doc) {
		System.out.println("\t<name>" + doc.getElementsByTagName("name").item(0).getTextContent()+ "</name>");
	}
}
