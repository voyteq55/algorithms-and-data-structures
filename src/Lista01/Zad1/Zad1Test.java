package Lista01.Zad1;

public class Zad1Test {
    public static void main(String[] args) {
        testZigZag(0, 5);
        testZigZag(11, 5);
        testZigZag(3, 8);
        testZigZag(20, 7);
        testScarf(20, 7);
        testScarf(15, 3);
    }

    private static void testZigZag(int n, int l) {
        System.out.println("zigzag n = " + n + ", l = " + l);
        Zad1.drawZigZag(n, l);
    }

    private static void testScarf(int n, int k) {
        System.out.println("scarf n = " + n + ", k = " + k);
        Zad1.drawScarf(n, k);
    }
}
