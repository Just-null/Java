package com.uml.service.impl;

import com.uml.bean.Password;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class PasswordServiceImpl {
    public static List<Password> getAllPasswoed() throws IOException {
        File file = new File("user.txt");
        List<Password> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] splist = line.split("=");
            Password ps = new Password(splist[0],splist[1]);
            list.add(ps);
        }
        if(br != null){
            br.close();
        }
        return list;
    }
}
