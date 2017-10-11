package com.company;

import java.util.Map;

public class UpdateObject {

    String databaseName;
    String key;
    String value;
    String previousValue = "";
    DatabaseMap databaseMap;

    public UpdateObject(DatabaseMap databaseMap, CommandInfo commandInfo) {
        this.databaseMap = databaseMap;
        this.databaseName = commandInfo.databaseId;
        this.key = commandInfo.key;
        this.value = commandInfo.value;
    }

    public void update() {
        if (databaseMap.map.containsKey(databaseName)) {
            //save old value for undo
            previousValue = databaseMap.map.get(databaseName).get(key);
            databaseMap.map.get(databaseName).update(key, value);
        }
    }

    public void undo() {
        if (databaseMap.map.containsKey(databaseName)) {
            databaseMap.map.get(databaseName).update(key, previousValue);
            System.out.println("Undid Update: \n\tKey: " + key + " Value: " + value);
        }
    }
}
