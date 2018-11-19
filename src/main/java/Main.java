import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<LawnMower> getDataFromFile() {
        List<LawnMower> lawnMowers = new ArrayList<>();
        try (FileReader fileReader = new FileReader("lawnMowers.txt")) {
            Scanner scan = new Scanner(fileReader);

            while (scan.hasNextLine()) {
                String readString = scan.nextLine();
                String[] treesInfo = readString.split(",");

                String model = treesInfo[0];
                double widthOfGrassCutting = Double.parseDouble(treesInfo[1]);
                double enginePower = Double.parseDouble(treesInfo[2]);
                double fuelVolume = Double.parseDouble(treesInfo[3]);

                lawnMowers.add(new LawnMower(model, widthOfGrassCutting, enginePower, fuelVolume));
            }
            fileReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lawnMowers;
    }

    private static void printList(List<LawnMower> list) {
        for (LawnMower lawnMower : list) {
            System.out.println(lawnMower.toString());
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        List<LawnMower> lawnMowers;

        lawnMowers = getDataFromFile();

        System.out.println("Initial list of lawn mowers:");
        printList(lawnMowers);

        lawnMowers = SelectionSorter.selectionSortByPrice(lawnMowers);

        System.out.println("\nSelection Sort ascending by cutting grass width:");
        printList(lawnMowers);

        System.out.println("Number of exchanges:" + SelectionSorter.numberOfExchange);
        System.out.println("Number of comparison operations:" + SelectionSorter.numberOfComparison);
        System.out.println("Work time:" + SelectionSorter.timeOfWork + " nanoseconds\n");

        MergeSort.mergeSort(lawnMowers);

        System.out.println("\n\nMerge Sort descending by fuel volume:");
        printList(lawnMowers);

        System.out.println("Number of exchanges:" + MergeSort.numberOfExchange);
        System.out.println("Number of comparison operations:" + MergeSort.numberOfComparison);
        System.out.println("Work time:" + MergeSort.timeOfWork + " nanoseconds");
    }
}