package com.company;

import java.util.HashMap;
import java.util.Map;

public abstract class Database {
    Map<String, String> database = new HashMap<>();
    String id;

    public Database(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public Database() {}

    void add(String key, String value) {
        if (!database.containsKey(key)) {
            database.put(key, value);
        } else {
            System.out.println("The key already exists.");
        }
    }

    String get (String key) {
        if (!database.containsKey(key)) {
            return "That key does not exist.";
        } else {
            return database.get(key);
        }
    }

    void update(String key, String value) {
        if (database.containsKey(key)) {
            database.put(key, value);
        } else {
            System.out.println("That key does not exist.");
        }
    }

    void remove (String key) {
        if (!database.containsKey(key)) {
            System.out.println("That key does not exist.");
        } else {
            database.remove(key);
        }
    }

    void display() {
        System.out.println(database.toString());
    }
}
