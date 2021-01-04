package com.zwl.backend.entity;

import java.io.Serializable;

/**
 * @author zwl
 * @date 2020/10/6 11:51
 * @describe 用做序列化和反序列化...
 */
public class SerializableClass implements Serializable {
    public String name;
    public String address;
    public transient int age; // transient瞬态修饰成员,不会被序列化
    public void addressCheck() {
        System.out.println("Address  check : " + name + " -- " + address);
    }

    public SerializableClass(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public SerializableClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
