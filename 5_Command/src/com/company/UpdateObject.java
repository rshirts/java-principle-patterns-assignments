package com.company;

import java.util.Map;

public class UpdateObject {

    String databaseName;
    String key;
    String value;
    String previousValue = "";
    Map<String, ActiveDatabase> databaseMap;

    public UpdateObject(Map<String, ActiveDatabase> databaseMap , String databaseName, String key, String value) {
        this.databaseMap = databaseMap;
        this.databaseName = databaseName;
        this.key = key;
        this.value = value;
    }

    public void update() {
        if (databaseMap.containsKey(databaseName)) {
            //save old value for undo
            previousValue = databaseMap.get(databaseName).get(key);
            databaseMap.get(databaseName).update(key, value);
        }
        //todo: we need to add a remove object to the undo stack.
    }

    public void undo() {
        if (databaseMap.containsKey(databaseName)) {
            databaseMap.get(databaseName).update(key, previousValue);
        } else {
            System.out.println(databaseMap.toString() + "Does not exist.");
        }
    }
}
