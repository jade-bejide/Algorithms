import java.util.List;
import java.util.Arrays;

public class BinarySearch {
    /* 
        Divide - List is halved each time, minimising the problem solving range
        Conquer - Once found, conquer by returning the relevant index
    */
    
    //assume that arr is sorted
    public static int binarySearch(List<Integer> arr, Integer x) {
        int start = 0;
        int end = arr.size()-1;

        int mid = Math.floorDiv(start + end, 2);

        if (arr.get(mid) == x) return mid;
        else if (arr.size() == 1) return -1; //if first predicate is false and list is of size 1, the item isn't in the list
        else if (arr.get(mid) > x) return binarySearch(arr.subList(start, mid+1), x); //(+0) - we're starting on the left side
        else return mid + 1 + binarySearch(arr.subList(mid+1, end+1), x); //mid + 1 to consider we're starting on the right side

    }

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        for (int i = 0; i < 10; i++) {
            assert(binarySearch(list, list.get(i)) == i+1);
        }

        assert(binarySearch(list, 10) == -1);
    }
}
