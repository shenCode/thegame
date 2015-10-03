package com.shencode.thegame.multiplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable{

    public ServerSocket serverSocket;
    public Socket socket;
    public DataOutputStream out;
    
    private final int PORT = 4117;
    
    private static final Logger logger = LoggerFactory.getLogger(Server.class);
    
    private String ipAddress;
    
    private Thread t;

    public Server() throws IOException {

    }

    public void start() {
        System.out.println("Server Socket Created");
		logger.info("Server started");
        
        try {
			serverSocket = new ServerSocket(PORT);
            logger.debug(String.format("ServerSocket created with port: %d", PORT));
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
        
        t = new Thread(this);
        t.start();
    }
    
    public String getIpAddress() {
        logger.info("IP Address retrieved.");
    	try {
    		ipAddress = Inet4Address.getLocalHost().getHostAddress();
            logger.debug(String.format("IP Address retrieved: %d", ipAddress));
    	}
    	catch(UnknownHostException e){
    		logger.error(e.getMessage());
    	}
    	
		return ipAddress;  	
    }

	public void run() {
        try {
			socket = serverSocket.accept();        
			logger.debug("Server Socket accepted");
	        out = new DataOutputStream(socket.getOutputStream());
	        out.writeUTF("This is a test.");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
        System.out.println("Thread Ends!");
	}

}