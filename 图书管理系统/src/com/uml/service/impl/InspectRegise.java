package com.uml.service.impl;
import com.uml.bean.Password;
import com.uml.menu.Menu1;
import java.io.*;
import java.util.List;
public class InspectRegise {
    Menu1 me = new Menu1();
    public boolean Inspect(String username,String choose) throws IOException {
        File file = new File(choose);
        List<Password> list = PasswordServiceImpl.getAllPasswoed();
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] splist = line.split("=");
            Password ps = new Password(splist[0],splist[1]);
            list.add(ps);
        }
        for (Password pst:list)
        {
            if(username.equals(pst.getUsername())){
                System.out.println("该账号已经被注册,请重新核对你的账号!");
                me.menu_revise(choose);
                return false;
            }
        }
        return true;
    }
}
