package com.uml.controller;

import com.uml.bean.Book;
import com.uml.menu.Menu1;
import com.uml.service.impl.InspectBook;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddBook {
    private String num;//书号
    private String name;//书名
    private String aut;//作者
    private String pub;//出版社
    private String cat;//类别
    private int many;//进库量
    private double price;//单价
    public void addbook(Scanner sc) throws IOException {
        InspectBook ina = new InspectBook();
        boolean opt = true;
        while ( opt ) {
            Book b = new Book();
            System.out.println("请输入书号:");
            num = sc.next();
            b.setNum(num);
            System.out.println("请输入书名");
            name = sc.next();
            b.setName(name);
            System.out.println("请输入作者");
            aut = sc.next();
            b.setAut(aut);
            System.out.println("请输入出版社");
            pub = sc.next();
            b.setPub(pub);
            System.out.println("请输入类别");
            cat = sc.next();
            b.setCat(cat);
            System.out.println("请输入进库量");
            many = sc.nextInt();
            b.setMany(many);
            System.out.println("请输入单价");
            price = sc.nextDouble();
            b.setPrice(price);
            if (!ina.Inspect_addbook(b, many)) {
                String info = b.getNum() + "=" + b.getName() + "=" + b.getAut() + "=" + b.getPub() + "=" + b.getCat() + "=" + b.getMany() + "=" + b.getPrice();
                File file = new File("book.txt");
                FileWriter fileWriter = new FileWriter(file, true);//  追加写入
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write(info);
                bw.newLine();
                bw.flush();
                bw.close();
                System.out.println("添加成功");
            }
            System.out.println("是否继续增加(Y/N)");
            String s = sc.next();
            if(s.equals("Y") || s.equals("y")){
                opt = true;
            }else{
                new Menu1().menu_tsmenu();//返回上一层
                opt = false;
            }
        }
    }
}
