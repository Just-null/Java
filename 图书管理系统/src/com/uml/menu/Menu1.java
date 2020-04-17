package com.uml.menu;

import com.uml.bean.Password;
import com.uml.controller.*;
import com.uml.service.impl.InspectBook;

import java.io.IOException;
import java.util.Scanner;

public class Menu1 {
    Scanner sc = new Scanner(System.in);
    public  void menu_revice(Password ps,String choose) throws IOException {
        Revise rb = new Revise();
        System.out.println("请再次输入原密码");
        String password = sc.next();
        rb.revice(ps,password,choose);
    }
    public void menu_revise(String  choose) throws IOException {
        System.out.println("继续注册请按1,退出请按q");
        String op = sc.nextLine();
        switch ( op ){
            case "1":
                new Menu().Menu_regist(sc,choose);
                break;
            case "q":
                System.exit(0);
                break;
            default:
                System.exit(0);
                break;
        }
    }
    public void menu_book() throws IOException {
        System.out.println("*********************");
        System.out.println("1.图书系统");
        System.out.println("2.借阅系统");
        System.out.println("q.退出系统");
        System.out.println("请选择");
        System.out.println("*********************");
        String opt = sc.next();
        switch ( opt ){
            case "1":
                menu_tsmenu();
                break;
            case "2":
                menu_jymenu();
               break;
            case "q":
                System.exit(0);
                break;
        }
    }
    public void menu_newrevice(String choose) throws IOException {
        System.out.println("注册请按1,退出系统请按q");
        String i = sc.next();
        switch ( i ){
            case "1":
                new Menu().Menu_regist(sc,choose);
                break;
            case "q":
                System.exit(0);
                break;
        }
    }
    public void menu_newrand(String choose) throws IOException {
        System.out.println("登录请按1,退出系统请按q");
        String i = sc.next();
        switch ( i ){
            case "1":
                new Menu().Menu_land(sc,choose);
                break;
            case "q":
                System.exit(0);
                break;
        }
    }
    public void menu_tsmenu() throws IOException {
        boolean w = true;
        System.out.println("*********************");
        System.out.println("1.增加图书");
        System.out.println("2.删除图书");
        System.out.println("3.查询图书");
        System.out.println("4.库存浏览");
        System.out.println("5.返回上一层");
        System.out.println("q.退出系统");
        System.out.println("*********************");
        while ( w ) {
            String opt = sc.next();
            switch (opt) {
                case "1":
                    new AddBook().addbook(sc);
                    w = false;
                    break;
                case "2":
                    new DelteBook().deltebook(sc);
                    w = false;
                    break;
                case "3":
                    new QueryBook().querybook(sc);
                    w = false;
                    break;
                case "4":
                    new InspectBook().Browse();
                    w = false;
                    break;
                case "5":
                    menu_book();
                    w = false;
                    break;
                case "q":
                    System.exit(0);
                    w = false;
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
                    break;
            }
        }
    }
    public void menu_jymenu() throws IOException {
        System.out.println("*********************");
        System.out.println("1.借书登记");
        System.out.println("2.还书登记");
        System.out.println("f.返回上一层");
        System.out.println("q.退出");
        System.out.println("*********************");
        boolean f = true;
        while ( f ){
            String opt = sc.next();
            switch ( opt ){
                case "1":
                    new CheckoutBook().checkoutbook(sc);
                    f = false;
                    break;
                case "2":
                   new ReturnBook().returnbook(sc);
                    f = false;
                    break;
                case "f":
                    menu_book();
                    f = false;
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("请正确输入您的选择");
                    break;
            }
        }
    }
    public void administrators() throws IOException {
        System.out.println("*********************");
        System.out.println("1.借阅情况");//管理员
        System.out.println("2.查询借书");//管理员
        System.out.println("q.退出");
        System.out.println("*********************");
        boolean f = true;
        while ( f ){
            String opt = sc.next();
            switch ( opt ){
                case "1":
                    new AdministratorsBook().administratorsbook();
                    f = false;
                    break;
                case "2":
                    new AdministratorsBook().browse();
                    f = false;
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("请正确输入您的选择");
                    break;
            }
        }
    }
}
