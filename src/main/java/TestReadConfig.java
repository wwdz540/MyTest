import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by wzp on 2017/1/3.
 */
public class TestReadConfig {

    Properties properties= new Properties();
    public void init(){
        File file = new File("a.properties");


        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println(file.getAbsolutePath());


      //  this.getClass().getClassLoader().get

//        try {
//            properties.load(new FileReader(path));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public String readConfig(String ss){
        return properties.getProperty(ss);
    }


    public static void main(String[] args) {

        Map map = new HashMap();
      //  ThreadFactory
       // ThreadPoolExecutor.

        TestReadConfig testReadConfig = new TestReadConfig();
        testReadConfig.init();
//
//        testReadConfig.readConfig("name");
    }

}
