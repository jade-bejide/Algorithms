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

        //never called due to the lemma every integer array has a peak
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

    public static List<Integer> twoPeaks(List<Integer> arr) {
        int n = arr.size();
        int mid = Math.floorDiv(n,2);

        List<Integer> left = arr.subList(0, mid+1);
        List<Integer> right = arr.subList(mid+1, n);

        //following two while loops for correctness
        int i = mid;
        int j = mid+1;
        while (arr.get(i) <= arr.get(j) &&  arr.get(j) >= arr.get(j+1) && i > 0) {
            left = arr.subList(0, i-1);
            i -= 1;
            j -= 1;
        }

        i = mid;
        j = mid-1;
        while (arr.get(j) >= arr.get(i) && i < n) {
            right = arr.subList(i+1, n);
            i += 1;
            j += 1;
        }

        Integer leftPeak = fastPeakFinding(left);
        Integer rightPeak = fastPeakFinding(right) + i;

        return Arrays.asList(leftPeak, rightPeak);
    }

    public static void main(String... args) {
        List<Integer> example = Arrays.asList(10, 14, 15, 2, 23, 19, 67);

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

        System.out.print(twoPeaks(example));
    }
}
