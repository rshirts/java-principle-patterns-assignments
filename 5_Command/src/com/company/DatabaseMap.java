package com.company;

import java.util.HashMap;
import java.util.Map;

public class DatabaseMap {
    public Map<String, ActiveDatabase> map;

    public DatabaseMap() {
        map = new HashMap<>();
    }

    public void printMap() {
        //Print out the database
        map.forEach((k,v)->{
            System.out.println("Database: " + k + " " + v.toString());
        });
    }
}
