package com.zwl.backend.two;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

/**
 * @author zwl
 * @date 2020/10/6 12:43
 * @describe  从字节输入流中读取键值对...
 */
public class PropertiesPractice {
    public static void main(String[] args) throws Exception {
        int methodCode = 2;
        switch (methodCode) {
            case 1:
                System.out.println("properties常用方法");
                propertiesMethods();
                break;
            case 2:
                System.out.println("properties读取字节输入流数据");
                getPropertiesByStream();
        }
    }

    /**
     * 常用方法
     */
    public static void propertiesMethods(){
        // 创建属性集对象
        Properties properties = new Properties();
        // 添加键值对元素
        properties.setProperty("filename", "a.txt");
        properties.setProperty("length", "209385038");
        properties.setProperty("location", "D:\\a.txt");
        // 打印属性集对象
        System.out.println(properties);
        // 通过键,获取属性值
        System.out.println(properties.getProperty("filename"));
        System.out.println(properties.getProperty("length"));
        System.out.println(properties.getProperty("location"));

        // 遍历属性集,获取所有键的集合
        Set<String> strings = properties.stringPropertyNames();
        // 打印键值对
        for (String key : strings ) {
            System.out.println(key+" -- "+properties.getProperty(key));
        }

    }

    /**
     *  从字节输入流中读取键值对
     * @throws Exception
     */
    public static void getPropertiesByStream()throws Exception{
        // 创建属性集对象
        Properties pro = new Properties();
        // 加载文本中信息到属性集
        pro.load(new FileInputStream("./src/main/resources/properties.txt"));
        // 遍历集合并打印
        Set<String> strings = pro.stringPropertyNames();
        for (String key : strings ) {
            System.out.println(key+" -- "+pro.getProperty(key));
        }
    }
}
