package Lista10;

public class ForestDisjointSet {
    private ForestDisjointSet parent;
    private int rank;

    public ForestDisjointSet() {
        parent = this;
        this.rank = 0;
    }

    public ForestDisjointSet findRepresentant() {
        if (parent == this) {
            return this;
        }
        parent = parent.findRepresentant();
        return parent;
    }

    public void union(ForestDisjointSet setToUnite) {
        ForestDisjointSet representant1 = this.findRepresentant();
        ForestDisjointSet representant2 = setToUnite.findRepresentant();

        if (representant1 == representant2) {
            return;
        }

        if (representant1.rank < representant2.rank) {
            ForestDisjointSet temp = representant1;
            representant1 = representant2;
            representant2 = temp;
        }

        representant2.parent = representant1;

        if (representant1.rank == representant2.rank) {
            representant1.rank++;
        }
    }


}
