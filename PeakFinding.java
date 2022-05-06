import java.util.Arrays;
import java.util.List;

public class PeakFinding {
    public static Integer peakFindingSimple(List<Integer> arr) {
        int n = arr.size();
        
        if (arr.get(0) >= arr.get(1)) return 0;

        if (arr.get(n-1) >= arr.get(n-2)) return n-1;

        for (int i = 1; i < n-1; i++) {
            if (arr.get(i) >= arr.get(i-1) && arr.get(i) >= arr.get(i+1)) return i;
        }

        return -1;
    }

    //utilises divide and conquer design
    public static Integer fastPeakFinding(List<Integer> arr) {
        int n = arr.size();

        if (n == 1) return 0; //singleton list is trivially peak
        if (n == 2) { //compare both elements and return (index of) larger element
            if (arr.get(0) >= arr.get(1)) return 0;
            return 1;
        }

        int mid = Math.floorDiv(n,2);
        if (arr.get(mid) >= arr.get(mid-1) && arr.get(mid) >= arr.get(mid+1)) return mid; //peak found

        if (arr.get(mid-1) >= arr.get(mid)) return fastPeakFinding(arr.subList(0, mid));
        // (mid + 1) to consider relative index as list divides in two
        return mid + 1 + fastPeakFinding(arr.subList(mid+1, n));
    }

    public static void main(String... args) {
        List<Integer> example = Arrays.asList(10, 14, 15, 2, 23, 90, 67);

        long simpleStart = System.nanoTime();
        Integer indexSimple = peakFindingSimple(example);
        long simpleEnd = System.nanoTime();

        long fastStart = System.nanoTime();
        Integer indexFast = fastPeakFinding(example);
        long fastEnd = System.nanoTime();

        System.out.println("Simple Peak Finding: ");
        System.out.println("Elapsed Time: " + (simpleEnd - simpleStart));
        System.out.println("Peak at index: " + indexSimple);

        System.out.println("");

        System.out.println("Fast Peak Finding: ");
        System.out.println("Elapsed Time: " + (fastEnd - fastStart));
        System.out.println("Peak at index: " + indexFast);
    }
}
