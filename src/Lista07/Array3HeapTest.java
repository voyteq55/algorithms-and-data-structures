package Lista07;

import java.util.Arrays;

public class Array3HeapTest {
    public static void main(String[] args) {
        Array3Heap<Integer> ternaryHeap = new Array3Heap<>();
        Integer[] numbers = new Integer[]{10, 15, 100, 1, 40, 22, 13, 45, 0, -5, -100, 14, 9, 7, -1};
        ternaryHeap.addAll(Arrays.asList(numbers));
        System.out.println("ternary heap after adding numbers:");
        System.out.println(ternaryHeap);

        System.out.println("\nshowing minimum values in order:");
        while (!ternaryHeap.isEmpty()) {
            System.out.print(ternaryHeap.minimum() + ", ");
        }

        ternaryHeap.addAll(Arrays.asList(numbers));
        ternaryHeap.add(44);
        System.out.println("\n\nfull heap:");
        System.out.println(ternaryHeap);
        ternaryHeap.add(-16);
        System.out.println("heap after adding 1 element (double array capacity)");
        System.out.println(ternaryHeap);

        ternaryHeap.clear();
        System.out.println("\nheap after clearing:");
        System.out.println(ternaryHeap);
        while (!ternaryHeap.isEmpty()) {
            System.out.print(ternaryHeap.minimum() + ", ");
        }

        ternaryHeap.addAll(Arrays.asList(numbers));
        ternaryHeap.minimum();
        ternaryHeap.minimum();
        ternaryHeap.add(-1000);
        System.out.println("\nheap after modifying:");
        System.out.println(ternaryHeap);
    }
}
