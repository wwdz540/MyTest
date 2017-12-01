package cn.zhipingok.test.concurrent;

public class StackTraceDemo {

    public void printStackTrace(){
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        for (StackTraceElement se:st) {

            System.out.print(se.getMethodName());
            System.out.print(" "+se.getLineNumber());
            System.out.println();
        }
    }
    public static void main(String[] args) {


        (new StackTraceDemo()).printStackTrace();
    }
}
