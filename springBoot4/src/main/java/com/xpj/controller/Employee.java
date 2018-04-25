package com.xpj.controller;

public class Employee implements Cloneable {

    private String name;
    private Integer age;
    private Address address;

    public Employee(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        Employee emploee = (Employee) super.clone();
        emploee.address = address.clone();//Adress可变，所以要先克隆他
        return emploee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
