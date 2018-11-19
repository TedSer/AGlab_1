import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    static long timeOfWork = 0;
    static int numberOfComparison = 0;
    static int numberOfExchange = 0;
    private static long startTime = System.nanoTime();

    public static List<LawnMower> mergeSort(List<LawnMower> lawnMowers) {
        if (lawnMowers.size() <= 1) {
            return lawnMowers;
        }
        List<LawnMower> left = new ArrayList<>();
        List<LawnMower> right = new ArrayList<>();
        int middle = lawnMowers.size() / 2;

        for (int i = 0; i < lawnMowers.size(); i++) {
            if (i < middle) {
                left.add(lawnMowers.get(i));
            } else {
                right.add(lawnMowers.get(i));
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static List<LawnMower> merge(List<LawnMower> left, List<LawnMower> right) {
        List<LawnMower> mergedList = new ArrayList<>();

        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                numberOfComparison += 1;
                if (left.get(0).getFuelVolume() > right.get(0).getFuelVolume()) {
                    mergedList.add(left.get(0));
                    left.remove(0);
                    numberOfExchange += 1;
                } else {
                    mergedList.add(right.get(0));
                    right.remove(0);
                    numberOfExchange += 1;
                }
            } else if (left.size() > 0) {
                mergedList.add(left.get(0));
                left.remove(0);
                numberOfExchange += 1;
            } else if (right.size() > 0) {
                mergedList.add(right.get(0));
                right.remove(0);
                numberOfExchange += 1;
            }
        }

        timeOfWork = System.nanoTime() - startTime;
        return mergedList;
    }
}