package com.zwl.backend.one;

import java.io.*;

/**
 * @author zwl
 * @date 2020/10/5 19:26
 * @describe 字符缓冲流...
 */
public class BufferedReaderAndBufferedWriter {
    public static void main(String[] args) throws Exception {
        int methodCode = 3;
        switch (methodCode) {
            case 1:
                System.out.println("普通字符流文件复制");//709ms
                fileReaderAndFileWriter();
                break;
            case 2:
                System.out.println("缓冲字符流文件复制");//0ms
                bufferReaderAndBufferWriter();
                break;
            case 3:
                System.out.println("字符输入缓冲流特有方法readLine");
                bufferReaderReadLine();
            case 4:
                System.out.println("字符输出缓冲流特有方法newLine");
                bufferWriterNewLine();
        }
    }

    /**
     * 普通字符流文件复制
     * @throws Exception
     */
    public static void fileReaderAndFileWriter() throws Exception {

        FileReader fileReader = new FileReader("./test.zip");//exe文件够大
        FileWriter fileWriter = new FileWriter("./src/main/resources/input/in-2.zip");

        // 记录开始时间
        long start = System.currentTimeMillis();
        // 读写数据
        int len;
        char[] chars = new char[8*1024];
        while ((len = fileReader.read(chars)) != -1) {
            fileWriter.write(chars, 0 , len);
        }

        fileReader.close();
        fileWriter.close();
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:" + (end - start) + " 毫秒");//41ms
    }

    /**
     * 缓冲流文件复制
     * @throws Exception
     */
    public static void bufferReaderAndBufferWriter() throws Exception {
        //构造方式一： 创建字符缓冲输入流【但是开发中一般常用下面的格式申明】
        FileReader fileInputStream = new FileReader("./test.zip");
        BufferedReader bufferedReader = new BufferedReader(fileInputStream);

        //创建字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/output/out-2.txt"));
        ///创建字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/resources/input/in-1.zip"));
        // 记录开始时间
        long start = System.currentTimeMillis();

        // 读写数据
        int len;
        char[] chars = new char[8*1024];
        while ((len = br.read(chars)) != -1) {
            bw.write(chars, 0 , len);
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流使用数组复制时间:"+(end - start)+" 毫秒");//0ms
    }

    /**
     * 字符缓冲流特有方法
     * BufferedReader：public String readLine(): 读一行数据。 读取到最后返回null
     */
    public static void bufferReaderReadLine()throws Exception{
        // 创建流对象
        BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/output/out-1.txt"));
        // 定义字符串,保存读取的一行文字
        String line;
        // 循环读取,读取到最后返回null
        while ((line = br.readLine())!=null) {
            System.out.print(line);
        }
        // 释放资源
        br.close();
    }

    /**
     * 字符缓冲输出流特有方法
     * BufferedWriter：public void newLine(): 换行,由系统属性定义符号。
     * @throws Exception
     */
    public static void bufferWriterNewLine() throws Exception{
        // 创建流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/resources/output/out-13.txt"));
        // 写出数据
        bw.write("一");
        // 写出换行
        bw.newLine();
        bw.write("给");
        bw.newLine();
        bw.write("我");
        bw.newLine();
        bw.write("里giao");
        bw.newLine();
        // 释放资源
        bw.close();
    }
}
