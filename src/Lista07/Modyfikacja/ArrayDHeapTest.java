package Lista07.Modyfikacja;

import java.util.Arrays;

public class ArrayDHeapTest {
    public static void main(String[] args) {
        ArrayDHeap<Integer> dHeap = new ArrayDHeap<>(5);
        Integer[] numbers = new Integer[]{10, 15, 100, 1, 40, 22, 13, 45, 0, -5, -100, 14, 9, 7, -1};
        dHeap.addAll(Arrays.asList(numbers));
        System.out.println("d-heap after adding numbers:");
        System.out.println(dHeap);

        System.out.println("\nshowing minimum values in order:");
        while (!dHeap.isEmpty()) {
            System.out.print(dHeap.minimum() + ", ");
        }

        dHeap.addAll(Arrays.asList(numbers));
        dHeap.add(44);
        System.out.println("\n\nfull heap:");
        System.out.println(dHeap);
        dHeap.add(-16);
        System.out.println("heap after adding 1 element (double array capacity)");
        System.out.println(dHeap);

        dHeap.clear();
        System.out.println("\nheap after clearing:");
        System.out.println(dHeap);
        while (!dHeap.isEmpty()) {
            System.out.print(dHeap.minimum() + ", ");
        }

        dHeap.addAll(Arrays.asList(numbers));
        dHeap.minimum();
        dHeap.minimum();
        dHeap.add(-1000);
        System.out.println("\nheap after modifying:");
        System.out.println(dHeap);

        System.out.println("\nshowing minimum values in order:");
        while (!dHeap.isEmpty()) {
            System.out.print(dHeap.minimum() + ", ");
        }
    }
}
