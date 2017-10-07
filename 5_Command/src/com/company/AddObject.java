package com.company;

import java.util.Map;

public class AddObject {

    String databaseName;
    String key;
    String value;
    DatabaseMap databaseMap;


    public AddObject(DatabaseMap databaseMap, CommandInfo commandInfo) {
        this.databaseMap = databaseMap;
        this.databaseName = commandInfo.databaseId;
        this.key = commandInfo.key;
        this.value = commandInfo.value;
    }

    public void add() {
        if (databaseMap.map.containsKey(databaseName)) {
            databaseMap.map.get(databaseName).add(key, value);
        } else {
            databaseMap.map.put(databaseName, new ActiveDatabase(databaseName));
            databaseMap.map.get(databaseName).add(key, value);
        }
    }

    public void remove() {
        if (databaseMap.map.containsKey(databaseName)) {
            databaseMap.map.get(databaseName).remove(key);
            System.out.println("Undid Add: \n\tKey: " + key + " Value: " + value);
        }
    }
}
