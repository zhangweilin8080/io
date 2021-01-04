package com.zwl.backend.one;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author zwl
 * @date 2020/10/5 15:52
 * @describe 字节输入流与输出流相关子类...
 */
public class InputStreamAndOutputStream {
   /* public static void main(String[] args) throws Exception {
        int methodCode = 2;
        switch (methodCode) {
            case 1:
                System.out.println("文件输出流");
                fileOutputStream();
                break;
            case 2:
                System.out.println("文件输入流");
                fileInputStream();
                break;
            case 3:
                System.out.println("字节流文件拷贝");
                copyByByte();
                break;

        }
    }*/

    /**
     * 文件输出流
     * 文件输出流默认覆盖原文件内容，如需要在原文上进行内容追加，则创建输出流时，添加参数true
     * 创建输出流对象的时候，系统会自动去对应位置创建对应文件，而创建输出流对象的时候，文件不存在则会报FileNotFoundException异常，也就是系统找不到指定的文件异常。
     * 操作完毕后，必须释放系统资源，调用close方法，千万记得
     */
    @Test
    public  void fileOutputStream()throws Exception{
        // 使用File对象创建流对象
        File file=new File("./src/main/resources/output/out-1.txt");

        //创建文件输出流的两种方式
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        FileOutputStream fileOutputStream2=new FileOutputStream("./src/main/resources/output/out-2.txt");//内容覆盖
        FileOutputStream fileOutputStream3=new FileOutputStream("./src/main/resources/output/out-3.txt",true);//内容追加

        //FileOutputStream写出数据的三种形式：1.写出字节 2.写出字节数组 3.写出指定长度字节数组
        //1.写出字节
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);
        // 关闭资源
        fileOutputStream.close();

        //2.写出字节数组
        byte[] bytes="一给我里giaogiao".getBytes();
        fileOutputStream2.write(bytes);
        // 关闭资源
        fileOutputStream2.close();

        //3.写出指定长度字节数组,write(byte[] b, int off, int len) ,每次写出从off索引开始，len个字节
        byte[] bs="一给我里giaogiao".getBytes();
        fileOutputStream3.write(bs,0,3);//从索引0开始写出三个长度的字节
        // 关闭资源
        fileOutputStream3.close();

        //Windows系统里，换行符号是\r\n,回车符：回到一行的开头（return）、换行符：下一行（newline）
        // 使用文件名称创建流对象
        FileOutputStream fos = new FileOutputStream("./src/main/resources/output/out-4.txt");
        // 定义字节数组
        byte[] words = {97,98,99,100,101};
        // 遍历数组
        for (int i = 0; i < words.length; i++) {
            // 写出一个字节
            fos.write(words[i]);
            // 写出一个换行, 换行符号转成数组写出
            fos.write("\r\n".getBytes());
        }
        // 关闭资源
        fos.close();

    }

    /**
     * 字节输入流
     * 创建一个流对象时，必须传入一个文件路径。该路径下，如果没有该文件,会抛出FileNotFoundException
     */
    @Test
    public   void fileInputStream()throws Exception{
        // 使用File对象创建流对象
        File file=new File("./src/main/resources/output/out-1.txt");

        //创建文件输入流的两种方式
        FileInputStream fileInputStream=new FileInputStream(file);
        FileInputStream fileInputStream2=new FileInputStream("./src/main/resources/output/out-2.txt");

        //FileInputStream读取数据的三种形式：1.读取一个字节 2.使用字节数组读取 3.读取指定长度字节数组
        //1.每次读取一个字节
        int read = fileInputStream.read();
        System.out.println((char) read);
        read = fileInputStream.read();
        System.out.println((char) read);
        read = fileInputStream.read();
        System.out.println((char) read);
        read = fileInputStream.read();
        System.out.println((char) read);
        read = fileInputStream.read();
        System.out.println( read);
        // 读取到末尾,返回-1
        read = fileInputStream.read();
        System.out.println( read);
        // 关闭资源
        fileInputStream.close();

        //1.1循环改进读取方式
        int b;
        while ((b=fileInputStream2.read())!=-1){
            System.out.println("循环读取："+(char) b);
        }
        fileInputStream2.close();

        //2.使用字节数组读取,read(byte[] b)，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回-1
        FileInputStream fileInputStream3=new FileInputStream("./src/main/resources/output/out-2.txt");
        byte[] bytes=new byte[3];//一次读取3个字节的数据
        // 定义变量，代表读取字节的有效个数
        int len ;
        while ((len=fileInputStream3.read(bytes))!=-1){
            System.out.println("每次读取并替换后数组中的数据："+new String(bytes)+",其中有效字节长度："+len);//打印每次读取到数组中的数据
        }
        // 关闭资源
        fileInputStream3.close();

    }

    /**
     * 字节流文件拷贝
     * 输入流读取、输出流输出。边读边写
     */
    public static void copyByByte()throws Exception{
        //--------------------------单字节拷贝----------------------------
        // 1、指定数据源
        FileInputStream fileInputStream=new FileInputStream("冲锋.png");
        //2、指定目的地
        FileOutputStream fileOutputStream=new FileOutputStream("./src/main/resources/output/out-5.png");
        int i;
        while ((i=fileInputStream.read())!=-1){
            fileOutputStream.write(i);
        }
        fileInputStream.close();
        fileOutputStream.close();

        //--------------------------字节数组拷贝----------------------------
        // 1.1 指定数据源
        FileInputStream fis = new FileInputStream("冲锋.png");
        // 1.2 指定目的地
        FileOutputStream fos = new FileOutputStream("./src/main/resources/output/out-6.png");

        // 2.读写数据
        // 2.1 定义数组
        byte[] b = new byte[1024];
        // 2.2 定义长度
        int len;
        // 2.3 循环读取
        while ((len = fis.read(b))!=-1) {
            // 2.4 写出数据
            System.out.println("读取有效字节长度："+len);
            fos.write(b, 0 , len);
        }

        // 3.关闭资源
        fis.close();
        fos.close();
    }
}
