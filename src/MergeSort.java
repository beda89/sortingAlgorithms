import java.util.ArrayList;

/**
 * Created by peter on 08.05.16.
 */
public class MergeSort {

    public static void sort(ArrayList<Integer> list){
        mergeSort3(list,0,list.size()-1);
    }


    private static void mergeSort3(ArrayList<Integer> list,int start,int end){
        int length=end-start+1;

        //we split til there is only one element left
        if(length<2){
            return;
        }

        //splitting (recursive)
        int leftEnd=start+(end-start)/2;
        int rightStart=start+(end-start)/2+1;
        mergeSort3(list,start,leftEnd);
        mergeSort3(list,rightStart,end);

        //merge sublists again
        merge3(list,start,leftEnd,rightStart,end);
    }

    private static void merge3(ArrayList<Integer> list,int start1,int end1, int start2, int end2){
        int mergedElementsCtr=0;
        int start=start1;
        int subListLength=end2-start1+1;

        ArrayList<Integer>sorted=new ArrayList<>(subListLength);

        while(mergedElementsCtr<subListLength){
            if(start1>end1){
                sorted.add(list.get(start2));
                start2++;
            }else if(start2>end2){
                sorted.add(list.get(start1));
                start1++;
            }else {

                if (list.get(start1) < list.get(start2)) {
                    sorted.add(list.get(start1));
                    start1++;
                } else {
                    sorted.add(list.get(start2));
                    start2++;
                }
            }

            mergedElementsCtr++;
        }

        //copy the sorted sublist back in the original array
        int index=0;
        for(int j=start;j<=end2;j++){
            list.set(j,sorted.get(index));
            index++;
        }

    }

}
