package Lista11;

import java.util.Comparator;

public class MaxBinomialHeapTest {
    public static void main(String[] args) {
        MaxBinomialHeap<Integer> testHeap = new MaxBinomialHeap<>(Comparator.<Integer>naturalOrder());
        testHeap.insert(5);
        testHeap.insert(16);
        testHeap.insert(123);
        testHeap.insert(3);
        testHeap.insert(4);
        testHeap.insert(17);
        testHeap.insert(25);
        testHeap.insert(31);
        testHeap.insert(121);
        testHeap.insert(22);

        System.out.println("extracting maximum keys:");
        System.out.println(testHeap.extractMaximum());
        System.out.println(testHeap.extractMaximum());
        System.out.println(testHeap.extractMaximum());
        System.out.println(testHeap.extractMaximum());
        System.out.println(testHeap.extractMaximum());

        MaxBinomialHeap<Integer>.Node testNode = testHeap.new Node(7);
        testHeap.insertNode(testNode);

        System.out.println("\nfinding max key after inserting node with key 7:");
        System.out.println(testHeap.findMaximum());

        testHeap.increaseKey(testNode, 1000);

        System.out.println("\nfinding maximum key after increasing the key from 7 to 1000:");
        System.out.println(testHeap.findMaximum());

        testHeap.delete(testNode);

        System.out.println("\nextracting maximum keys after deleting node with key 1000:");

        System.out.println(testHeap.extractMaximum());
        System.out.println(testHeap.extractMaximum());
        System.out.println(testHeap.extractMaximum());
        System.out.println(testHeap.extractMaximum());
        System.out.println(testHeap.extractMaximum());


    }
}
