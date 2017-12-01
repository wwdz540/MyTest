package cn.zhipingok.test.concurrent;

import java.util.concurrent.TimeUnit;

public class SynClassTest {

    public  static  class Server{


        public Server(String tag) {
            this.tag = tag;
        }

        public String tag="";


        public synchronized void fun1(){
            while(true) {
                System.out.println("fun1"+tag);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void fun2(){
            while(true){
                System.out.println("fun2");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Server s = new Server("tag1111");
        (new Thread(){


            @Override
            public void run() {
                s.fun1();
            }
        }).start();
        (new Thread(){
          //  Server s = new Server("tag2222");
            @Override
            public void run() {
                s.fun2();
            }
        }).start();
    }

}
