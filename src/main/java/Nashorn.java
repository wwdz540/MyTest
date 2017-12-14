import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

public class Nashorn {

    public static class Person{
       private   String name ="wangzhiping";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        engine.eval(new FileReader("/Users/zhipingwang/workspace/idea/myteset/src/main/java/script.js"));

        Invocable invocable = (Invocable) engine;

        invocable.invokeFunction("fun2", new Person());
      //  Object result = invocable.invokeFunction("fun1", "Peter Parker");
      //  System.out.println(result);
       // System.out.println(result.getClass());
    }

}