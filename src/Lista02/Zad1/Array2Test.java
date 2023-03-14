package Lista02.Zad1;

import java.math.BigInteger;
import java.util.Iterator;

public class Array2Test {
    public static void main(String[] args) {
        Array2<BigInteger> arr1 = new Array2<>(new int[]{4, 3, 2, 1});
        arr1.set(new BigInteger("234273498234723453"), 0, 0);
        arr1.set(new BigInteger("21167236424234234"), 0, 1);
        arr1.set(new BigInteger("326472637424333"), 0, 2);
        arr1.set(new BigInteger("6383420934822"), 0, 3);

        arr1.set(new BigInteger("1234134"), 1, 0);
        arr1.set(new BigInteger("123412341234"), 1, 1);
        arr1.set(new BigInteger("1234123412341234"), 1, 2);

        arr1.set(new BigInteger("2"), 2, 0);
        arr1.set(new BigInteger("5"), 2, 1);

        arr1.set(new BigInteger("88"), 3, 0);

        System.out.println("value at index (2, 1)");
        System.out.println(arr1.get(2, 1));

        System.out.println("\ndisplaying all array elements (using iterator):");
        Iterator<BigInteger> iter = arr1.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("\ndisplaying all array elements (using for each loop):");
        for (BigInteger bigInteger : arr1) {
            System.out.println(bigInteger);
        }

        Array2<BigInteger> arr2 = new Array2<>(new int[]{});
        System.out.println("\ndisplaying elements of an empty array (shouldnt display anything):");
        for (BigInteger bigInteger : arr2) {
            System.out.println(bigInteger);
        }

        try {
            Array2<BigInteger> arr3 = new Array2<>(new int[]{2, 0, 2});
            arr3.set(new BigInteger("1"), 0, 0);
            arr3.set(new BigInteger("2"), 0, 1);
            arr3.set(new BigInteger("3"), 2, 0);
            arr3.set(new BigInteger("4"), 0, 1);
            for (BigInteger bigInteger : arr2) {
                System.out.println(bigInteger);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("\nexception raised:");
            System.out.println(exception.getMessage());
        }

    }
}
