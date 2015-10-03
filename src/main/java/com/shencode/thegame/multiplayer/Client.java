package com.shencode.thegame.multiplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by syang on 4/30/2015.
 */
public class Client {

    static Socket socket;
    static DataInputStream in;

    private static final int PORT = 4117;
    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    
    private String ipAddress;

    public Client() throws IOException {

    }

    public void start(String serverIp) throws IOException {  	
        System.out.println("Client created");        
        socket = new Socket(serverIp, PORT);
        System.out.println("Client Socket created");
        in = new DataInputStream(socket.getInputStream());
        System.out.println("Data received.");
	    String test = in.readUTF();
	    System.out.println("MESSAGE FROM SERVER: " + test);
    }
    
    public String getIpAddress() {
    	
    	try {
    		ipAddress = Inet4Address.getLocalHost().getHostAddress();
    	}
    	catch(UnknownHostException e){
    		logger.error(e.getMessage());
    	}
		return ipAddress;
    	
    }

}
