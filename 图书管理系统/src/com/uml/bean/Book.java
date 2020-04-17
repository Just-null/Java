package com.uml.bean;

public class Book {
    private String num;//书号
    private String name;//书名
    private String aut;//作者
    private String pub;//出版社
    private String cat;//类别
    private Integer many;//进库量
    private Double price;//单价
    public Book(){

    }
    public Book(String num,String name,String aut,String pub,String cat,Integer many,Double price){
        this.aut = aut;
        this.cat = cat;
        this.many = many;
        this.name = name;
        this.num = num;
        this.price = price;
        this.pub = pub;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAut() {
        return aut;
    }

    public void setAut(String aut) {
        this.aut = aut;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Integer getMany() {
        return many;
    }

    public void setMany(Integer many) {
        this.many = many;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String toString(){
        return "书号:"+num+"\t"+"书名:"+name+"\t"+"作者:"+aut+"\t"+"出版社:"+pub+"\t"+"类别:"+cat+"\t"+"进库量:"+many+"\t"+"单价:"+price;
    }
}
