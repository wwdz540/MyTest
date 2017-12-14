package cn.zhipingok.test.concurrent;

public class VolatilTest {

     volatile   int  value=5;


    Thread add = new Thread(){
      //  ThreadLocal


        int j=0;
        @Override
        public void run() {
            while (true){
               j++;
                Utiles.sleepSec(1);

                   System.out.printf("add the value to [%d]\n", value);
                   value = j;



            }
        }
    };

    Thread read = new Thread(){
        @Override
        public void run() {

            while(true) {
                if(value > 10) {
                    System.out.println("read update to 10");
                    //  System.out.printf("read the value: %d\n",zz);
                    Utiles.sleepSec(1);
                }
            }
        }
    };




    public static void main(String[] args) {
        VolatilTest test = new VolatilTest();

        test.read.start();
        test.add.start();
    }
}
