package Lista01.Modyfikacja1;

public class Substring {
    int position;
    int length;

    public Substring(int position, int length) {
        this.position = position;
        this.length = length;
    }

    public String toString() {
        return "substring - position: " + position + ", length: " + length;
    }
}
