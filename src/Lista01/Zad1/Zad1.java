package Lista01.Zad1;

public class Zad1 {
    public static void drawZigZag(int n, int l) {
        for (int i = 0; i < n; i++) {
            int step = i % (2*l-2);
            int numberOfSpaces = Math.min(step, 2*l-2-step);
            drawZigZagLine(l, numberOfSpaces);
        }
        System.out.println();
    }

    public static void drawScarf(int n, int k) {
        for (int i = 0; i < n; i++) {
            int step = i % (4*k);
            int numberOfSpaces = Math.min(step, 4*k-step);
            int circlesStep = i % (2*k-2);
            int numberOfSideCircles = Math.min(circlesStep, 2*k-2-circlesStep);
            drawScarfLine(k, numberOfSpaces, numberOfSideCircles);
        }
        System.out.println();
    }

    private static void drawZigZagLine(int l, int emptySpaces) {
        draw(" ", emptySpaces);
        draw("#", l);
        System.out.println();
    }

    private static void drawScarfLine(int k, int emptySpaces, int sideCircles) {
        draw(" ", emptySpaces);
        draw("#", k - sideCircles);
        draw("O", 2 * sideCircles + 1);
        draw("#", k - sideCircles);
        System.out.println();
    }

    private static void draw(String character, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(character);
        }
    }
}
