package Lista03.Zad1;

import java.util.Iterator;

public class OneWayLinkedListWithSentinel<E> implements IList<E> {

    private class Element {
        private E value;
        private Element next;

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

        @Override
        public String toString() {
            if (value == null) {
                return "null";
            }
            return value.toString();
        }
    }

    private final Element sentinel;

    public OneWayLinkedListWithSentinel() {
        this.sentinel = new Element(null);
    }

    private Element getElement(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("requested list index cannot be negative (" + index + ")");
        }
        Element currentElement = sentinel.getNext();
        while (index > 0 && currentElement != null) {
            currentElement = currentElement.getNext();
            index--;
        }
        if (currentElement == null) {
            throw new IndexOutOfBoundsException("requested list index is too big (list size: " + this.size() + ")");
        }
        return currentElement;
    }

    private Element getElementIncludingSentinel(int index) {
        if (index < -1) {
            throw new IndexOutOfBoundsException("requested list index cannot be smaller than -1 (" + index + ")");
        }
        Element currentElement = sentinel;
        while (index > -1 && currentElement != null) {
            currentElement = currentElement.getNext();
            index--;
        }
        if (currentElement == null) {
            throw new IndexOutOfBoundsException("requested list index is too big (list size: " + this.size() + ")");
        }
        return currentElement;
    }

    @Override
    public boolean add(E e) {
        Element elementToAdd = new Element(e);
        Element tail = sentinel;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(elementToAdd);
        return true;
    }

    //this method uses getElementIncludingSentinel() because it uses the previous element
    @Override
    public void add(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("requested list index cannot be negative (" + index + ")");
        }
        Element elementToAdd = new Element(element);
        Element currentElement = getElementIncludingSentinel(index - 1);

        elementToAdd.setNext(currentElement.getNext());
        currentElement.setNext(elementToAdd);
    }

    @Override
    public void clear() {
        this.sentinel.setNext(null);
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public E get(int index) {
        Element elementToGet = getElement(index);
        return elementToGet.getValue();
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
        int index = 0;
        Element currentElement = sentinel.getNext();
        while (currentElement != null) {
            if (currentElement.getValue() != null && currentElement.getValue().equals(element)) {
                return index;
            } else if (element == null){
                return index;
            }
            currentElement = currentElement.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.sentinel.getNext() == null;
    }

    //this method uses getElementIncludingSentinel() because it uses the previous element
    @Override
    public E remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("requested list index cannot be negative (" + index + ")");
        }
        if (sentinel.getNext() == null) {
            throw new IndexOutOfBoundsException("list is empty (can't remove anything)");
        }
        Element currentElement = getElementIncludingSentinel(index - 1);
        if (currentElement.getNext() == null) {
            throw new IndexOutOfBoundsException("requested list index is too big (list size: " + this.size() + ")");
        }
        E valueToReturn = currentElement.getNext().getValue();
        currentElement.setNext(currentElement.getNext().getNext());
        return valueToReturn;
    }

    @Override
    public boolean remove(E element) {
        Element previous = sentinel;
        while (previous.getNext() != null) {
            if (previous.getNext().getValue() != null && previous.getNext().getValue().equals(element)) {
                previous.setNext(previous.getNext().getNext());
                return true;
            } else if (element == null){
                previous.setNext(previous.getNext().getNext());
                return true;
            }
            previous = previous.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        int position = 0;
        Element currentElement = sentinel.getNext();
        while (currentElement != null) {
            currentElement = currentElement.getNext();
            position++;
        }
        return position;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("no support for iterators");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        Element currentElement = sentinel.getNext();
        while (currentElement != null) {
            builder.append(currentElement).append(", ");
            currentElement = currentElement.getNext();
        }
        builder.append(']');
        return builder.toString();
    }
}
