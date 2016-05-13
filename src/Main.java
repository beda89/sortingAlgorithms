import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    private static final int LIST_SIZE=1000000;
    private static final int MAX_VALUE=100000;

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> listOfLists=new ArrayList<>();

        listOfLists.add(new ArrayList<>(LIST_SIZE));
        listOfLists.add(new ArrayList<>(LIST_SIZE));
        listOfLists.add(new ArrayList<>(LIST_SIZE));
        listOfLists.add(new ArrayList<>(LIST_SIZE));
        listOfLists.add(new ArrayList<>(LIST_SIZE));
        listOfLists.add(new ArrayList<>(LIST_SIZE));

        Random rand=new Random();

        //fill all lists with the same random values
        for(int i=0;i<LIST_SIZE;i++) {
            int randomNbr=rand.nextInt(MAX_VALUE);

            for(ArrayList<Integer> list:listOfLists){
                list.add(randomNbr);
            }
        }

        //sort the first list without taking time so that resources are already reserved by the OS/JVM for better comparability
        Collections.sort(listOfLists.get(0));

        long time1=System.currentTimeMillis();
        Collections.sort(listOfLists.get(1));
        long time2=System.currentTimeMillis();
        MergeSort.sort(listOfLists.get(2));
        long time3=System.currentTimeMillis();
        HeapSort.sort(listOfLists.get(3));
        long time4=System.currentTimeMillis();
   //   InsertionSort.sort(listOfLists.get(4)););
        long time5=System.currentTimeMillis();
        BucketSort.sort(listOfLists.get(5),MAX_VALUE);
        long time6=System.currentTimeMillis();

        System.out.println("timeJavaSort(ms)="+(time2-time1));
        System.out.println("timeMerge(ms)="+(time3-time2));
        System.out.println("timeHeap(ms)="+(time4-time3));
        System.out.println("timeInsertion(ms)="+(time5-time4));
        System.out.println("timeBucket(ms)="+(time6-time5));

        //check if sorting is done correct
        ArrayList<Integer> referenceList=listOfLists.get(0);

        for(int k=1;k<listOfLists.size();k++){
            ArrayList<Integer> listToCheck=listOfLists.get(k);
            for(int j=0;j<LIST_SIZE;j++){
                if(!referenceList.get(j).equals(listToCheck.get(j))){
                    System.out.println("SORTING ERROR IN LIST "+k);
                    break;
                }
            }
        }
    }
}
