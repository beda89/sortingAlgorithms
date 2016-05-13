import java.util.ArrayList;

/**
 * Created by peter on 13.05.16.
 */
public class InsertionSort {

    public static void sort(ArrayList<Integer> list){
        for(int i=1;i<list.size();i++){
            insert(list,i);
        }

    }

    private static void insert(ArrayList<Integer> list,int elementPosition){
        int newElement=list.get(elementPosition);

        for(int j=elementPosition-1;j>=0;j--){
            int sortedElement=list.get(j);

            if(newElement<sortedElement){
                //swap elements;
                list.set(j,newElement);
                list.set(j+1,sortedElement);

            }else{
                break;
            }

        }



    }
}
