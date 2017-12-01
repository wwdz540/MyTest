/**
 * 利用插入排序的思想,对两个数组进行排序,
 * 这种排序的思想直接来源插入排序,步骤是将a数组中的最后一个元素（也就是最大的元素）取出,插入到B数组中,并将B数组的元素向后移,并将B数组的第一个元素取出,插入到A数组合适的位置,并将数线元素前移.
 *
 *
 * */
public class InsertArraySort implements TwoArraySortStrategy {
    @Override
    public void sort(Integer[] arrayA, Integer[] arrayB) {
            int cur ;
            while (arrayB[0] < (cur  = arrayA[arrayA.length-1])){
                insert2A(arrayA,arrayB[0]);
                insert2B(arrayB, cur);
            }
    }

    private void insert2B(Integer[] arrayB, int cur) {
        int i;
        for(i=1; i<arrayB.length && arrayB[i] <= cur
                ; i++){
            arrayB[i-1] = arrayB[i];
        }
        arrayB[i-1] = cur;
    }

    private void insert2A(Integer[] array,Integer number){

        int i;
        for(i=array.length-2; i >= 0
                && array[i] >= number
                ; i--){
            array[i+1] = array[i];
        }
        array[i+1] = number;
    }
}
