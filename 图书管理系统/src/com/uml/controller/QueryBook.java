package com.uml.controller;

import com.uml.service.impl.InspectBook;

import java.io.IOException;
import java.util.Scanner;

public class QueryBook {
    public void querybook(Scanner sc) throws IOException {
        System.out.println("请输入需要查询的书的名字");
        String name = sc.next();
        boolean opt = new InspectBook().GetBook(name);
        if(opt == false){
            System.out.println("没有该图书信息");
        }
        new InspectBook().choose();
    }
}
