package com.zwl.backend.one;

import org.junit.Test;

import java.io.File;

/**
 * @author zwl
 * @date 2020/10/5 11:33
 * @describe 使用File类进行文件和文件夹的查询、新增、删除等操作...
 */
public class FilePracticePractice {
    /*public static void main(String[] args) throws Exception {
        int methodCode = 4;
        switch (methodCode) {
            case 1:
                System.out.println("[绝对路径]获取File对象的三种方式");
                getFileByAbsolutePath();
                break;
            case 2:
                System.out.println("[相对路径]获取File对象的三种方式");
                getFileByRelativePath();
                break;
            case 3:
                System.out.println("File类常用方法");
                fileMethod();
                break;
            case 4:
                System.out.println("遍历打印文件夹下所有文件");
                recursion(new File("src"));
                break;

        }
    }
*/
    /**
     * 获取File对象的三种方式
     * 使用绝对路径获取File对象
     */
    @Test
    public  void getFileByAbsolutePath() {
        // File类构造方法不会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，都不影响File对象的创建。

        //1.通过文件路径名
        String path = "D:\\123.txt";
        File file1 = new File(path);
        System.out.println("file1:" + file1);

        //2.通过父路径和子路径
        String parent = "D:\\aaa";
        String child = "bbb.txt";
        File file2 = new File(parent, child);
        System.out.println("file2:" + file2);

        //3.通过父级File对象和子路径
        File parentFile = new File("D:\\test");
        String childPath = "456.txt";
        File file3 = new File(parentFile, childPath);

        System.out.println("file3:" + file3);
    }

    /**
     * 获取File对象的三种方式
     * 使用相对路径获取File对象
     */
    public static void getFileByRelativePath() {

    }

    /**
     * 测试File类常用方法
     */
    @Test
    public  void fileMethod() throws Exception {
        //获取文件信息--绝对路径
        File f = new File("d:/aAa/Bbb.txt");
        System.out.println("文件绝对路径getAbsolutePath[不会处理“.”和“..”的情况]:" + f.getAbsolutePath());
        System.out.println("文件绝对路径getCanonicalPath[“.”和“..”解析成对应的正确的路径]:" + f.getCanonicalPath());
        System.out.println("文件构造路径:" + f.getPath());
        System.out.println("文件名称:" + f.getName());
        System.out.println("文件长度:" + f.length() + "字节");

        //获取文件夹信息--绝对路径
        File f2 = new File("d:/aaa");
        System.out.println("文件夹绝对路径getAbsolutePath[不会处理“.”和“..”的情况]:" + f2.getAbsolutePath());
        System.out.println("文件夹绝对路径getCanonicalPath[“.”和“..”解析成对应的正确的路径]:" + f2.getCanonicalPath());
        System.out.println("目录构造路径:" + f2.getPath());
        System.out.println("目录名称:" + f2.getName());
        System.out.println("目录长度:" + f2.length());

        //获取文件信息--相对路径--一个.指向本项目所在目录
        File f3 = new File("./bbb.txt");
        System.out.println("文件绝对路径getAbsolutePath[不会处理“.”和“..”的情况]:" + f3.getAbsolutePath());
        System.out.println("文件绝对路径getCanonicalPath[“.”和“..”解析成对应的正确的路径]:" + f3.getCanonicalPath());
        System.out.println("文件构造路径:" + f3.getPath());
        System.out.println("文件名称:" + f3.getName());
        System.out.println("文件长度:" + f3.length() + "字节");

        //获取文件夹信息--相对路径
        File f4 = new File("./aaa");
        System.out.println("文件夹绝对路径getAbsolutePath[不会处理“.”和“..”的情况]:" + f4.getAbsolutePath());
        System.out.println("文件夹绝对路径getCanonicalPath[“.”和“..”解析成对应的正确的路径]:" + f4.getCanonicalPath());
        System.out.println("目录构造路径:" + f4.getPath());
        System.out.println("目录名称:" + f4.getName());
        System.out.println("目录长度:" + f4.length());

        //获取文件信息--相对路径--两个.指向本项目所在上一级目录
        File f5 = new File("../zwl.txt");
        System.out.println("文件绝对路径getAbsolutePath[不会处理“.”和“..”的情况]:" + f5.getAbsolutePath());
        System.out.println("文件绝对路径getCanonicalPath[“.”和“..”解析成对应的正确的路径]:" + f5.getCanonicalPath());
        System.out.println("文件构造路径:" + f5.getPath());
        System.out.println("文件名称:" + f5.getName());
        System.out.println("文件长度:" + f5.length() + "字节");

        //获取文件信息--相对路径--不带.指向本项目所在目录
        File f0 = new File("888.txt");
        System.out.println("文件绝对路径getAbsolutePath[不会处理“.”和“..”的情况]:" + f0.getAbsolutePath());
        System.out.println("文件绝对路径getCanonicalPath[“.”和“..”解析成对应的正确的路径]:" + f0.getCanonicalPath());
        System.out.println("文件构造路径:" + f0.getPath());
        System.out.println("文件名称:" + f0.getName());
        System.out.println("文件长度:" + f0.length() + "字节");

        File f6 = new File("d:/aAa/Bbb.txt");
        File f7 = new File("d:\\aaa");
        //判断文件或者目录是否存在
        System.out.println("d:/aAa/Bbb.txt是否存在:" + f6.exists());
        System.out.println("d:/aAa是否存在:" + f7.exists());
        // 判断是文件还是目录
        System.out.println("d:/aAa是否是文件?:" + f7.isFile());
        System.out.println("d:/aAa是否是目录?:" + f7.isDirectory());

        // 文件的创建
        File f8 = new File("aaa.txt");
        System.out.println("aaa.txt是否存在:" + f8.exists()); // false
        System.out.println("aaa.txt是否创建:" + f8.createNewFile()); // true
        System.out.println("aaa.txt是否创建:" + f8.createNewFile()); // 已经创建过了所以再使用createNewFile返回false
        System.out.println("aaa.txt是否存在:" + f8.exists()); // true

        // 目录的创建
        File f9 = new File("newDir");
        System.out.println("newDir目录是否存在:" + f9.exists());// false
        System.out.println("newDir目录是否创建:" + f9.mkdir());    // true
        System.out.println("newDir目录是否存在:" + f9.exists());// true

        // 创建多级目录
        File f10 = new File("newDira\\newDirb");
        System.out.println("newDira\\newDirb是否创建：" + f10.mkdir());// false
        File f11 = new File("newDira\\newDirb");
        System.out.println("newDira\\newDirb是否创建：" + f11.mkdirs());// true

        // 文件的删除
        System.out.println("aaa.txt是否删除：" + f8.delete());// true

        // 目录的删除【要删除的目录下不能有任何文件，即使是空目录也无法删除】
        System.out.println("newDir目录是否删除：" + f9.delete());// true
        File f12 = new File("newDira");
        System.out.println("newDira目录是否删除：" + f12.delete());// false
        System.out.println("newDira\\newDirb目录是否删除：" + f11.delete());// true
        System.out.println("newDira目录是否再次删除：" + f12.delete());// true

        //指定的必须是存在的目录。否则容易引发返回数组为null，出现NullPointerException异常
        File dir = new File("./src/main");
        //获取当前目录下的文件以及文件夹的名称
        String[] names = dir.list();
        for (String name : names) {
            System.out.println(dir.getCanonicalPath()+"下文件夹："+name);
        }
        //获取当前目录下的文件以及文件夹对象，只要拿到了文件对象，那么就可以获取更多信息
        File[] files= dir.listFiles();
        for (File file:files){
            System.out.println(dir.getCanonicalPath()+"下文件or文件名："+file.getName());
        }
    }

    /**
     * 递归遍历文件夹下所有文件
     */
    public  void recursion(File file){
        //1、判断传入的是否是目录
        if(!file.isDirectory()){
            //不是目录直接退出
            return;
        }
        //已经确保了传入的file是目录
        File[] files=file.listFiles();
        //遍历files
        for (File f:files){
            //如果该目录下文件还是个文件夹就再进行递归遍历其子目录
            if(f.isDirectory()){
                //递归
                recursion(f);
            }else {
                //如果该目录下文件是个文件，则打印对应的名字
                System.out.println(f.getName());
            }
        }
    }
}
