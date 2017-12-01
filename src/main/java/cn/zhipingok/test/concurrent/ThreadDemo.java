package cn.zhipingok.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static Object lock  = new Object();
    public  static Runnable runnable = ()->{
        int i=0;
        while(true) {
            try {
                synchronized (lock) {
                    i++;
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("=="+Thread.currentThread().getName()+"_"+i);
        }
    };

    public static void main(String[] args) throws InterruptedException {



        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread();

                return null;
            }
        };



        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(()->{

            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleeped");

        service.awaitTermination(1,TimeUnit.SECONDS);
        System.out.println("shut down");
//        for(int i=0;i<3;i++) {
//            Thread thread = new Thread(runnable);
//
//            thread.setName("ww_thread_"+i);
//            thread.start();
//        }
    }
}
