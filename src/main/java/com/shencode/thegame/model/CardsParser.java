package com.shencode.thegame.model;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CardsParser {

	public CardsParser() throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File("resources/cards.xml");
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlFile);
		doc.getDocumentElement().normalize();
		CardsHandler.handleChannelTag(doc);
	}
}
