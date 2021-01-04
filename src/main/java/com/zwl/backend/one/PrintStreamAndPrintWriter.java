package com.zwl.backend.one;

import java.io.*;

/**
 * @author zwl
 * @date 2020/10/6 12:27
 * @describe 字节打印流和字符打印流...
 */
public class PrintStreamAndPrintWriter {
    public static void main(String[] args) throws Exception {
        int methodCode = 2;
        switch (methodCode) {
            case 1:
                System.out.println("字节打印流");
                printStream();
                break;
            case 2:
                System.out.println("字符打印流");
                printWriter();
                break;

        }
    }

    /**
     * 打印流只操作目的地,不操作数据源
     * @throws Exception
     */
    public static void printStream()throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("./src/main/resources/output/out-14.txt"));
        PrintStream ps=new PrintStream("./src/main/resources/output/print-16.txt");
        String line;
        while((line=br.readLine())!=null) {
            ps.println(line);
        }
        br.close();
        ps.close();
    }

    /**
     *
     * @throws Exception
     */
    public static void printWriter()throws Exception{
        BufferedReader br=new BufferedReader(new FileReader("./src/main/resources/output/print-16.txt"));
        PrintWriter pw=new PrintWriter("./src/main/resources/output/print-17.txt");
        String line;
        while((line=br.readLine())!=null) {
            pw.println(line);
        }
        br.close();
        pw.close();
    }
}
