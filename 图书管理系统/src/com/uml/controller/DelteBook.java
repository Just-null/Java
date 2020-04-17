package com.uml.controller;

import com.uml.service.impl.InspectBook;
import java.io.IOException;
import java.util.Scanner;

public class DelteBook {
    public void deltebook(Scanner sc) throws IOException {
        System.out.println("请输入删除的书号");
        String num = sc.next();
        System.out.println("请输入要删除该图书的库存:");
        Integer many = sc.nextInt();
        new InspectBook().Inspect_deletbook(num,many);
    }
}
