package com.zwl.backend.one;

import com.zwl.backend.entity.SerializableClass;

import java.io.*;
import java.util.ArrayList;

/**
 * @author zwl
 * @date 2020/10/6 11:49
 * @describe 对象的序列化和反序列化...
 */
public class ObjectInputStreamAndObjectOutputStream {
    public static void main(String[] args) throws Exception {
        int methodCode = 4;
        switch (methodCode) {
            case 1:
                System.out.println("序列化对象");
                objectOutputStream();
                break;
            case 2:
                System.out.println("反序列化对象");
                objectInputStream();
                break;
            case 3:
                System.out.println("序列化集合对象");
                objectOutputStreamList();
                break;
            case 4:
                System.out.println("反序列化集合对象");
                objectInputStreamList();
                break;

        }
    }

    /**
     * 将Java对象的原始数据类型写出到文件,实现对象的持久存储。
     * public final void writeObject (Object obj) : 将指定的对象写出。
     * @throws Exception
     */
    public static void objectOutputStream()throws Exception{
        SerializableClass e = new SerializableClass();
        e.name = "zwl";
        e.address = "好好学习，天天向上";
        e.age = 88;

        //创建序列化流对象
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("./src/main/resources/output/SerializableClass.txt"));
        // 写出对象
        objectOutputStream.writeObject(e);
        // 释放资源
        objectOutputStream.close();

        System.out.println("Serialized data is saved"); // 姓名，地址被序列化，年龄没有被序列化。
    }

    /**
     * 将之前使用ObjectOutputStream序列化的原始数据恢复为对象。
     * 对于JVM可以反序列化对象，它必须是能够找到class文件的类。如果找不到该类的class文件，则抛出一个 ClassNotFoundException 异常。
     * @throws Exception
     */
    public static void objectInputStream()throws Exception{
        SerializableClass e = null;
        // 创建反序列化流
        FileInputStream fileIn = new FileInputStream("./src/main/resources/output/SerializableClass.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileIn);
        // 读取一个对象
        e = (SerializableClass) objectInputStream.readObject();
        // 释放资源
        objectInputStream.close();
        fileIn.close();

        // 无异常,直接打印输出
        System.out.println("Name: " + e.name);	// zhangsan
        System.out.println("Address: " + e.address); // beiqinglu
        System.out.println("age: " + e.age); // 0
    }

    /**
     * 序列化集合
     * @throws Exception
     */
    public static void objectOutputStreamList()throws Exception{
        // 创建 学生对象
        SerializableClass student = new SerializableClass("老王", "laow");
        SerializableClass student2 = new SerializableClass("老张", "laoz");
        SerializableClass student3 = new SerializableClass("老李", "laol");

        ArrayList<SerializableClass> arrayList = new ArrayList();
        arrayList.add(student);
        arrayList.add(student2);
        arrayList.add(student3);

        // 创建 序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/main/resources/output/SerializableClassList.txt"));
        // 写出对象
        oos.writeObject(arrayList);
        // 释放资源
        oos.close();
    }

    /**
     * 反序列化集合
     * @throws Exception
     */
    public static void objectInputStreamList()throws Exception{
        // 反序列化
        ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("./src/main/resources/output/SerializableClassList.txt"));
        // 读取对象,强转为ArrayList类型
        ArrayList<SerializableClass> list  = (ArrayList<SerializableClass>)ois.readObject();

        for (int i = 0; i < list.size(); i++ ){
            SerializableClass s = list.get(i);
            System.out.println(s.getName()+"--"+ s.getAddress());
        }
    }
}
