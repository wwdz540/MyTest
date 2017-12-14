package cn.zhipingok.test.concurrent;

import java.util.concurrent.TimeUnit;

public class Utiles {
    public static void sleepSec(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
