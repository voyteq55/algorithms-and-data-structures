package Lista04.Modyfikacja;

import Lista04.Zadanie1.TwoWayLinkedList;

public class AddModificationTest {
    public static void main(String[] args) {
        TwoWayLinkedList<Integer> testList = new TwoWayLinkedList<>();

        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        System.out.println("\ndisplaying list");
        System.out.println(testList);

        testList.add(5, 5000);
        testList.add(1, 1000);
        testList.add(8, 8000);
        testList.add(8, 9000);
        testList.add(6, 20000);
        testList.add(12, 12000);
        System.out.println("\ndisplaying list");
        System.out.println(testList);

//        testList.add(-1, 1);
//        testList.add(14, 12345);
        System.out.println("\ndisplaying list");
        System.out.println(testList);


    }
}
