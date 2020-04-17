package com.uml.service.impl;

import com.uml.bean.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*将文件读出来存到集合里面*/
public class AddBookServiceImpl {
    public static List<Book> getAllAddBook() throws IOException {
        File file = new File("book.txt");
        List<Book> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        Book book = null;
        String line = "";
        while ((line = br.readLine()) != null) {
            book = new Book();
            String[] s = line.split("=");
            book.setNum(s[0]);
            book.setName(s[1]);
            book.setAut(s[2]);
            book.setPub(s[3]);
            book.setCat(s[4]);
            book.setMany(Integer.parseInt(s[5]));
            book.setPrice(Double.parseDouble(s[6]));
            list.add(book);
        }
        if(br != null){
            br.close();
        }
        return list;
    }
}
