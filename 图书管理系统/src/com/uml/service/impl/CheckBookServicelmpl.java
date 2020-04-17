package com.uml.service.impl;


import com.uml.bean.Checkout;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CheckBookServicelmpl {
    public static List<Checkout> getAllCheckBook() throws IOException {
        File file = new File("checkout.txt");
        List<Checkout> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        Checkout out = null;
        String line = "";
        while ((line = br.readLine()) != null) {
            out = new Checkout();
            String[] s = line.split("=");
            out.setName(s[0]);
            out.setId(s[1]);
            out.setTime(s[2]);
            out.setBname(s[3]);
            list.add(out);
        }
        if(br != null){
            br.close();
        }
        return list;
    }

}
