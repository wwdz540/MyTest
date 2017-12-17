package cn.zhipingok.test.concurrent;

import java.util.concurrent.TimeUnit;

public class ClassLoadTest1 {
    public static void main(String[] args) {
       // ChildObj childObj = new ChildObj();
//        MyObj1 myObj1= new MyObj1();
//

        new Thread(()->{
            new TestCinit2();
        },"thread1").start();
        new Thread(()->{
            new TestCinit2();
        },"thread2").start();
    }

}

class MyObj {

    public MyObj() {
        System.out.println("==my obj init --");
    }
}
class MyObj1{
    private MyObj myObj = new MyObj();

    public MyObj1() {
        System.out.println("my obj init");
    }

    public void useMyojb(){
        System.out.println("user myOjb");
    }

}

class TestCInit{

    TestCInit()  {
        System.out.println("begin init test client,thead is "+Thread.currentThread().getName());
       int i=1;
        while(i++<10){
            System.out.println("print i = "+i+" ,"+Thread.currentThread().getName());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end init test client,thead is "+Thread.currentThread().getName());
    }

}

class TestCinit2{
    TestCInit testCInit=new TestCInit();
}
