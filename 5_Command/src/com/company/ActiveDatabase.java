package com.company;

public class ActiveDatabase extends Database {

    public ActiveDatabase(String id) {
        super(id);
    }

    public String getID() {
        return id;
    }

    public boolean contains(String key) {
        if (database.containsKey(key)){
            return true;
        }

        return false;
    }

    public void add(String key, String value) {
        if (!database.containsKey(key)) {
            database.put(key, value);
        } else {
            System.out.println("The key already exists.");
        }
    }

    public String get(String key) {
        if (!database.containsKey(key)) {
            return "That key does not exist.";
        } else {
            return database.get(key);
        }
    }

    public void update(String key, String value) {
        if (database.containsKey(key)) {
            database.put(key, value);
        } else {
            System.out.println("That key does not exist.");
        }
    }

    public void remove(String key) {
        if (!database.containsKey(key)) {
            System.out.println("That key does not exist.");
        } else {
            database.remove(key);
        }
    }

    public void display() {
        database.forEach((k,v)-> System.out.println("Key: " + k + " Value: " + v));
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        database.forEach((k,v)->{
            returnString.append("Key: " + k + " Value: " + v);
        });

        return returnString.toString();
    }
}
