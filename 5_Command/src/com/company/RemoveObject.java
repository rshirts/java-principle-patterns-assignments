package com.company;

import java.util.Map;

public class RemoveObject {

    String databaseName = "";
    String key = "";
    String value = "";
    DatabaseMap databaseMap;

    public RemoveObject(DatabaseMap databaseMap, CommandInfo commandInfo) {
        this.databaseMap = databaseMap;
        this.databaseName = commandInfo.databaseId;
        this.key = commandInfo.key;
    }

    public void add() {
        if (databaseMap.map.containsKey(databaseName)) {
            databaseMap.map.get(databaseName).add(key, value);
            System.out.println("Undid Remove: \n\tKey: " + key + " Value: " + value);
        } else {
            databaseMap.map.put(databaseName, new ActiveDatabase(databaseName));
            databaseMap.map.get(databaseName).add(key, value);
        }
    }

    public void remove() {
        if (databaseMap.map.containsKey(databaseName)) {
            //need to assign the "value" of this object for the undo command which is add for this command.
            value = databaseMap.map.get(databaseName).get(key);
            databaseMap.map.get(databaseName).remove(key);
        }
    }
}
