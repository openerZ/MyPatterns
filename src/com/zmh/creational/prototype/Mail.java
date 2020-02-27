package com.zmh.creational.prototype;

import java.util.Date;

/**
 * 原型模式：
 *         用于创建重复的对象，同时又能保证性能
 *         通过克隆实现创建重复对象
 *         对于需要多次创建的类继承Cloneable接口，同时重写Object的clone方法
 *
 */
public class Mail implements Cloneable{
    private String name;
    private String emailAddress;
    private String content;

    public Date date = new Date();
    public Mail(){
        System.out.println("Mail Class Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", content='" + content + '\'' +
                '}'+super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail object");
        Mail mail = (Mail) super.clone();
        mail.date = (Date) date.clone();
        return mail;
    }
}
