package Lista06;

import java.util.LinkedList;

public class MyQueue<E> extends LinkedList<E> {
    public void enqueue(E element) {
        super.add(element);
    }

    public E dequeue() {
        return super.removeFirst();
    }
}
