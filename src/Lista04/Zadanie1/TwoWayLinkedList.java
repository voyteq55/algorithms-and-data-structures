package Lista04.Zadanie1;

import java.util.Iterator;

public class TwoWayLinkedList<E> implements IList<E> {


    private class Element {
        private E value;
        private Element next;
        private Element previous;

        public Element(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getPrevious() {
            return previous;
        }

        public void setPrevious(Element previous) {
            this.previous = previous;
        }

        public void insertAfter(Element elementToInsert) {
            elementToInsert.setNext(this.getNext());
            elementToInsert.setPrevious(this);
            if (this.getNext() != null) {
                this.getNext().setPrevious(elementToInsert);
            }
            this.setNext(elementToInsert);
        }

        public void insertBefore(Element elementToInsert) {
            elementToInsert.setPrevious(this.getPrevious());
            elementToInsert.setNext(this);
            if (this.getPrevious() != null) {
                this.getPrevious().setNext(elementToInsert);
            }
            this.setPrevious(elementToInsert);
        }

        public void remove() {
            if (this.getNext() != null) {
                this.getNext().setPrevious(this.getPrevious());
            }
            if (this.getPrevious() != null) {
                this.getPrevious().setNext(this.getNext());
            }
        }

        @Override
        public String toString() {
            if (value == null) {
                return "null";
            }
            return value.toString();
        }
    }

    private Element head;
    private Element tail;

    private int _size;

    public TwoWayLinkedList() {}

    private Element getElement(int index) {
        if (index<0) {
            throw new IndexOutOfBoundsException("index cannot be negative (" + index + "}");
        }
        if (index > _size ) {
            throw new IndexOutOfBoundsException("index cannot be greater than size of the list");
        }
        Element currentElement;
        if (index < (1 + _size) / 2) {
            currentElement = head;
            while (currentElement != null && index > 0) {
                currentElement = currentElement.getNext();
                index--;
            }
        } else {
            currentElement = tail;
            while (currentElement != null && index < _size) {
                currentElement = currentElement.getPrevious();
                index++;
            }
        }
        return currentElement;
    }

    @Override
    public boolean add(E e) {
        Element elementToAdd = new Element(e);
        if (tail == null) {
            head = elementToAdd;
            tail = elementToAdd;
            return true;
        }
        tail.insertAfter(elementToAdd);
        tail = elementToAdd;
        _size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        Element elementToAdd = new Element(element);
        if (index == 0) {
            if (head == null) {
                head = elementToAdd;
                tail = elementToAdd;
            } else {
                head.insertBefore(elementToAdd);
                head = elementToAdd;
            }
        } else {
            Element elementBefore = getElement(index - 1);
            elementBefore.insertAfter(elementToAdd);
            if (elementBefore == tail) {
                tail = elementToAdd;
            }
        }
        _size++;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        _size = 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public E get(int index) {
        return getElement(index).getValue();
    }

    @Override
    public E set(int index, E element) {
        Element elementToModify = getElement(index);
        E valueToReturn = elementToModify.getValue();
        elementToModify.setValue(element);
        return valueToReturn;
    }

    @Override
    public int indexOf(E element) {
        Element currentElement = head;
        int counter = 0;
        while (currentElement != null) {
            if ( (currentElement.getValue() != null && currentElement.getValue().equals(element))  ||  (currentElement.getValue() == null && element == null) ) {
                return counter;
            }
            currentElement = currentElement.getNext();
            counter++;
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public E remove(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("cannot remove anything from an empty list");
        }
        Element elementToRemove = getElement(index);
        E valueToReturn = elementToRemove.getValue();
        if (elementToRemove == head) {
            head = elementToRemove.getNext();
        }
        if (elementToRemove == tail) {
            tail = elementToRemove.getPrevious();
        }
        elementToRemove.remove();
        _size--;
        return valueToReturn;
    }

    @Override
    public boolean remove(E element) {
        Element currentElement = head;
        while (currentElement != null) {
            if ( (currentElement.getValue() != null && currentElement.getValue().equals(element))  ||  (currentElement.getValue() == null && element == null) ) {
                if (currentElement == head) {
                    head = currentElement.getNext();
                }
                if (currentElement == tail) {
                    tail = currentElement.getPrevious();
                }
                currentElement.remove();
                return true;
            }
            currentElement = currentElement.getNext();
        }
        _size--;
        return false;
    }

    @Override
    public int size() {
//        Element currentElement = head;
//        int counter = 0;
//        while (currentElement != null) {
//            currentElement = currentElement.getNext();
//            counter++;
//        }
//        return counter;
        return _size;
    }


    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("iterators are not supported");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        Element currentElement = head;
        while (currentElement != null) {
            builder.append(currentElement);
            if (currentElement.getNext() != null) {
                builder.append(", ");
            }
            currentElement = currentElement.getNext();
        }
        builder.append(']');
        return builder.toString();
    }

}
