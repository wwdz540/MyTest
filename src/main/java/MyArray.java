import java.util.ArrayList;

/**
 * Created by wzp on 2017/5/18.
 */
public class MyArray {
    ArrayList<int[]> arrays = new ArrayList<int[]>();


    public void addArray(int[] array){
        arrays.add(array);
    }



    public int get(int idx){

        int i=0;
        int[] array ;
        while(idx >= (array = arrays.get(i++)).length) {
            idx = idx - array.length;
        }
        return array[idx];
    }

    public void put(int idx,int d){

        int i=0;
        int[] array ;
        while(idx >= (array = arrays.get(i++)).length) {
            idx = idx - array.length;
        }
        array[idx] = d;
    }

    public int getLength(){
        int length = 0;
        for(int[] array:arrays){
            length += array.length;
        }
        return length;
    }


}
