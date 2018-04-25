package com.xpj.controller;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Address implements Cloneable, Serializable { // 如果不继承Cloneable就使用clone方法(Object类中有的方法)会抛出CloneNotSupportedException异常；

    private String state;
    private String province;
    private transient String city;
    private LocalDateTime localDateTime;// 惊讶地发现LocalDate相关类竟然是线程安全且不可变类，浅克隆完全搞得定；
    // private LocalDateTime(LocalDate date, LocalTime time) {私有的构造方法
    // public final class LocalDateTime 加上final的修饰的类

    public Address(String state, String province, String city, LocalDateTime dateTime) {
        this.state = state;
        this.province = province;
        this.city = city;
        this.localDateTime = dateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    protected Address clone() throws CloneNotSupportedException {
        // 因为Address类本身是一个可变类型，所以为了在Employee类中实现深克隆必须也要在Address中实现克隆
        //如果是date/timestamp类的话也要进行克隆 address.date=(Date)this.date.clone() 因为所有的类都是Object的子类
        Address address = (Address) super.clone();
        return address;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
