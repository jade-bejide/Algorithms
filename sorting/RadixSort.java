import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RadixSort {

    private static Integer intPow(Integer a, Integer b) {
        Integer exp = 1;
        while (b > 0) {
            exp *= a;
            b--;
        }

        return exp;
    }

    private static Integer getDigit(Integer x, int digitIndex, int base) {
        return Math.floorDiv(x, intPow(base, digitIndex - 1)) % base;
    }

    public static List<Integer> radixSort(List<Integer> a, int base, int numOfDigits) {
        for (int i = 1; i <= numOfDigits; i++) {
            a = countingSort(a, base, i);
        }
        return a;
    }
    public static Integer max(List<Integer> a) {
        Integer max = -Integer.MAX_VALUE;

        for (Integer val : a) {
            if (val > max) max = val;
        }

        return max;
    }

    public static List<Integer> countingSort(List<Integer> a, int base, int digit) {
        List<Integer> c = new ArrayList<Integer>();
        int n = a.size();

        for (int i = 0; i < base+1; i++) {
            c.add(0);
        }

        List<Integer> b = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            b.add(0);
        }

        // for (int i = 0; i < n; i++) {
        //     c.set(a.get(i), c.get(a.get(i))+1);
        // }

        for (Integer x : a) {
            Integer gDigit = getDigit(x, digit, base);
            c.set(gDigit, c.get(gDigit)+1);
        }

        for (int i = 1; i <= base; i++) {
            c.set(i, c.get(i)+ c.get(i-1));
        }
        
        for (int i = n-1; i >= 0; i--) {
            System.out.println("B: " + b + "\nC: " + c + "\nA: " + a);
            Integer x = a.get(i);
            Integer gDigit = getDigit(x, digit, base);
            b.set(c.get(gDigit)-1, x);
            c.set(gDigit, c.get(gDigit)-1);
        }

        return b;
    }


    public static void main(String[] args) {
        List<Integer> example = new ArrayList<>(Arrays.asList(4,2,2,0,1,4,2));
        System.out.println(countingSort(example, 10, 4));
    }
}