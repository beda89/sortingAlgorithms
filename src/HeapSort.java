import java.util.ArrayList;

/**
 * Created by peter on 13.05.16.
 */
public class HeapSort {

    public static void sort(ArrayList<Integer> list){
        buildMaxHeap(list);

        for(int i=list.size();i>1;i--) {
            takeMaxAndReorder(list, i);
        }
    }

    private static void takeMaxAndReorder(ArrayList<Integer> list,int heapSize){

        //swap max and last value of heap
        int currentMax=list.get(0);
        list.set(0,list.get(heapSize-1));
        list.set(heapSize-1,currentMax);

        //reorder heap
        //since we took the max, heapSize is decreased by 1
        reorderAfterRetrieval(list,0,heapSize-1);
    }

    private static void reorderAfterRetrieval(ArrayList<Integer> list,int parentPosition,int heapSize){


        int lastHeapIndex=heapSize-1;
        int leftChildPos=getLeftChildPosition(parentPosition);
        int rightChildPos=getRightChildPosition(parentPosition);

        int parent=list.get(parentPosition);

        //if leftChild is out of heap then stop (we reached last row of heap)
        if(leftChildPos>lastHeapIndex){
            return;
        }else if(rightChildPos>lastHeapIndex){  //parent has only a leftChild
            int leftChild=list.get(leftChildPos);

            if(leftChild>parent){
                list.set(parentPosition, leftChild);
                list.set(leftChildPos, parent);
            }
        }else {
            int leftChild=list.get(leftChildPos);
            int rightChild=list.get(rightChildPos);

            //parent has to childs
            //if parent is smaller than at least on of its children, swap parent with biggest child
            if (parent < leftChild || parent < rightChild) {
                if (leftChild > rightChild) {
                    list.set(parentPosition, leftChild);
                    list.set(leftChildPos, parent);

                    //go down til we are at the last row of heap
                    reorderAfterRetrieval(list,leftChildPos,heapSize);

                } else {
                    list.set(parentPosition, rightChild);
                    list.set(rightChildPos, parent);
                    reorderAfterRetrieval(list,rightChildPos,heapSize);
                }
            }
        }

    }



    private static void buildMaxHeap(ArrayList<Integer> list){
        //add every number to heap (heap is an inplace sort)
        for(int i=1;i<list.size();i++){
            addToMaxHeap(list,i);
        }
    }

    private static void addToMaxHeap(ArrayList<Integer> list, int heapSize){
        //heapsize marks the position of the next element which is added to the heap
        reorderHeapAfterInsertion(list,heapSize);
    }

    private static void reorderHeapAfterInsertion(ArrayList<Integer> list, int elementPosition){

        //we reached top of heap
        if(elementPosition==0){
            return;
        }

        int parentPosition=getParentPosition(elementPosition);

        Integer parent=list.get(parentPosition);
        Integer element=list.get(elementPosition);

        //if parent is smaller than child -> swap values
        if(parent.compareTo(element)<0){
            list.set(parentPosition,element);
            list.set(elementPosition,parent);
            reorderHeapAfterInsertion(list,parentPosition);
        }
    }


    private static int getParentPosition(int childPosition){
        return (childPosition-1)/2;
    }

    private static int getLeftChildPosition(int parentPosition){
        return (parentPosition*2)+1;
    }

    private static int getRightChildPosition(int parentPosition){
        return (parentPosition*2)+2;
    }
}
