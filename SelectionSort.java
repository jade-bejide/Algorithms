import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    public static List<Integer> selectionSort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            //should be local minimum
            Integer min = arr.get(i);
            for (int j = i+1; j < n; j++) {
                if (min >= arr.get(j)) {
                    min = arr.get(j);
                    minIndex = j;
                }
            }


            Integer temp = arr.get(i);
            arr.set(i, min);
            arr.set(minIndex, temp);


        }

        return arr;
    }

    public static void main(String... args) {
        List<Integer> example = new ArrayList<>(Arrays.asList(4,2,2,0,1,4,2));
        System.out.println(selectionSort(example));
    }
}
