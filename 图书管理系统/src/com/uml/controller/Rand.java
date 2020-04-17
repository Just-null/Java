package com.uml.controller;
import com.uml.menu.Menu1;
import com.uml.utils.GlobalConst;

import java.io.*;
import java.util.Scanner;

public class Rand {
    private int tool = 0;
    private boolean bl = false;
    public boolean rand(String username,String password,String choose) throws IOException {//登录
        int i = match(username,password,choose);
        if(i == 1){
            System.out.println("登录成功,正在跳转,请稍后-------->");
            if(choose.equals(GlobalConst.USER)){
                new Menu1().menu_book();
            }else {
                new Menu1().administrators();
            }
            bl = true;
        }else if(i == -1){
            System.out.println("密码错误，请重新输入");
            tool++;
            if(Password(username,choose)){
                System.out.println("登录成功,正在跳转,请稍后-------->");
                if(choose.equals(GlobalConst.USER)) {
                    new Menu1().menu_book();
                }else{
                    new Menu1().administrators();
                }
            }else tool++;
            if(tool==2) {
                System.out.println("密码输入错误次数太多,请联系管理员");
            }
        }else if (i==0){
            System.out.println("不存在此用户");
            new Menu1().menu_newrevice(choose);
        }
        return bl;
    }
    public int match(String username,String password,String choose) throws IOException {//判断
        FileReader fileReader = new FileReader(new File(choose));
        BufferedReader br = new BufferedReader(fileReader);
        String line ="";
        while((line = br.readLine()) != null){
            String[] split = line.split("=");
            if(split[0].equals(username) && split[1].equals(password)){
                return 1;
            }else if(split[0].equals(username) && (split[1].equals(password)==false)){
                return -1;
            }
        }
        return 0;
    }
    public boolean Password(String username,String choose) throws IOException {
        FileReader fileReader = new FileReader(new File(choose));
        BufferedReader br = new BufferedReader(fileReader);
        Scanner sc= new Scanner(System.in);
        System.out.println("请重新输入密码:");
        String password = sc.next();
        String pw = "";
        while ((pw = br.readLine()) != null){
            String[] sp = pw.split("=");
            if(sp[0].equals(username)){
                sp[1].equals(password);
                return true;
            }
        }
        return false;
    }

}
