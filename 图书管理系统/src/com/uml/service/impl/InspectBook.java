package com.uml.service.impl;

import com.uml.bean.Book;
import com.uml.menu.Menu1;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InspectBook {
    Scanner sc = new Scanner(System.in);
    public boolean Inspect_addbook(Book b,Integer many) throws IOException {
        List<Book> list = AddBookServiceImpl.getAllAddBook();
        boolean flag = false;
        for(int i = 0;i< list.size();i++){
            Book item = list.get(i);
            if(b.getNum().equals(item.getNum())&& b.getName().equals(item.getName())&&b.getCat().equals(item.getCat())&&b.getPub().equals(item.getPub())&&b.getPrice().intValue()==item.getPrice().intValue()){//如果书号相同,书名相同,作者相同,-----
                Book ps = new Book(item.getNum(),item.getName(),item.getAut(),item.getPub(),item.getCat(),(item.getMany()+many),item.getPrice());
                list.set(i,ps);
                System.out.println("添加成功");
                flag = true;
                break;
            }
        }
        writebook(list);
        return flag;
    }
    public void Inspect_deletbook(String num,int many) throws IOException {
        boolean opt = true;
        boolean flag = false;
        int item_Many = -1;
        List<Book> list1 = AddBookServiceImpl.getAllAddBook();
        for(int i = 0;i< list1.size();++i){
            Book item = list1.get(i);
            if(num.equals(item.getNum())){//如果书号相同,删除
                if(many <= item.getMany()){
                    item_Many = item.getMany()- many;
                }else{
                    while( opt ) {
                        System.out.println("该书号的图书只有" + item.getMany() + "本,请重新输入需要删除的库存量");

                        Integer m = sc.nextInt();
                        if (m<=item.getMany()){
                            item_Many = item.getMany()-m;
                            opt = false;
                        }else{
                            opt = true;
                        }
                    }
                }
                if(item_Many == 0){
                    list1.remove(i);
                    flag = true;
                    System.out.println("删除成功");
                    break;
                }else if(item_Many > 0){
                    Book ps = new Book(item.getNum(), item.getName(), item.getAut(), item.getPub(), item.getCat(), item_Many, item.getPrice());
                    list1.set(i, ps);
                    flag = true;
                    System.out.println("删除成功");
                    break;
                }
            }
        }
        if(flag == false){
            System.out.println("删除失败,没有该图书");
        }else {
            writebook(list1);
        }
        choose();
    }
    public boolean GetBook(String name) throws IOException {
        List<Book> list2 = AddBookServiceImpl.getAllAddBook();
        boolean opt = false;
        for(int i = 0;i<list2.size();i++){
            Book item = list2.get(i);
            if(name.equals(item.getName())){
                System.out.println("该图书的信息是:");
                System.out.println(item);
                opt = true;
                break;
            }
        }
        return opt;
    }
    public boolean check(String name) throws IOException {
        boolean flag = false;
        int item_Many = -1;
        List<Book> list1 = AddBookServiceImpl.getAllAddBook();
        for(int i = 0;i< list1.size();++i){
            Book item = list1.get(i);
            if(name.equals(item.getName())){//如果书号相同
                    item_Many = item.getMany()-1;
                    Book ps = new Book(item.getNum(), item.getName(), item.getAut(), item.getPub(), item.getCat(), item_Many, item.getPrice());
                    list1.set(i, ps);
                    flag = true;
                    break;
                }
            }
        writebook(list1);
        return flag;
    }
    public void Browse() throws IOException {
        List<Book> list = AddBookServiceImpl.getAllAddBook();
        Iterator<Book> it = list.iterator();
        System.out.println("图书信息为");
        System.out.println("------------------------------------------------------------------------");
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("------------------------------------------------------------------------");
        choose();
    }
    public void writebook(List<Book> list) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("book.txt"));
        BufferedWriter br = new BufferedWriter(fileWriter);
        for (Book ps : list){
            br.write(ps.getNum()+"="+ps.getName()+"="+ps.getAut()+"="+ps.getPub()+"="+ps.getCat()+"="+ps.getMany()+"="+ps.getPrice()+ "\n");
        }
        if( br != null){
            br.close();
        }
    }
    public void choose() throws IOException {
        System.out.println("q:退出------f:返回");
        String x = sc.next();
        if(x.equals("q")){
            System.exit(0);
        }else{
            new Menu1().menu_tsmenu();
        }
    }
}
