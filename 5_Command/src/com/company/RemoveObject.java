package com.company;

import java.util.Map;

public class RemoveObject {

    String databaseName = "";
    String key = "";
    String value = "";
    Map<String, ActiveDatabase> databaseMap;

    public RemoveObject(Map<String, ActiveDatabase> databaseMap , String databaseName, String key) {
        this.databaseMap = databaseMap;
        this.databaseName = databaseName;
        this.key = key;
    }

    public void add() {
        if (databaseMap.containsKey(databaseName)) {
            databaseMap.get(databaseName).add(key, value);
        } else {
            databaseMap.put(databaseName, new ActiveDatabase(databaseName));
            databaseMap.get(databaseName).add(key, value);
        }
        //todo: we need to add a remove object to the undo stack.
    }

    public void remove() {
        if (databaseMap.containsKey(databaseName)) {
            //need to assign the "value" of this object for the undo command which is add for this command.
            value = databaseMap.get(databaseName).get(key);
            databaseMap.get(databaseName).remove(key);
        } else {
            System.out.println(databaseMap.toString() + "Does not exist.");
        }
    }
}
