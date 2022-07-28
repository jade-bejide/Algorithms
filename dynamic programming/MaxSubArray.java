import java.util.List;
import java.util.ArrayList;

public class MaxSubArray {
    int max;
    int maxI;
    int maxJ;

    //need to keep track of max value - currently doesn't handle middle arrays

    public Integer[] splitArray(List<Integer> list, int i, int j) {
        int n = list.size();

        if (n <= 1) {
            Integer[] indices = {1,2};
            return indices;
        }

        //Find sum
        int pos = 0;
        int sum = 0;
        while (pos < n) {
            sum += list.get(pos);
            pos++;
        }

        if (sum > max) {
            maxI = i;
            maxJ = j;
            max = sum;
        }

        int mid = Math.floorDiv(n, 2);

        //Finds completely in left
        splitArray(list.subList(0, mid), 0, mid);
        //Finds completely in right
        splitArray(list.subList(mid+1, n), mid+1, n);
        //Finds in the middle

        Integer[] indices = {maxI, maxJ};
        return indices;
    }

    public static List<Integer> getDeltaList(List<Integer> list) {
        int n = list.size();

        if (n == 1) return list;

        int pos = 0;
        List<Integer> deltaList = new ArrayList<Integer>();

        while (pos < n - 1) {
            deltaList.add(list.get(pos+1) - list.get(pos));
            pos++;
        }

        return deltaList;
    }

    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<Integer>();
        listA.add(100);
        listA.add(113);
        listA.add(110);
        listA.add(85);
        listA.add(105);
        listA.add(102);
        listA.add(86);
        listA.add(63);
        listA.add(81);
        listA.add(101);
        listA.add(94);
        listA.add(106);

        List<Integer> listB = new ArrayList<Integer>();
        listB.add(-2);
        listB.add(-3);
        listB.add(4);
        listB.add(-1);
        listB.add(-2);
        listB.add(1);
        listB.add(5);
        listB.add(-3);

        MaxSubArray overhead = new MaxSubArray();

        List<Integer> listAD = getDeltaList(listA);
        Integer[] listAMIndices = overhead.splitArray(listAD, 0, listA.size());
        List<Integer> listAM = listA.subList(listAMIndices[0]+1, listAMIndices[1]+1);

        overhead.maxI = 0;
        overhead.maxJ = 0;
        overhead.max = 0;
        List<Integer> listBD = getDeltaList(listB);
        Integer[] listBMIndices = overhead.splitArray(listBD, 0, listB.size());
        List<Integer> listBM = listB.subList(listBMIndices[0]+1, listBMIndices[1]+1);

        System.out.print("[");
        for (Integer item : listAM) {
            System.out.print(item + ", ");
        }

        System.out.print("]");

        System.out.println("");

        System.out.print("[");
        for (Integer item2 : listBM) {
            System.out.print(item2 + ", ");
        }

        System.out.print("]");

        System.out.println("");
    }
}