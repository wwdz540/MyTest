/**
 * Created by wzp on 2017/5/15.
 */
public class OnewayQuickSort implements TwoArraySortStrategy {
    @Override
    public void sort(Integer[] arrayA, Integer[] arrayB) {

        for (int j = 0; j < arrayA.length; j++) {


            compare(arrayA,arrayB,j,0);
            if(j< arrayA.length-1){
                compare(arrayA,arrayB,j+1,1);
                compare(arrayA,arrayB,arrayA.length-2,arrayA.length-2-j);
            }
            compare(arrayA,arrayB,arrayA.length-1,arrayA.length-1-j);
           // if(j==2) break;
        }

    }


    private void compare(Integer[] arrayA, Integer[] arrayB, int i, int j) {

        if (arrayB[j] < arrayA[i]) {
            int tmp = arrayA[i];
            arrayA[i] = arrayB[j];
            arrayB[j] = tmp;
        }

    }


}
