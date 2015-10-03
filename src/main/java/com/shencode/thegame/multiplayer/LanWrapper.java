package com.shencode.thegame.multiplayer;

import java.io.IOException;

public class LanWrapper {

    private Server server;
    private Client client;

    public LanWrapper() throws IOException {
        server = new Server();
        client = new Client();
    }

    public void startServer() throws IOException {
        server.start();
    }

    public void startClient(String serverIp) throws IOException {
        client.start(serverIp);
    }
    
    public String getServerIp() {
    	return server.getIpAddress();
    }

}
