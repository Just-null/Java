package com.uml.bean;

public class Checkout {
    private String name;//书名
    private String id;//借书证号
    private String time;//借书时间
    private String bname;//借阅者名字
    public Checkout(){

    }
    public Checkout(String name,String id,String time,String bname){
        this.bname = bname;
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
    public String toString(){
        return "姓名:"+bname+"\t"+"借书时间:"+time+"\t"+"借书证号:"+id+"\t"+"书名:"+name;
    }
}
