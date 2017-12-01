import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wzp on 2017/5/22.
 */

public class TestOne {
    @Test
    public void testOne(){
        MyArray myArray = new MyArray();
        myArray.addArray(new int[]{20,30,40});
        myArray.put(0,20);

        Assert.assertEquals(20,myArray.get(0));
    }
}
