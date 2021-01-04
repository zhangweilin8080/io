package com.zwl.backend.one;

import java.io.*;

/**
 * @author zwl
 * @date 2020/10/5 19:10
 * @describe 字节缓冲流...
 */
public class BufferedInputStreamAndBufferedOutputStream {
    public static void main(String[] args) throws Exception {
        int methodCode = 2;
        switch (methodCode) {
            case 1:
                System.out.println("普通字节流文件复制");
                inputStreamAndOutputStream();
                break;
            case 2:
                System.out.println("缓冲字节流文件复制");
                bufferInputStreamAndBufferOutputStream();
                break;

        }
    }

    /**
     * 普通字节流文件复制
     * @throws Exception
     */
    public static void inputStreamAndOutputStream() throws Exception {

        FileInputStream fis = new FileInputStream("./test.zip");//exe文件够大
        FileOutputStream fos = new FileOutputStream("./src/main/resources/input/in-2.zip");

        // 记录开始时间
        long start = System.currentTimeMillis();
        // 读写数据
        int len;
        byte[] bytes = new byte[8*1024];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0 , len);
        }

        fis.close();
        fos.close();
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:" + (end - start) + " 毫秒");//41ms
    }

    /**
     * 缓冲流文件复制
     * @throws Exception
     */
    public static void bufferInputStreamAndBufferOutputStream() throws Exception {
        //构造方式一： 创建字节缓冲输入流【但是开发中一般常用下面的格式申明】
        FileInputStream fileInputStream = new FileInputStream("./test.zip");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        //创建字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./src/main/resources/output/out-2.txt"));
        ///创建字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./src/main/resources/input/in-1.zip"));
        // 记录开始时间
        long start = System.currentTimeMillis();

        // 读写数据
        int len;
        byte[] bytes = new byte[8*1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0 , len);
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流使用数组复制时间:"+(end - start)+" 毫秒");//0ms
    }
}