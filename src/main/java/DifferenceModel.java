import java.util.*;

/***
 * 人狗鸡米过河问题
 */
public class DifferenceModel {

    private String[] participator = {"人", "狗", "鸡", "米"};

    //private int st = getState(participator); //初始状态


    //四种操作状态
    private int[] opts={getState("人","狗"),
            getState("人","鸡"),
            getState("人","米"),
            getState("人")};


    private int[] forbitMask ={ getState("人","鸡","米"),
            getState("人","鸡","狗"),};


    private int[] forbit ={ getState("鸡","米"),
            getState("鸡","狗"),};


    int intiSt = getState(participator); //初始状态

    Stack<Integer> stack = new Stack();
    Set<Integer> historySt = new HashSet<>(); //历史状态
    public void searchWay(int st){

        Queue<Integer> queue = new LinkedList<>(); //用以保存正确的状态值
        Queue<Integer> opQueue = new LinkedList<>(); //用以保存正确的状态值
        for(int op:opts){
            int nSt = op ^ st;

           // System.out.println(nSt);

            if(nSt == 0){

                printOPs();
                continue;
            }

            if(historySt.contains(nSt)){ //如果状态已经存在过了
                continue;
            }
            if(check(nSt)) {
              //  System.out.println("**"+Integer.toBinaryString(nSt));
                historySt.add(nSt);
                queue.add(nSt);
                opQueue.add(op);
            }
        }

        Integer mSt;
       while ((mSt = queue.poll())!=null){
           stack.push(opQueue.poll());
           searchWay(mSt);
      //     System.out.println(Integer.toBinaryString(mSt));
           stack.pop();
       }

    }




    private boolean check(int state){


        for(int i=0;i<forbitMask.length;i++){
            if((state & forbitMask[i])==forbit[i]){
                return false;
            }

            if(((~state) & forbitMask[i])==forbit[i]){

                return false;
            }

        }
       // historySt.add(s)
        return true;

    }

    private Map<Integer,String> map =new HashMap<>();
    {
        putMap("人","狗");
        putMap("人","鸡");
        putMap("人","米");
        putMap("人");
    }

    private void putMap(String... s){
        String v = s.length > 1? s[0]+s[1] : s[0];
        map.put(getState(s),v);
    }

    private void printOPs(){
        for(Integer i:stack){
            printOp(i);
        }
    }
    private void printOp(int mOp){
        System.out.println(map.get(mOp));
    }


    private int getState(String... values) {

        int resutl = 0;
        for (String v : values) {
           int idx = indexOf(participator,v);
           resutl |= 1<<idx;
        }


        return resutl;
    }

    private int indexOf(String[] strings,String s){
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].equals(s)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DifferenceModel df = new DifferenceModel();
        df.searchWay(df.intiSt);

    }
}
