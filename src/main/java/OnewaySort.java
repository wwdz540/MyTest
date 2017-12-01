/**
 * Created by wzp on 2017/5/15.
 */
public class OnewaySort implements TwoArraySortStrategy {
    @Override
    public void sort(Integer[] arrayA, Integer[] arrayB) {
        int tmp;
        for(int j =0; j<arrayA.length;j++){

            for(int i=0;i<arrayA.length-j;i++){
                if(arrayB[i]<arrayA[i+j]){
                    tmp = arrayA[i+j];
                    arrayA[i+j] = arrayB[i];
                    arrayB[i] = tmp;
                }

            }

        }

    }


}
