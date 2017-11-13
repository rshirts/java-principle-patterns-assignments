package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDatabase implements Database {

    //using random access file since the database is the file and we need to reset to front of file.
    RandomAccessFile randomAccessFile;
    String fileLine = "";


    public FileDatabase(String fileName) {
        File file = new File(fileName);

        try {
            randomAccessFile = new RandomAccessFile(file, "r");

        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file: " + fileName);
        }
    }

    @Override
    public String getID() {
        //use this to get the ID of the line.
        String[] words = null;
        //reset back to front of the file.
        try {
            if((fileLine = randomAccessFile.readLine()) != null) {
                words = fileLine.trim().split("\\s+");
                return words[0];
            }
        } catch (IOException e) {
            System.out.println("That ID was not found.");
        }
        return null;
    }

    @Override
    public boolean exists(String ID) {
        String getIDValue;
        try {
            randomAccessFile.seek(0);
            do{
                //if getID returns a null value. retrun false.
                if(((getIDValue = getID()) == null )) {
                   return false;
                }
            } while(getIDValue != ID);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String get(String ID) {
        return null;
    }
}
