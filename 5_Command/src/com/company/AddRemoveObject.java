package com.company;

import java.util.Map;

public class AddRemoveObject {

    String databaseName;
    String key;
    String value;
    Map<String, ActiveDatabase> databaseMap;
    ActiveDatabase activeDatabase;


    public AddRemoveObject(Map<String, ActiveDatabase> databaseMap , String databaseName, String key, String value) {
        this.databaseMap = databaseMap;
        this.databaseName = databaseName;
        this.key = key;
        this.value = value;
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
            databaseMap.get(databaseName).remove(key);
        } else {
            System.out.println(databaseMap.toString() + "Does not exist.");
        }
    }
}
