import java.util.Arrays;

public class TwoSumPointers {
    //Assumes that the list is sorted
    public boolean twoSum(Integer[] values, Integer x) {
        int n = values.length;
        int left = 0;
        int right = n-1;

        boolean found = false;

        while (!found && left != right) {
            Integer sum = values[left] + values[right];
            if (sum == x) {
                found = true;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Left: " + values[left] + " Right: " + values[right]);


        return found;
    }

    public static void main(String[] args) {
        Integer[] listA = {3, 5, 2, -4, 8, 11};
        Arrays.sort(listA);

        Integer x = 7;
        TwoSumPointers system = new TwoSumPointers();
        System.out.println(system.twoSum(listA, x));
    }
}
