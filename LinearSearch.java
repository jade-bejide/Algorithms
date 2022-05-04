import java.util.Arrays;
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

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        for (int i = 0; i < 10; i++) {
            assert(linearSearch(list, list.get(i)) == i+1);
        }

        assert(linearSearch(list, 10) == -1);

        List<String> artists = Arrays.asList("Beyoncé", "D'Angelo", "Meek Mill", "Masego");

        assert(linearSearch(artists, "André 3000") == -1);
        assert(linearSearch(artists, "D'Angelo") == 1);
    }
}
