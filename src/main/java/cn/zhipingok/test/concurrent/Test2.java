package cn.zhipingok.test.concurrent;

import java.util.*;

public class Test2 {

    public static class SuerpClass<T>{
        public  <S> SuerpClass(S s) {
           // System.out.println(T);
        }
    }
    public static void main(String[] args) {

        String arg=" wangzhiping";
        Optional.ofNullable(arg).ifPresent(System.out::println);
        Map map = new HashMap();

        prinltList(new ArrayList<>());  //泛型推断

    }

    public static <T extends Date>  void prinltList(List<T> params){
            params.stream().forEach(d-> System.out.println(d.getTime()));
    }
}
