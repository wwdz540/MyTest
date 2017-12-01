/**
 * Created by wzp on 2017/5/15.
 */
public class TwoArrySort {

    private Integer[] arrayA = new Integer[10];
    private Integer[] arrayB = new Integer[10];


    public void sort(TwoArraySortStrategy sortStrategy){
        Integer[] mArrayA = new Integer[arrayA.length];
        Integer[] mArrayB = new Integer[arrayB.length];

        System.arraycopy(arrayA,0,mArrayA,0,arrayA.length);
        System.arraycopy(arrayB,0,mArrayB,0,arrayB.length);

        System.out.println("排序前");
        System.out.println("A:");
        printArray(mArrayA);
        System.out.println();
        System.out.println("B");
        printArray(mArrayB);
        System.out.println();
        sortStrategy.sort(mArrayA,mArrayB);

        System.out.println("排序后");
        System.out.println("A:");
        printArray(mArrayA);
        System.out.println();
        System.out.println("B");
        printArray(mArrayB);
        System.out.println();

    }


    private static void printArray(Integer[] integers){
       // System.out.println();
        System.out.print("[");
        for (Integer i:integers){
            System.out.print(i+",");
        }

        System.out.print("]");
    }



    public static void main(String[] args){
        TwoArrySort twoArrySort = new TwoArrySort();

        twoArrySort.arrayA[0]=1;
        twoArrySort.arrayA[1]=3;
        twoArrySort.arrayA[2]=10;
        twoArrySort.arrayA[3]=15;
        twoArrySort.arrayA[4]=20;
        twoArrySort.arrayA[5]=20;
        twoArrySort.arrayA[6]=21;
        twoArrySort.arrayA[7]=22;
        twoArrySort.arrayA[8]=23;
        twoArrySort.arrayA[9]=25;

        twoArrySort.arrayB[0] = 0;
        twoArrySort.arrayB[1] = 1;
        twoArrySort.arrayB[2] = 2;
        twoArrySort.arrayB[3] = 9;
        twoArrySort.arrayB[4] = 10;
        twoArrySort.arrayB[5] = 15;
        twoArrySort.arrayB[6] = 16;
        twoArrySort.arrayB[7] = 17;
        twoArrySort.arrayB[8] = 19;
        twoArrySort.arrayB[9] = 20;

        twoArrySort.sort(new OnewaySort());
        System.out.println("insert sort");
        twoArrySort.sort(new InsertArraySort());




    }




}
