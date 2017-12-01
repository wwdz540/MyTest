package cn.zhipingok.test.concurrent;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


    public static void main(String[] args) {
        Map<String,Point> map = new ConcurrentHashMap();
        map.put("1",new Point(10,10));
        map.put("2",new Point(30,20));

        map.get("1").x=30;

        System.out.println(map.get("1"));
        //resutl:Point{x=30, y=10}
        Map<String,Point> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.get("1").x=30;
        System.out.println(map.get("1"));
        //resutl:Point{x=30, y=10}

     //   unmodifiableMap.put("3",new Point(5,5));//throw exception



    }
}
