package Lista08;

import java.util.Comparator;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> binarySearchTree = new BST<>(Comparator.<Integer>naturalOrder());

        binarySearchTree.insert(14);
        binarySearchTree.insert(22);
        binarySearchTree.insert(19);
        binarySearchTree.insert(6);
        binarySearchTree.insert(8);
        binarySearchTree.insert(7);
        binarySearchTree.insert(3);
        binarySearchTree.insert(17);
        binarySearchTree.insert(20);
        binarySearchTree.insert(4);
        binarySearchTree.insert(25);
        binarySearchTree.insert(5);

        System.out.println(binarySearchTree.search(14));
        System.out.println(binarySearchTree.findMin());
        System.out.println(binarySearchTree.findMax());

        Visitor<Integer> printingVisitor = new Visitor<Integer>() {
            @Override
            public void visit(Integer element) {
                System.out.print(element + ", ");
            }
        };

        System.out.println("\npre-order traversal:");
        binarySearchTree.preOrderTraverse(printingVisitor);

        System.out.println("\n\nshowing in-order elements:");
        Integer element = binarySearchTree.findMin();
        while (element != null) {
            System.out.print(element + ", ");
            element = binarySearchTree.nextElement(element);
        }

        binarySearchTree.delete(4);
        binarySearchTree.delete(25);
        binarySearchTree.delete(14);
        binarySearchTree.delete(17);

        System.out.println("\n\nshowing in-order elements after deleting:");
        element = binarySearchTree.findMin();
        while (element != null) {
            System.out.print(element + ", ");
            element = binarySearchTree.nextElement(element);
        }
        System.out.println("\n" + binarySearchTree.findMin());
        System.out.println(binarySearchTree.findMax());

    }
}
