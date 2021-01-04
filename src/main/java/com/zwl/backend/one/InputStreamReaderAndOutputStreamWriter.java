package com.zwl.backend.one;

import java.io.*;

/**
 * @author zwl
 * @date 2020/10/6 11:12
 * @describe 字节流和字符流的转换...
 */
public class InputStreamReaderAndOutputStreamWriter {
    public static void main(String[] args) throws Exception {
        int methodCode = 4;
        switch (methodCode) {
            case 1:
                System.out.println("字节输入流转换成字符流");
                inputStreamReader();
                break;
            case 2:
                System.out.println("字符输出流转换成字节流");
                outputStreamWriter();
                break;
            case 3:
                System.out.println("缓冲字符输入流");
                bufferedReader();
                break;
            case 4:
                System.out.println("缓冲字符输出流");
                bufferWriter();
                break;

        }
    }


    /**
     * 字节流转换成字符流
     * 读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集
     */
    public static void inputStreamReader()throws Exception{
        //字节输入流转换成字符输入流的两种形式：1.直接转换,默认utf-8编码  2.按照指定编码进行转换
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("./src/main/resources/output/out-8.txt"));
        InputStreamReader inputStreamReader1 = new InputStreamReader(new FileInputStream("./src/main/resources/output/out-8.txt") , "GBK");
        //读取数据
        int read;
        while ((read=inputStreamReader.read())!=-1){
            System.out.println("inputStreamReader读取字符："+(char)read);//默认uft-8
        }
        inputStreamReader.close();

        while ((read=inputStreamReader1.read())!=-1){
            System.out.println("inputStreamReader1读取字符："+(char)read);//gbk,出现乱码
        }
        inputStreamReader1.close();
    }

    /**
     * 字符输出流转换为字节流
     * 使用指定的字符集将字符编码为字节。它的字符集可以由名称指定，也可以接受平台的默认字符集。
     */
    public static void outputStreamWriter()throws Exception{
        //字符输出流字转换成节输出流的两种形式：1.直接转换,默认utf-8编码  2.按照指定编码进行转换
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("./src/main/resources/output/out-14.txt"));
        OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(new FileOutputStream("./src/main/resources/output/out-15.txt") , "GBK");

        //写出数据
        outputStreamWriter.write("一给我");
        outputStreamWriter.write("\r\n");
        outputStreamWriter.write("里giaogiao");
        //关闭输出流
        outputStreamWriter.close();

        //写出数据--出现乱码
        outputStreamWriter1.write("一给我");
        outputStreamWriter1.write("\r\n");
        outputStreamWriter1.write("里giaogiao");
        //关闭输出流
        outputStreamWriter1.close();
    }

    /**
     * 为了达到最高效率，可以考虑在 BufferedReader 内包装 InputStreamReader
     * @throws Exception
     */
    public static void bufferedReader()throws Exception{
        //字节输入流转换成字符输入流的两种形式：1.直接转换,默认utf-8编码  2.按照指定编码进行转换
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("./src/main/resources/output/out-8.txt"));
        InputStreamReader inputStreamReader1 = new InputStreamReader(new FileInputStream("./src/main/resources/output/out-8.txt") , "GBK");

        //缓冲流
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        BufferedReader bufferedReader1=new BufferedReader(inputStreamReader1);

        //读取数据
        String line;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println("bufferedReader读取字符："+line);//默认uft-8
        }
        bufferedReader.close();

        while ((line=bufferedReader1.readLine())!=null){
            System.out.println("bufferedReader1读取字符："+line);//gbk,出现乱码
        }
        bufferedReader1.close();
    }

    /**
     * 为了达到最高效率，可以考虑在 BufferedWriter 内包装 OutputStreamReader
     * @throws Exception
     */
    public static void bufferWriter()throws Exception{
        //字符输出流字转换成节输出流的两种形式：1.直接转换,默认utf-8编码  2.按照指定编码进行转换
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("./src/main/resources/output/out-14.txt"));
        OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(new FileOutputStream("./src/main/resources/output/out-15.txt") , "GBK");

        //缓冲字符流
        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
        BufferedWriter bufferedWriter1=new BufferedWriter(outputStreamWriter1);

        //写出数据
        bufferedWriter.write("一给我啊啊啊");
        bufferedWriter.newLine();
        bufferedWriter.write("里giaogiao");
        //关闭输出流
        bufferedWriter.close();

        //写出数据--出现乱码
        bufferedWriter1.write("一给我啊啊啊");
        bufferedWriter1.newLine();
        bufferedWriter1.write("里giaogiao");
        //关闭输出流
        bufferedWriter1.close();
    }
}
