package com.zwl.backend.one;

import java.io.*;

/**
 * @author zwl
 * @date 2020/10/5 18:02
 * @describe 字符输入流与字符输出流...
 */
public class ReaderAndWriter {
    public static void main(String[] args) throws Exception {
        int methodCode = 3;
        switch (methodCode) {
            case 1:
                System.out.println("文件字符输出流");
                fileWriter();
                break;
            case 2:
                System.out.println("文件字符输入流");
                fileReader();
                break;
            case 3:
                System.out.println("字符流文件拷贝");
                copyByChar();
                break;

        }
    }

    /**
     * 写出字符到文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区
     * @throws Exception
     */
    public static void fileWriter()throws Exception{
        // 使用File对象创建流对象
        File file=new File("./src/main/resources/output/out-7.txt");

        //创建文件输出流的两种方式
        FileWriter fileWriter=new FileWriter(file);
        FileWriter fileWriter1=new FileWriter("./src/main/resources/output/out-8.txt");//内容覆盖
        FileWriter fileWriter2=new FileWriter("./src/main/resources/output/out-9.txt",true);//内容追加

        //FileOutputStream写出数据的三种形式：1.每次写出一个字符 2.写出字符数组 3.写出指定长度字符数组
        //1.写出一个字符
        fileWriter.write(97);
        fileWriter.write('b');
        fileWriter.write('C');
        //关闭资源时,与FileOutputStream不同。 如果不关闭,数据只是保存到缓冲区，并未保存到文件。
        fileWriter.close();

        //2.写出字符数组
        char[] chars={'一','给','我','里','g','i','a','o'};
        fileWriter1.write(chars);
        // 关闭资源
        fileWriter1.close();

        //3.写出指定长度字符数组,write(byte[] b, int off, int len) ,每次写出从off索引开始，len个字节
        fileWriter2.write(chars,0,3);//从索引0开始写出三个长度的字节
        // 关闭资源
        fileWriter2.close();

        //Windows系统里，换行符号是\r\n,回车符：回到一行的开头（return）、换行符：下一行（newline）
        // 使用文件名称创建流对象
        FileWriter fileWriter3 = new FileWriter("./src/main/resources/output/out-10.txt");
        // 定义字节数组
        // 遍历数组
        for (int i = 0; i < chars.length; i++) {
            // 写出一个字节
            fileWriter3.write(chars[i]);
            // 写出一个换行, 换行符号转成数组写出
            fileWriter3.write("\r\n");
        }
        // 关闭资源
        fileWriter3.close();

    }

    /**
     * 读取字符文件的便利类。构造时使用系统默认的字符编码和默认字节缓冲区。
     * @throws Exception
     */
    public  static void fileReader()throws Exception{
        // 使用File对象创建流对象
        File file=new File("./src/main/resources/output/out-1.txt");

        //创建文件输入字符流的两种方式
        FileReader fileReader=new FileReader(file);
        FileReader fileReader1=new FileReader("./src/main/resources/output/out-2.txt");

        //FileInputStream读取数据的三种形式：1.读取一个字符 2.使用字符数组读取 3.读取指定长度字符数组
        //1.每次读取一个字节
        int read = fileReader.read();
        System.out.println((char) read);
        read = fileReader.read();
        System.out.println((char) read);
        read = fileReader.read();
        System.out.println((char) read);
        read = fileReader.read();
        System.out.println((char) read);
        read = fileReader.read();
        System.out.println( read);
        // 读取到末尾,返回-1
        read = fileReader.read();
        System.out.println( read);
        // 关闭资源
        fileReader.close();

        //1.1循环改进读取方式
        int b;
        while ((b=fileReader1.read())!=-1){
            System.out.println("循环读取："+(char) b);
        }
        fileReader1.close();

        //2.使用字节数组读取,read(byte[] b)，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回-1
        FileReader fileReader2=new FileReader("./src/main/resources/output/out-2.txt");
        char[] chars=new char[3];//一次读取3个字节的数据
        // 定义变量，代表读取字节的有效个数
        int len ;
        while ((len=fileReader2.read(chars))!=-1){
            System.out.println("每次读取并替换后数组中的数据："+new String(chars)+",其中有效字符长度："+len);//打印每次读取到数组中的数据
        }
        // 关闭资源
        fileReader2.close();

    }

    /**
     * 字符流文件拷贝
     * 输入流读取、输出流输出。边读边写
     */
    public static void copyByChar()throws Exception{
        //--------------------------单字符拷贝----------------------------
        // 1、指定数据源
        FileReader fileReader=new FileReader("888.txt");
        //2、指定目的地
        FileWriter fileWriter=new FileWriter("./src/main/resources/output/out-11.txt");
        int i;
        while ((i=fileReader.read())!=-1){
            fileWriter.write(i);
        }
        fileReader.close();
        fileWriter.close();

        //--------------------------字符数组拷贝----------------------------
        // 1.1 指定数据源
        FileReader fis = new FileReader("bbb.txt");
        // 1.2 指定目的地
        FileWriter fos = new FileWriter("./src/main/resources/output/out-12.txt");

        // 2.读写数据
        // 2.1 定义数组
        char[] b = new char[1024];
        // 2.2 定义长度
        int len;
        // 2.3 循环读取
        while ((len = fis.read(b))!=-1) {
            // 2.4 写出数据
            System.out.println("读取有效字符长度："+len);
            fos.write(b, 0 , len);
        }

        // 3.关闭资源
        fis.close();
        fos.close();
    }

}
