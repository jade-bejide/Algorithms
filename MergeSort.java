import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        System.out.println(left + " " +  right);
        int leftSize = left.size();
        int rightSize = right.size();

        int leftIndex = 0;
        int rightIndex = 0;

        List<Integer> arr = new ArrayList<Integer>();
        
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (left.get(leftIndex) < right.get(rightIndex)){
                
                arr.add(left.get(leftIndex));
                leftIndex++;
            } 
            else {
                arr.add(right.get(rightIndex));
                rightIndex++;
            }

        }

        while (leftIndex < leftSize) {
            arr.add(left.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < rightSize) {
            arr.add(right.get(rightIndex));
            rightIndex++;
        }


        return arr;
    }

    public static List<Integer> fillSide(List<Integer> arr, int i, int j) {
        List<Integer> filledArr = new ArrayList<>();
        for (int k = i; k < j; k++) {
            filledArr.add(arr.get(k));
        }

        return filledArr;
    }

    public static List<Integer> mergeSort(List<Integer> arr) {
        int n = arr.size();

        if (n == 1) return arr;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        if (n > 2) {
            left = fillSide(arr, 0, Math.floorDiv(n,2));

            right = fillSide(arr, Math.floorDiv(n,2)+1, n);
        } else {
            left.add(arr.get(0));
            right.add(arr.get(1));
        }


        mergeSort(left);
        mergeSort(right);

        arr = merge(left, right);
        
        return arr;
    }

    public static void main(String... args) {
        List<Integer> iE = Arrays.asList(1,4,2,6,2, 5);
        List<Integer> iE2 = Arrays.asList(5,17,0,9,1,4,2,3,1,0);

        System.out.println(mergeSort(iE));
        System.out.println("");
        System.out.println(mergeSort(iE2));
    }
}
