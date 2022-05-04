import java.util.List;

public class LinearSearch {
    public static <T> int linearSearch(List<T> arr, T x) {
        int i = 0;

        while (i < arr.size()) {
            if (arr.get(i).equals(x)) return i;
            i++;
        }

        return -1;
    }
}
