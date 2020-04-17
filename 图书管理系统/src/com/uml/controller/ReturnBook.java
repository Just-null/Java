package com.uml.controller;

import com.uml.bean.Book;
import com.uml.bean.Checkout;
import com.uml.service.impl.AddBookServiceImpl;
import com.uml.service.impl.CheckBookServicelmpl;
import com.uml.utils.GlobalConst;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ReturnBook {
    public void returnbook(Scanner sc) throws IOException {
        boolean opt = true;
        while ( opt ){
            System.out.println("请输入所还的书本名");
            String name = sc.next();
            System.out.println("请输入证号");
            String id = sc.next();
            if(returnbooks(name) && rebook(name,id))
            {
                System.out.println("还书成功");
            }else{
                System.out.println("信息不正确,还书失败");
            }
            System.out.println("是否继续还书(Y/N)");
            String s = sc.next();
            if(s.equals("Y") || s.equals("y")){
                opt = true;
            }else{
                opt = false;
            }
        }
    }
    public boolean returnbooks(String name) throws IOException {
        boolean flag = false;
        int item_Many = -1;
        List<Book> list1 = AddBookServiceImpl.getAllAddBook();
        for(int i = 0;i< list1.size();++i){
            Book item = list1.get(i);
            if(name.equals(item.getName())){//如果书号相同
                item_Many = item.getMany()+1;
                Book ps = new Book(item.getNum(), item.getName(), item.getAut(), item.getPub(), item.getCat(), item_Many, item.getPrice());
                list1.set(i, ps);
                flag = true;
                break;
            }
        }
        writebook(list1);
        return flag;
    }
    public void writebook(List<Book> list) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(GlobalConst.BOOK));
        BufferedWriter br = new BufferedWriter(fileWriter);
        for (Book ps : list){
            br.write(ps.getNum()+"="+ps.getName()+"="+ps.getAut()+"="+ps.getPub()+"="+ps.getCat()+"="+ps.getMany()+"="+ps.getPrice()+ "\n");
        }
        if( br != null){
            br.close();
        }
    }
    public boolean rebook(String name,String id) throws IOException {
        List<Checkout> list = CheckBookServicelmpl.getAllCheckBook();
        boolean flag = false;
        for(int i = 0;i<list.size();i++){
            Checkout ch = list.get(i);
            if(name.equals(ch.getName()) && id.equals(ch.getId())){
                list.remove(i);
                flag = true;
                break;
            }
        }
        writeaut(list);
        return flag;
    }
    public void writeaut(List<Checkout> list) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(GlobalConst.CHECKOUT));
        BufferedWriter br = new BufferedWriter(fileWriter);
        for (Checkout ch : list){
            br.write(ch.getName()+"="+ch.getId()+"="+ch.getTime()+"="+ch.getBname()+"\n");
        }
        if( br != null){
            br.close();
        }
    }
}
