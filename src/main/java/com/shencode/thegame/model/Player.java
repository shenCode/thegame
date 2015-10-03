package com.shencode.thegame.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {

    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    private String name;

    public Player(String name) {
        this.name = name;
        logger.info(String.format("Player of name: %s is created", name));
    }
}
