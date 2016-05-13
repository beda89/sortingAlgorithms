import java.util.ArrayList;

/**
 * Created by peter on 14.05.16.
 */
public class BucketSort {

    private static final int MAX_ARRAY_SIZE=1000000;

    public static void sort(ArrayList<Integer> list, int maxValue){

/*        if(maxValue>MAX_ARRAY_SIZE){
            System.out.println("Bucketsort not efficient if numbers are to wide spread!");
            return;
        } */

        int[] buckets=new int[maxValue];

        for(Integer element:list){
            buckets[element]++;
        }

        int listIndex=0;

        for(int i=0;i<buckets.length;i++){
            for(int j=0;j<buckets[i];j++){
                list.set(listIndex,i);
                listIndex++;
            }
        }
    }

}
