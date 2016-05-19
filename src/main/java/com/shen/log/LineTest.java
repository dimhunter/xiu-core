package com.shen.log;

/**
 * Created by shenge on 16/5/19.
 *
 * 通过StackTraceElement对象获取线程调用堆栈信息，以及行号，但是应该很耗资源。
 */
public class LineTest {

    public static void main(String args[]){
        System.out.println("This is " + getLineInfo());
    }

    public static String getLineInfo() {
        //
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        System.out.println(st);
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber();
    }

}
