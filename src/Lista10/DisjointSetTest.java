package Lista10;

import java.util.ArrayList;

public class DisjointSetTest {

    public static void main(String[] args) {
        int[] numberOfElements = new int[]{1000000, 2000000, 3000000, 4000000, 5000000, 6000000, 7000000, 8000000, 9000000, 10000000};

        System.out.println("Liczba elementow\tUnion\tFind");
        for (int number : numberOfElements) {
            test(number);
        }

    }

    private static void test(int numberOfElements) {
        System.out.print(numberOfElements + "\t");
        ArrayList<ForestDisjointSet> disjointSets = new ArrayList<>();
        ForestDisjointSet setMod1 = new ForestDisjointSet();
        ForestDisjointSet setMod2 = new ForestDisjointSet();
        ForestDisjointSet setMod4 = new ForestDisjointSet();
        disjointSets.add(setMod4);
        disjointSets.add(setMod1);
        disjointSets.add(setMod2);

        long timeStart = System.currentTimeMillis();
        for (int i = 3; i < numberOfElements; i++) {
            ForestDisjointSet newSet = new ForestDisjointSet();
            disjointSets.add(newSet);
            if (i % 4 == 0) {
                setMod4.union(newSet);
            } else if (i % 2 == 0) {
                setMod2.union(newSet);
            } else {
                setMod1.union(newSet);
            }
        }
        long timeElapsed = System.currentTimeMillis() - timeStart;
        System.out.print(timeElapsed + "\t");

        timeStart = System.currentTimeMillis();
        for (ForestDisjointSet set : disjointSets) {
            set.findRepresentant();
        }
        timeElapsed = System.currentTimeMillis() - timeStart;
        System.out.println(timeElapsed);
    }

}
