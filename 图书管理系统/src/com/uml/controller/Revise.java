package com.uml.controller;

import com.uml.bean.Password;
import com.uml.menu.Menu1;
import com.uml.service.impl.PasswordServiceImpl;
import java.io.*;
import java.util.List;

public class Revise {
    public boolean revice(Password ps,String password,String choose) throws IOException {
        List<Password> list = PasswordServiceImpl.getAllPasswoed();
        boolean flag = false;
        for(int i = 0;i< list.size();i++){
            Password item = list.get(i);
           if(ps.getUsername().equals(item.getUsername()) && item.getPassword().equals(password)){
                list.set(i,ps);
                System.out.println("修改成功");
                flag = true;
                break;
            }
        }
        if(flag == false) {
            System.out.println("原密码不正确,请重新输入");
            new Menu1().menu_revice(ps,choose);
        }
        writepassword(list,choose);
        if(flag == true){
            new Menu1().menu_newrand(choose);
        }
        return flag;
    }
    public void writepassword(List<Password> list,String choose) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(choose));
        BufferedWriter br = new BufferedWriter(fileWriter);
        for (Password ps : list){
            br.write(ps.getUsername()+"="+ps.getPassword() + "\n");
        }
        if( br != null){
            br.close();
        }
    }
}
