package Lista09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SetsTest {
    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        int[] elementsCount = new int[]{10000, 50000, 100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 1000000, 1500000, 2000000};

//        ISet<Integer> set = new RBSet<>(Comparator.<Integer>naturalOrder());
//        ISet<Integer> set = new BSTSet<>(Comparator.<Integer>naturalOrder());
        ISet<Integer> set = new SkipSet<>(Comparator.<Integer>naturalOrder(), 0.5);
        for (int count : elementsCount) {
            testOperations(set, count);
        }

    }

    private static void testOperations(ISet<Integer> set, int elementsCount) {
        System.out.print(elementsCount + "\t");
        ArrayList<Integer> listOfElements = generateRandomElements(elementsCount);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < elementsCount; i++) {
            set.insert(listOfElements.get(i));
        }
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.print(elapsedTime + "\t");

        listOfElements = generateRandomElements(elementsCount);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < elementsCount; i++) {
            set.contains(listOfElements.get(i));
        }
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.print(elapsedTime + "\t");

        listOfElements = generateRandomElements(elementsCount);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < elementsCount; i++) {
            set.remove(listOfElements.get(i));
        }
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.print(elapsedTime + "\n");
    }

    public static ArrayList<Integer> generateRandomElements(int elementsCount) {
        ArrayList<Integer> list = new ArrayList<>(elementsCount);

        for (int i = 0; i < elementsCount; i++) {
            list.add(random.nextInt(elementsCount));
        }

        return list;
    }
}
