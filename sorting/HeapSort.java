import java.util.Arrays;
import java.util.List;


public class HeapSort {

    static int nodeExchanges;

    public static Integer extractMax(List<Integer> arr) {
        arr = heapSort(arr, true);

        return arr.get(0);
    }

    //Ad-hoc polymorphism
    public static Integer extractMax(List<Integer> arr, int i) {
        arr = heapSort(arr, true);

        return arr.get(i);
    }

    public static Integer extractMin(List<Integer> arr) {
        arr = heapSort(arr, false);

        return arr.get(0);
    }

    public static Integer extractMin(List<Integer> arr, int i) {
        if (i >= arr.size()) throw new IllegalArgumentException("Index must be in range!");
        arr = heapSort(arr, false);

        return arr.get(i);
    }

    public static List<Integer> maxHeapify(List<Integer> arr, int i) {
        int n = arr.size();
        //Original algorithm assumes there's always a complete binary tree
        //So extra checks needed for any array
        int l = -1;
        int r = -1;

        if ((2*i) < n) l = 2*i;
        if ((2*i) + 1 < n) r = (2*i) + 1;

        int largest = -1;

        //if left or right child is bigger than the parent swap
        if (l != -1 && l <= n && arr.get(l) > arr.get(i)) largest = l;
        else largest = i;

        if (r != -1 && r <= n && arr.get(r) > arr.get(largest)) largest = r;

        System.out.println("f");
        //if a swap has been performed, heapify again
        if (largest != i) {
            nodeExchanges += 1;
            System.out.println(nodeExchanges);
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);

            arr = maxHeapify(arr, largest);
        }
        

        return arr;
    }

    public static List<Integer> minHeapify(List<Integer> arr, int i) {
        
        int n = arr.size();
        //Original algorithm assumes there's always a complete binary tree
        //So extra checks needed for any array
        int l = -1;
        int r = -1;

        if ((2*i) < n) l = 2*i;
        if ((2*i) + 1 < n) r = (2*i) + 1;

        int smallest = -1;

        //if left or right child is bigger than the parent swap
        if (l != -1 && l <= n && arr.get(l) < arr.get(i)) smallest = l;
        else smallest = i;

        if (r != -1 && r <= n && arr.get(r) < arr.get(smallest)) smallest = r;

        //if a swap has been performed, heapify again
        if (smallest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(smallest));
            arr.set(smallest, temp);

            arr = minHeapify(arr, smallest);
        }

        return arr;
    }

    public static List<Integer> buildMinHeap(List<Integer> arr) {
        int n = arr.size();

        //builds the binary heap, here we're not assuming it's a complete tree
        for (int i = 0; i < Math.floorDiv(n,2)+1; i++) arr = minHeapify(arr, i);

        return arr;
    }

    public static List<Integer> buildMaxHeap(List<Integer> arr) {
        int n = arr.size();

        //builds the binary heap, here we're not assuming it's a complete tree
        for (int i = Math.floorDiv(n, 2); i > 0; i--) arr = maxHeapify(arr, i);

        return arr;
    }

    public static List<Integer> heapSort(List<Integer> arr, boolean isMax) {
        if (isMax) arr = buildMaxHeap(arr);
        else arr = buildMinHeap(arr);
        int n = arr.size();

        for (int i = n-1; i > -1; i--) {
            //swap root with last element (decreasing the size of the heap each time)
            int temp = arr.get(i);
            arr.set(i, arr.get(0));
            arr.set(0, temp);

            if (isMax) arr = maxHeapify(arr, i);
            else arr = minHeapify(arr,i);
        }

        return arr;
    }

    public static void main(String... args) {
        List<Integer> iE = Arrays.asList(1,4,2,6,2);
        List<Integer> iE2 = Arrays.asList(5,7,3,11,9,8,9,1,3);

        //System.out.println(heapSort(iE, false));
        System.out.println(heapSort(iE2, true));
        System.out.println(nodeExchanges);
        // System.out.println(extractMax(iE2));
        // System.out.println(extractMax(iE2,2));
    }
}
