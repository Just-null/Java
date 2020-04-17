package com.uml.utils;
import java.io.File;
import java.io.IOException;

public class Init {
    public void init() throws IOException {
        genA();
        genB();
        genC();
        genU();
    }
    public static void genC() throws IOException {
        File ch = new File(GlobalConst.CHECKOUT);
        if(!ch.exists()) {
            ch.createNewFile();
        }

    }
    public static void genB() throws IOException {
        File db = new File(GlobalConst.BOOK);
        if(!db.exists()) {
            db.createNewFile();
        }

    }
    public static void genU() throws IOException {
        File db = new File(GlobalConst.USER);
        if(!db.exists()) {
            db.createNewFile();
        }

    }
    public static void genA() throws IOException {
        File db = new File(GlobalConst.ADMINISTRATORS);
        if(!db.exists()) {
            db.createNewFile();
        }

    }
}
