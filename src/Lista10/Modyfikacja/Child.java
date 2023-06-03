package Lista10.Modyfikacja;

import Lista10.ListDisjointSet;

public class Child {
    private String name;
    private ListDisjointSet set;

    public Child(String name) {
        this.name = name;
        this.set = new ListDisjointSet();
    }

    public void befriend(Child child) {
        this.set.union(child.set);
    }

    public boolean isFriendsWith(Child child) {
        return this.set.findRepresentant() == child.set.findRepresentant();
    }

    @Override
    public String toString() {
        return "dziecko " + name;
    }
}
