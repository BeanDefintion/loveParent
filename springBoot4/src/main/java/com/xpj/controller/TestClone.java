package com.xpj.controller;

import java.io.*;
import java.time.LocalDateTime;

public class TestClone implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // TODO Auto-generated method stub

        Address address = new Address("自古", "很健康", "到家了", LocalDateTime.now());
        System.err.println("1----" + address.getLocalDateTime());
        Employee employee = new Employee("行景", 122, address);
        Employee employee2 = employee.clone();
        employee2.getAddress().setCity("牛牛牛牛牛");
        employee2.getAddress().setLocalDateTime(LocalDateTime.now().minusMonths(1));
        System.err.println(employee.getAddress().getCity());
        System.err.println(employee.getAddress().getLocalDateTime());
        System.err.println(employee2.getAddress().getLocalDateTime());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(address);// 写入的Object类需要实现Serializable不然会抛出异常
        objectOutputStream.close();// ObjectInputStream与ObjectOutputStream类所读写的对象必须实现Serializable接口，
        //对象中的transient和static类型成员变量不会被读取和写入

        ObjectInputStream ObjectInputStream = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Address address2 = (Address) ObjectInputStream.readObject();
        System.err.println(address2.getCity());// 因为加上了transient,所以序列化出来的是null
        ObjectInputStream.close();

    }

}
