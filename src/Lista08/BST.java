package Lista08;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class BST<T> {
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

        Node(T value, Node leftChild, Node rightChild) {
            this(value);
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        Node getNext() {
            Node currentNode = rightChild;
            if (currentNode == null) {
                return null;
            }
            while (currentNode.leftChild != null) {
                currentNode = currentNode.leftChild;
            }
            return currentNode;
        }

        Node getPrevious() {
            Node currentNode = leftChild;
            if (currentNode == null) {
                return null;
            }
            while (currentNode.rightChild != null) {
                currentNode = currentNode.rightChild;
            }
            return currentNode;
        }
    }

    public BST(Comparator<T> comparator) {
        this._comparator = comparator;
        this._root = null;
    }

    public T search(T element) {
        Node foundNode = searchNode(_root, element);
        return foundNode != null ? foundNode.value : null;
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

    public T findMin() {
        if (_root == null) {
            throw new NoSuchElementException("tree is empty");
        }
        return findMinRecursive(_root).value;
    }

    private Node findMinRecursive(Node node) {
        if (node.leftChild == null) {
            return node;
        }
        return findMinRecursive(node.leftChild);
    }

    public T findMax() {
        if (_root == null) {
            throw new NoSuchElementException("tree is empty");
        }
        return findMaxRecursive(_root).value;
    }

    private Node findMaxRecursive(Node node) {
        if (node.rightChild == null) {
            return node;
        }
        return findMaxRecursive(node.rightChild);
    }

    public void preOrderTraverse(Visitor<T> visitor) {
        preOrderTraverseRecursive(_root, visitor);
    }

    private void preOrderTraverseRecursive(Node node, Visitor<T> visitor) {
        if (node == null) {
            return;
        }
        visitor.visit(node.value);
        preOrderTraverseRecursive(node.leftChild, visitor);
        preOrderTraverseRecursive(node.rightChild, visitor);
    }
    public T nextElement(T element) {
        Node nextNode = nextNode(element);
        return nextNode != null ? nextNode.value : null;
    }

    public Node nextNode(T element) {
        if (element == null) {
            throw new IllegalArgumentException("null is not a valid element");
        }
        if (_root == null) {
            throw new NoSuchElementException("tree is empty");
        }
        Node currentNode = _root;
        Node closestRightParent = null;

        boolean hasFoundElement = false;
        while (currentNode != null && !hasFoundElement) {
            int comparisonResult = _comparator.compare(currentNode.value, element);
            if (comparisonResult > 0) {
                closestRightParent = currentNode;
                currentNode = currentNode.leftChild;
            } else if (comparisonResult < 0) {
                currentNode = currentNode.rightChild;
            } else {
                hasFoundElement = true;
            }
        }
        if (currentNode == null) {
            throw new NoSuchElementException("element " + element + " has not been found in the tree");
        }
        if (currentNode.rightChild != null) {
            return findMinRecursive(currentNode.rightChild);
        }
        return closestRightParent;
    }

    public void insert(T element) {
        Node nodeToInsert = new Node(element);
        if (_root == null) {
            _root = nodeToInsert;
            return;
        }

        Node currentNode = _root;
        Node currentParent = null;
        while (currentNode != null) {
//            if (element == currentNode.value) {
//                throw new IllegalArgumentException("duplicate values are not allowed");
//            }
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

    public void delete(T element) {
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
            throw new NoSuchElementException("element " + element + " not found in the tree");
        }

        if (currentNode.rightChild != null && currentNode.leftChild != null) {
            Node nextElement = findMinRecursive(currentNode.rightChild);
            currentNode.value = nextElement.value;
            deleteImproperDuplicateNodeWithTwoChildren(currentNode.rightChild, nextElement.value, currentNode);
        } else {
            remove(currentNode, currentParent);
        }
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
        if (currentNode == null) {
            throw new NoSuchElementException("element " + element + " not found in the tree");
        }

        remove(currentNode, currentParent);
    }

    private void remove(Node currentNode, Node currentParent) {
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
