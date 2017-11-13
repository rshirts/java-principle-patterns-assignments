package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public interface Database {

    String getID();

    boolean exists(String ID);

    String get(String ID);
}
