package Lista09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class SkipSet<T> implements ISet<T> {
    private Comparator<T> comparator;
    private Random random;
    private double p;
    private Node head;
    private int highestLevel;

    public SkipSet(Comparator<T> comparator, double p) {
        this.comparator = comparator;
        this.random = new Random();
        this.p = p;
        this.head = null;
        this.highestLevel = 0;
    }

    class Node {
        private static final int MAXLEVEL = 32;
        private T value;
        private ArrayList<Node> forwardNodes;

        Node(T element, int levels) {
            this.value = element;
            this.forwardNodes = new ArrayList<>(Collections.nCopies(MAXLEVEL, null));
        }
    }

    @Override
    public void insert(T element) {
        int level = randomLevel();
        if (level > highestLevel) {
            highestLevel = level;
        }
        Node nodeToInsert = new Node(element, level);

        insertNode(head, nodeToInsert, highestLevel);
    }

    private void insertNode(Node currentNode, Node nodeToInsert, int level) {
        if (level < 0) {
            return;
        }
        if (head == null) {
            head = nodeToInsert;
            return;
        }

        while (currentNode.forwardNodes.get(level) != null && comparator.compare(currentNode.forwardNodes.get(level).value, currentNode.value) < 0) {
            currentNode = currentNode.forwardNodes.get(level);
        }

        if (level <= nodeToInsert.forwardNodes.size() - 1) {
            nodeToInsert.forwardNodes.set(level, currentNode.forwardNodes.get(level));
            currentNode.forwardNodes.set(level, nodeToInsert);
        }

        insertNode(currentNode, nodeToInsert, level - 1);
    }

    @Override
    public boolean contains(T element) {
        Node currentNode = head;
        boolean hasFoundElement = false;
        int currentLevel = highestLevel;
        while (currentLevel >= 0 && !hasFoundElement) {
            if (currentNode == null || currentNode.forwardNodes.get(currentLevel) == null) {
                currentLevel--;
            } else if (comparator.compare(currentNode.forwardNodes.get(currentLevel).value, element) > 0) {
                currentLevel--;
            } else {
                currentNode = currentNode.forwardNodes.get(currentLevel);
                if (comparator.compare(currentNode.value, element) == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean remove(T element) {
        return removeNode(head, element, this.highestLevel) != null;
    }

    private Node removeNode(Node node, T element, int level) {
        if (level < 0 || node == null) {
            return null;
        }
        Node nodeToRemove;

        if (node.forwardNodes.get(level) == null) {
            return removeNode(node, element, level - 1);
        }
        int resultOfComparison = comparator.compare(node.forwardNodes.get(level).value, element);
        if (resultOfComparison > 0) {
            nodeToRemove = removeNode(node, element, level - 1);
            if (nodeToRemove != null) {
                node.forwardNodes.set(level, nodeToRemove.forwardNodes.get(level));
            } else {
                node.forwardNodes.set(level, null);
            }
            return nodeToRemove;
        }
        if (resultOfComparison < 0) {
            return removeNode(node.forwardNodes.get(level), element, level);
        }
        // if found element
        if (level != 0) {
            return removeNode(node, element, level - 1);
        }
        nodeToRemove = node.forwardNodes.get(level);
        node.forwardNodes.set(level, nodeToRemove.forwardNodes.get(level));
        return nodeToRemove;
    }

    private int randomLevel() {
        int level = 0;
        while (random.nextDouble() < p) {
            level++;
        }
        return level;
    }
}
