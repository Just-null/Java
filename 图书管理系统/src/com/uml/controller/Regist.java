package com.uml.controller;

import com.uml.bean.Password;
import com.uml.menu.Menu1;
import com.uml.service.impl.InspectRegise;
import com.uml.utils.GlobalConst;

import java.io.*;

public class Regist {
    InspectRegise inspect = new InspectRegise();
    public void regist(Password ps,String choose) throws IOException {
        File file = new File(choose);
        String info = ps.getUsername() + "=" + ps.getPassword();
        boolean opt = inspect.Inspect(ps.getUsername(),choose);
        if(opt){//没有被注册
            FileWriter fileWriter = new FileWriter(file, true);//  追加写入
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(info);
            bw.newLine();
            bw.flush();
            bw.close();
            System.out.println("注册成功--正在跳转,请稍后---");
            if(choose.equals(GlobalConst.USER)) {
                new Menu1().menu_book();//图书系统主界面
            }else{
                new Menu1().administrators();//管理员操作界面
            }
        }
    }
}
