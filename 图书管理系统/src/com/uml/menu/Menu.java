package com.uml.menu;

import com.uml.bean.Password;
import com.uml.controller.Rand;
import com.uml.controller.Regist;
import com.uml.controller.Revise;
import com.uml.utils.GlobalConst;
import com.uml.utils.Init;


import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Regist r = new Regist();
    Rand l = new Rand();
    Revise rv = new Revise();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        new Init().init();//初始化
        new Menu().menu(scanner);
    }
    public void menu(Scanner scanner) throws IOException {
        boolean bl = true;
        System.out.println("欢迎使用图书管理系统");
        System.out.println("*********************");
        System.out.println("1.管理员");
        System.out.println("2.普通用户");
        System.out.println("q.退出");
        System.out.println("*********************");
        while (bl){
            String opt = scanner.next();
            switch ( opt ){
                case "1":
                    String choose1 = GlobalConst.ADMINISTRATORS;
                    MenuTop_A(scanner,choose1);
                    bl = false;
                    break;
                case "2":
                    String choose2 = GlobalConst.USER;
                    MenuTop_U(scanner,choose2);
                    bl = false;
                    break;
                case "q":
                    System.exit(0);
                    bl = false;
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
                    break;
            }
        }
    }
    public void MenuTop_A(Scanner scanner ,String choose) throws IOException {//管理员操作菜单
        boolean bl = true;
        System.out.println("*********************");
        System.out.println("1.登录系统");
        System.out.println("2.修改密码");
        System.out.println("q.退出系统");
        System.out.println("请按键选择，回车确定");
        System.out.println("*********************");
        while (bl) {
            String opt = scanner.next();
            switch (opt) {
                case "1":
                    Menu_land(scanner,choose);//调用登录界面
                    bl = false;
                    break;
                case "2":
                    Menu_revise(scanner,choose);
                    bl = false;
                    break;
                case "q":
                    System.out.println("系统退出中,感谢您的使用O(∩_∩)O");
                    System.exit(0);
                    bl = false;
                    break;
                default:
                    System.out.println("输入错误,请重新输入!");
                    break;
            }
        }
    }
    public void MenuTop_U(Scanner scanner ,String choose) throws IOException {
        boolean bl = true;
        System.out.println("*********************");
        System.out.println("1.登录系统");
        System.out.println("2.创建账号");
        System.out.println("3.修改密码");
        System.out.println("4.退出系统");
        System.out.println("请按键选择，回车确定");
        System.out.println("*********************");
        while (bl) {
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    Menu_land(scanner,choose);
                    bl = false;
                    break;
                case 2:
                    Menu_regist(scanner,choose);
                    bl = false;
                    break;
                case 3:
                    Menu_revise(scanner,choose);
                    bl = false;
                    break;
                case 4:
                    System.out.println("系统退出中,感谢您的使用O(∩_∩)O");
                    System.exit(0);
                    bl = false;
                    break;
                default:
                    System.out.println("输入错误,请重新输入!");
                    break;
            }
        }
    }
    public void Menu_land(Scanner scanner,String choose) throws IOException {
        System.out.println("登录");
        System.out.println("*********************");
        System.out.println("请输入账号:");
        String username = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();
        if(l.rand(username,password,choose)){//调用判断是否存在该用户名的函数
            new Menu1().menu_book();//如果登录成功,调用图书管理界面
        }
    }
    public void Menu_regist(Scanner scanner,String choose) throws IOException {
        System.out.println("注册");
        System.out.println("*********************");
        System.out.println("请输入账号:");
        String username = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();
        Password ps = new Password(username,password);
        r.regist(ps,choose);
    }
    public void Menu_revise(Scanner scanner,String choose) throws IOException {
        System.out.println("修改密码");
        System.out.println("*********************");
        System.out.println("请输入账号:");
        String username = scanner.next();
        System.out.println("请输入原密码:");
        String password = scanner.next();
        System.out.println("请输入新密码");
        String newpassword = scanner.next();
        Password ps = new Password(username,newpassword);
        rv.revice(ps,password,choose);
    }
}
