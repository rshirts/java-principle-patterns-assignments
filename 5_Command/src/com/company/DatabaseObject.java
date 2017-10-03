package com.company;

import java.util.HashMap;
import java.util.Map;

public class DatabaseObject {
    public ActiveDatabase activeDatabase;
    public String key;
    public String value;
    public String command;

    public DatabaseObject(String command, ActiveDatabase activeDatabase, String key, String value) {
        this.command = command;
        this.activeDatabase = activeDatabase;
        this.key = key;
        this.value = value;
    }

    public void add() {
        if (!activeDatabase.contains(key)) {
            activeDatabase.add(key, value);
        } else {
            System.out.println("The key already exists.");
        }
    }

    public String get () {
        if (activeDatabase.contains(key)) {
            return activeDatabase.get(key);
        } else {
            return "That key does not exist.";
        }
    }

    public void update() {
        if (activeDatabase.contains(key)) {
            activeDatabase.update(key, value);
        } else {
            System.out.println("That key does not exist.");
        }
    }

    public void remove () {
        if (activeDatabase.contains(key)) {
            activeDatabase.remove(key);
        } else {
            System.out.println("That key does not exist.");
        }
    }
}
