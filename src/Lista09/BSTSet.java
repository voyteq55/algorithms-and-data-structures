package Lista09;

import java.util.Comparator;

public class BSTSet<T> implements ISet<T> {
    private Node _root;
    private Comparator<T> _comparator;

    class Node {
        T value;
        Node leftChild;
        Node rightChild;

        Node(T value) {
            if (value == null) {
                throw new IllegalArgumentException("value cannot be null");
            }
            this.value = value;
        }
    }

    public BSTSet(Comparator<T> comparator) {
        this._comparator = comparator;
        this._root = null;
    }

    @Override
    public void insert(T element) {
        Node nodeToInsert = new Node(element);
        if (_root == null) {
            _root = nodeToInsert;
            return;
        }

        Node currentNode = _root;
        Node currentParent = null;
        while (currentNode != null) {
            if (element == currentNode.value) {
                return;
            }
            currentParent = currentNode;
            int resultOfComparison = _comparator.compare(currentNode.value, element);
            if (resultOfComparison > 0) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }

        int nodeToBeInsertedAsALeftChild = _comparator.compare(currentParent.value, element);
        if (nodeToBeInsertedAsALeftChild > 0) {
            currentParent.leftChild = nodeToInsert;
        } else {
            currentParent.rightChild = nodeToInsert;
        }
    }

    @Override
    public boolean contains(T element) {
        Node foundNode = searchNode(_root, element);
        return foundNode != null;
    }

    private Node searchNode(Node node, T element) {
        if (node == null) {
            return null;
        }
        int comparisonResult = _comparator.compare(node.value, element);
        if (comparisonResult > 0) {
            return searchNode(node.leftChild, element);
        }
        if (comparisonResult < 0) {
            return searchNode(node.rightChild, element);
        }
        return node;
    }


    @Override
    public boolean remove(T element) {
        if (element == null) {
            throw new IllegalArgumentException("null is not a valid element");
        }
        Node currentNode = _root;
        Node currentParent = null;

        boolean hasFoundElement = false;
        while (currentNode != null && !hasFoundElement) {
            int comparisonResult = _comparator.compare(currentNode.value, element);
            if (comparisonResult == 0) {
                hasFoundElement = true;
            } else  {
                currentParent = currentNode;
                if (comparisonResult > 0) {
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode = currentNode.rightChild;
                }
            }
        }
        if (currentNode == null) {
            return false;
        }

        if (currentNode.rightChild != null && currentNode.leftChild != null) {
            Node nextElement = findMinRecursive(currentNode.rightChild);
            currentNode.value = nextElement.value;
            deleteImproperDuplicateNodeWithTwoChildren(currentNode.rightChild, nextElement.value, currentNode);
        } else {
            detachNode(currentNode, currentParent);
        }
        return true;
    }

    private Node findMinRecursive(Node node) {
        if (node.leftChild == null) {
            return node;
        }
        return findMinRecursive(node.leftChild);
    }

    private void deleteImproperDuplicateNodeWithTwoChildren(Node subTreeRoot, T element, Node subTreeRootParent) {
        Node currentNode = subTreeRoot;
        Node currentParent = subTreeRootParent;

        boolean hasFoundElement = false;
        while (currentNode != null && !hasFoundElement) {
            int comparisonResult = _comparator.compare(currentNode.value, element);
            if (comparisonResult == 0) {
                hasFoundElement = true;
            } else  {
                currentParent = currentNode;
                if (comparisonResult > 0) {
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode = currentNode.rightChild;
                }
            }
        }

        detachNode(currentNode, currentParent);
    }

    private void detachNode(Node currentNode, Node currentParent) {
         Node childNode = (currentNode.leftChild != null) ? currentNode.leftChild : currentNode.rightChild;

        if (currentNode == _root) {
            _root = null;
        } else if (currentParent.leftChild == currentNode) {
            currentParent.leftChild = childNode;
        } else {
            currentParent.rightChild = childNode;
        }
    }
}
