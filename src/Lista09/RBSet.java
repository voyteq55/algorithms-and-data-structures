package Lista09;

import java.util.Comparator;
import java.util.TreeSet;

public class RBSet<T> implements ISet<T> {
    TreeSet<T> _set;

    public RBSet(Comparator<T> comparator) {
        _set = new TreeSet<>(comparator);
    }

    @Override
    public void insert(T element) {
        _set.add(element);
    }

    @Override
    public boolean contains(T element) {
        return _set.contains(element);
    }

    @Override
    public boolean remove(T element) {
        return _set.remove(element);
    }
}
