import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GeneratorClass {


    public void invokGetAndSet(Class clazz) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
          //  System.out.println(method.getName());
            if (method.getName().startsWith("get")) {
                Class<?>[] tt = method.getParameterTypes();
                if (tt.length != 0) continue;
                Object obj = clazz.newInstance();

                try {
                    method.invoke(obj);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            } else if (method.getName().startsWith("set")) {

                Class<?>[] tt = method.getParameterTypes();
                if(tt.length!=1) continue;
                Class<?> pcla = tt[0];
               // Object p;

                Object obj = clazz.newInstance();

                try {
                    if(pcla== int.class || pcla== Integer.class){
                        method.invoke(obj,0);
                    }
                    else if(pcla== float.class || pcla== Float.class){
                        method.invoke(obj,0.0f);
                    }
                    else if(pcla== boolean.class || pcla== Boolean.class){
                        method.invoke(obj,true);
                    }else if(pcla == List.class){ //可能还有其它的集合，你在代码中边调边看
                        method.invoke(obj,new ArrayList<>());
                    }
                    //还可能有其它基本类型
                    else {
                        //最后假设剩下的下个的一个属性 他的构造器无参

                        Object p = pcla.newInstance();
                        method.invoke(obj,p);
                    }

                } catch (InvocationTargetException | InstantiationException   e) {
                    System.out.println("kbs kbskkkdkd");
                    System.out.println(pcla.getName());
                    e.printStackTrace();
                }


            }
        }


    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        new GeneratorClass().invokGetAndSet(TestBeen.class);
    }
}
