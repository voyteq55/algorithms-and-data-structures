package Lista11;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxBinomialHeap<T> {
    // extractMin
    private Node _head;
    private Comparator<T> cmp;

    class Node {
        T value;
        Node parent;
        Node child;
        Node nextSibling;
        int degree;

        Node(T value) {
            this.value = value;
            this.parent = null;
            this.child = null;
            this.nextSibling = null;
            this.degree = 0;
        }

        Node linkTree(Node rootNode) {
            if (cmp.compare(this.value, rootNode.value) < 0) {
                return rootNode.linkTree(this);
            }
            rootNode.nextSibling = this.child;
            this.child = rootNode;
            rootNode.parent = this;
            this.degree++;
            return this;
        }

    }

    public MaxBinomialHeap(Comparator<T> cmp) {
        this._head = null;
        this.cmp = (o1, o2) -> {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return cmp.compare(o1, o2);
        };
    }

    public T findMaximum() {
        Node maximumNode = findMaximumNode();
        if (maximumNode == null) {
            throw new NoSuchElementException("binomial heap is empty");
        }
        return maximumNode.value;
    }

    private Node findMaximumNode() {
        Node maxNode = null;
        Node currentNode = _head;
        while (currentNode != null) {
            if (maxNode == null || cmp.compare(currentNode.value, maxNode.value) > 0) {
                maxNode = currentNode;
            }
            currentNode = currentNode.nextSibling;
        }
        return maxNode;
    }

    private Node merge(Node root1, Node root2) {
        Node dummyNodeBeforeNewRoot = new Node(null);
        Node currentNode = dummyNodeBeforeNewRoot;

        while (root1 != null && root2 != null) {
            if (root1.degree <= root2.degree) {
                currentNode.nextSibling = root1;
                root1 = root1.nextSibling;
            } else {
                currentNode.nextSibling = root2;
                root2 = root2.nextSibling;
            }
            currentNode = currentNode.nextSibling;
        }

        if (root1 != null) {
            currentNode.nextSibling = root1;
        }
        if (root2 != null) {
            currentNode.nextSibling = root2;
        }

        return dummyNodeBeforeNewRoot.nextSibling;
    }

    public void union(MaxBinomialHeap<T> heap) {
        if (heap == null) {
            throw new IllegalArgumentException("cannot merge heap with null");
        }
        if (heap._head == null) {
            return;
        }
        if (this._head == null) {
            this._head = heap._head;
            return;
        }

        this._head = merge(this._head, heap._head);

        Node previousTree = null;
        Node currentTree = this._head;
        Node nextTree = this._head.nextSibling;

        while (nextTree != null) {
            if ((currentTree.degree != nextTree.degree) || (nextTree.nextSibling != null && currentTree.degree == nextTree.nextSibling.degree)) {
                previousTree = currentTree;
                currentTree = nextTree;
            } else if (cmp.compare(currentTree.value, nextTree.value) >= 0){
                currentTree.nextSibling = nextTree.nextSibling;
                currentTree.linkTree(nextTree);
            } else {
                if (previousTree == null) {
                    this._head = nextTree;
                } else {
                    previousTree.nextSibling = nextTree;
                }
                nextTree.linkTree(currentTree);
                currentTree = nextTree;
            }

            nextTree = currentTree.nextSibling;
        }

    }


    public void insert(T element) {
        insertNode(new Node(element));
    }

    public void insertNode(Node node) {
        MaxBinomialHeap<T> oneNodeHeap = new MaxBinomialHeap<>(cmp);
        oneNodeHeap._head = node;
        this.union(oneNodeHeap);
    }

    public T extractMaximum() {
        if (_head == null) {
            throw new NoSuchElementException("binomial heap is empty");
        }
        // find maximum node and remove from roots
        Node maximumNode = null;
        Node currentNode = _head;
        Node previousNode = null;
        Node nodeBeforeMaximum = null;
        while (currentNode != null) {
            if (maximumNode == null || cmp.compare(currentNode.value, maximumNode.value) > 0) {
                maximumNode = currentNode;
                nodeBeforeMaximum = previousNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextSibling;
        }
        if (nodeBeforeMaximum == null) {
            _head = maximumNode.nextSibling;
        } else {
            nodeBeforeMaximum.nextSibling = maximumNode.nextSibling;
        }

        MaxBinomialHeap<T> newHeapToMerge = new MaxBinomialHeap<>(cmp);

        // reversing children of maximum node and linking to a heap
        Node previousChild = null;
        Node currentChild = maximumNode.child;
        Node nextChild;
        while (currentChild != null) {
            nextChild = currentChild.nextSibling;
            currentChild.parent = null;
            currentChild.nextSibling = previousChild;
            previousChild = currentChild;
            currentChild = nextChild;
        }

        newHeapToMerge._head = previousChild;

        this.union(newHeapToMerge);

        return maximumNode.value;
    }

    public void increaseKey(Node node, T increasedValue) {
        if (node == null) throw new IllegalArgumentException("node cannot be null");
        if (cmp.compare(increasedValue, node.value) <= 0) throw new IllegalArgumentException("key has to be greater than the original key");

        node.value = increasedValue;
        Node currentNode = node;

        while (currentNode.parent != null && cmp.compare(currentNode.value, currentNode.parent.value) > 0) {
            T tempValue = currentNode.value;
            currentNode.value = currentNode.parent.value;
            currentNode.parent.value = tempValue;

            currentNode = currentNode.parent;
        }
    }

    public void delete(Node node) {
        increaseKey(node, null);
        extractMaximum();
    }


}
