package com.shen.io;

import java.io.*;

/**
 * Created by shenluguo on 2015/6/26.
 */
public class ReadFile {

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
//        LineNumberReader linereader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
//            linereader = new LineNumberReader(new FileReader(file));
            String tempString = null;
            String lastLineString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                if(tempString.contains(">>>>>>>>")) {
//                    System.out.println("line " + (line-1) + ": " + lastLineString);
//                    System.out.println("line " + line + ": " + tempString);
                    System.out.println(lastLineString);
                    System.out.println(tempString);
                }
                lastLineString = tempString;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void main(String[] args) {
        ReadFile.readFileByLines("D:\\logs\\app-monitor.log.7");
    }

}
