package Lista10;

public class ListDisjointSet {
    private ListDisjointSet representant;
    private ListDisjointSet next;
    private ListDisjointSet last;
    private int length;

    public ListDisjointSet() {
        representant = this;
        next = null;
        last = this;
        length = 1;
    }

    public ListDisjointSet findRepresentant() {
        return representant;
    }

    public void union(ListDisjointSet setToUnite) {
        ListDisjointSet representant1 = this.findRepresentant();
        ListDisjointSet representant2 = setToUnite.findRepresentant();

        if (representant1 == representant2) {
            return;
        }

        if (representant1.length < representant2.length) {
            ListDisjointSet temp = representant1;
            representant1 = representant2;
            representant2 = temp;
        }

        ListDisjointSet lastSet = representant1.last;
        lastSet.next = representant2;

        representant1.last = representant2.last;
        representant2.last = null;

        representant1.length = representant1.length + representant2.length;
        representant2.length = 0;

        ListDisjointSet currentSet = representant2;
        while (currentSet != null) {
            currentSet.representant = representant1;
            currentSet = currentSet.next;
        }
    }
}
