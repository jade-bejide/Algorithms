import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RadixSort {
    public static Integer max(List<Integer> a) {
        Integer max = -Integer.MAX_VALUE;

        for (Integer val : a) {
            if (val > max) max = val;
        }

        return max;
    }

    public static List<Integer> countingSort(List<Integer> a) {
        List<Integer> c = new ArrayList<Integer>();
        int n = a.size();
        int k = max(a);

        for (int i = 0; i < k+1; i++) {
            c.add(0);
        }

        List<Integer> b = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            b.add(0);
        }

        for (int i = 0; i < n; i++) {
            c.set(a.get(i), c.get(a.get(i))+1);
        }

        for (int i = 1; i < k+1; i++) {
            c.set(i, c.get(i)+ c.get(i-1));
        }
        
        for (int i = n-1; i >= 0; i--) {
            b.set(c.get(a.get(i))-1, a.get(i));
            c.set(a.get(i), c.get(a.get(i))-1);
        }

        return b;
    }

    public static void main(String[] args) {
        List<Integer> example = new ArrayList<>(Arrays.asList(4,2,2,0,1,4,2));
        System.out.println(countingSort(example));
    }
}