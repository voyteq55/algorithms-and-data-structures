package Lista04.Zadanie1;

public class TwoWayLinkedListTest {
    public static void main(String[] args) {
        TwoWayLinkedList<Integer> testList = new TwoWayLinkedList<>();

        System.out.println("displaying empty list:");
        System.out.println(testList);
        System.out.println("size: " + testList.size());
        System.out.println("isEmpty: " + testList.isEmpty());

        // this doesn't work
        // testList.set(0, 1);
        // System.out.println(testList.get(0));
        // testList.remove(0);

        testList.add(0, 1);
        System.out.println("\ndisplaying list after adding one (1) element");
        System.out.println(testList);

        testList.set(0, 5);
        System.out.println("\ndisplaying list after setting first element as 5");
        System.out.println(testList);

        testList.add(0, 10);
        System.out.println("\ndisplaying list after adding 10 at the start of the list");
        System.out.println(testList);

        testList.add(2);
        System.out.println("\ndisplaying list after adding 2 at the end of the list");
        System.out.println(testList);

        testList.add(1, 3);
        System.out.println("\ndisplaying list after adding 3 to the list");
        System.out.println(testList);

        testList.remove(0);
        System.out.println("\ndisplaying list after removing the first element from the list");
        System.out.println(testList);

        System.out.println("\ndisplaying index of element 2 (should be 2)");
        System.out.println(testList.indexOf(2));

        System.out.println("\ndisplaying index of element 100 (should be -1, not in the list)");
        System.out.println(testList.indexOf(100));

        System.out.println("\ndisplaying list size (should be 3)");
        System.out.println(testList.size());

        testList.clear();
        System.out.println("\ndisplaying cleared list");
        System.out.println(testList);

        testList.add(10);
        testList.add(20);
        testList.add(30);
        testList.add(3, 40);
        testList.add(0, 50);
        testList.add(2, 60);
        System.out.println("\ndisplaying list after adding elements");
        System.out.println(testList);

        testList.add(0, null);
        testList.add(null);
        testList.set(3, null);
        System.out.println("\ndisplaying list after adding null elements");
        System.out.println(testList);

        System.out.println("\ncontains null: " + testList.contains(null));
        System.out.println("contains 40: " + testList.contains(40));
        System.out.println("contains 100: " + testList.contains(100));
        System.out.println("first element: "  + testList.get(0));

        System.out.println("\nremoving null successful (should be true): " + testList.remove(null));
        System.out.println("displaying list after removing");
        System.out.println(testList);

        System.out.println("\nremoving 100 successful (should be false): " + testList.remove(Integer.valueOf(100)));
        System.out.println("displaying list after removing");
        System.out.println(testList);

        System.out.println("\nremoving 40 successful (should be true): " + testList.remove(Integer.valueOf(40)));
        System.out.println("displaying list after removing");
        System.out.println(testList);

        System.out.println("\nisEmpty: " + testList.isEmpty());
        System.out.println("size: " + testList.size());
    }
}
