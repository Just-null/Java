package com.uml.controller;

import com.uml.menu.Menu1;
import com.uml.service.impl.InspectBook;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CheckoutBook {
    public void checkoutbook(Scanner sc) throws IOException {
        boolean o = true;
        System.out.println("请输入借阅书名");
        String name = sc.next();
        if(new InspectBook().GetBook(name)) {//查看库存里面是否有该图书
            System.out.println("请输入借书时间");
            String time = sc.next();
            System.out.println("请输入借书证号");
            String id = sc.next();
            System.out.println("请输入借阅者名字");
            String bname = sc.next();
            //写入文件
            String info = name + "=" + id + "=" + time + "=" + bname;
            File file = new File("checkout.txt");
            FileWriter fileWriter = new FileWriter(file, true);//  追加写入
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(info);
            bw.newLine();
            bw.flush();
            bw.close();
            if(new InspectBook().check(name)) {
                System.out.println("借书成功,请在两个月之内归还");
            }
        }else{
            System.out.println("没有该图书");
        }
        System.out.println("请按q退出,按f返回");//提示用户进行操作
        while ( o ) {
            String st = sc.next();
            if (st.equals("q")) {
                System.exit(0);
                o = false;
            } else if (st.equals("f")) {
               new Menu1().menu_jymenu();
            }
        }
    }

}
