import java.util.Arrays;
import java.util.List;

public class BubbleSort<T> {
    public static List<Integer> bubbleSort(List<Integer> a) {
        int n = a.size();
        for (int i = 0; i < n-2; i++) {

            for (int j = n-1; j > i; j--) {
                if (a.get(j) < a.get(j-1)) {
                    Integer temp = a.get(j);
                    a.set(j, a.get(j-1));
                    a.set(j-1, temp);
                }
            }

        }

        return a;
    }

    public static List<Double> bubbleSort(List<Double> a, boolean isDouble) {
        if (!isDouble) throw new IllegalArgumentException("Method is for doubles!");
        int n = a.size();
        for (int i = 0; i < n-2; i++) {

            for (int j = n-1; j > i; j--) {
                if (a.get(j) < a.get(j-1)) {
                    Double temp = a.get(j);
                    a.set(j, a.get(j-1));
                    a.set(j-1, temp);
                }
            }

        }

        return a;
    }

    public static void main(String... args) {
        List<Integer> iE = Arrays.asList(1,4,2,6,2);
        List<Double> dE = Arrays.asList(0.5,0.1,2.0,3.5);

        System.out.println(bubbleSort(iE));
        System.out.println(bubbleSort(dE, true));  
    }
}