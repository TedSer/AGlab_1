import java.util.List;

public class SelectionSorter {
    static int numberOfComparison;
    static int numberOfExchange;
    static long timeOfWork;

    public static List<LawnMower> selectionSortByPrice(List<LawnMower> lawnMowers) {
        long startTime = System.nanoTime();
        for (int i = 0; i < lawnMowers.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < lawnMowers.size(); j++) {
                numberOfComparison += 1;
                if (lawnMowers.get(j).getWidthOfGrassCutting() < lawnMowers.get(maxIndex).getWidthOfGrassCutting()) {
                    maxIndex = j;
                }
            }
            LawnMower tmp = lawnMowers.get(i);
            lawnMowers.set(i, lawnMowers.get(maxIndex));
            lawnMowers.set(maxIndex, tmp);
            numberOfExchange += 1;
        }

        timeOfWork = System.nanoTime() - startTime;

        return lawnMowers;
    }
}