package com.uml.controller;

import com.uml.bean.Checkout;
import com.uml.menu.Menu1;
import com.uml.service.impl.CheckBookServicelmpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdministratorsBook {
    public void administratorsbook() throws IOException {
        boolean opt = false;
        List<Checkout> list = CheckBookServicelmpl.getAllCheckBook();
        System.out.println("借阅情况:");
        for (int i = 0;i<list.size();i++) {
            Checkout ch = list.get(i);
            opt = true;
            System.out.println(ch);
        }
        if(!opt){
            System.out.println("没有借阅情况");
        }
        choose();
    }
    public void browse() throws IOException {
        boolean opt = false;
        List<Checkout> list = CheckBookServicelmpl.getAllCheckBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询借阅情况的书名");
        String name = sc.next();
        System.out.println("该书被借阅的情况为:");
        for (int i = 0;i<list.size();i++) {
            Checkout ch = list.get(i);
            if(ch.getName().equals(name)){
                System.out.println(ch);
                opt = true;
            }else{
                continue;
            }
        }
        if(!opt){
            System.out.println("该书没有被借阅");
        }
        choose();
    }
    public void choose() throws IOException {
        boolean opt = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("按q退出,按f返回");
        String s = sc.next();
        while ( opt ) {
            if (s.equals("q")) {
                opt = false;
                System.exit(0);
            } else if (s.equals("f")) {
                opt = true;
                new Menu1().administrators();
            } else {
                System.out.println("输入错误,请重新输入");
            }
        }
    }
}
