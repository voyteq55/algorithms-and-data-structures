package Lista02.Modyfikacja;

import Lista02.Zad1.Array2;

import java.math.BigInteger;
import java.util.Iterator;

public class Modyfikacja2Test {
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

        System.out.println("value at index [2, 1] (should be 5):");
        System.out.println(arr1.get(2, 1));

        System.out.println("\ndisplaying every 3rd element:");
        Iterator<BigInteger> iter = arr1.iterator(2);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Array2<BigInteger> arr2 = new Array2<>(new int[]{});
        System.out.println("\ndisplaying elements of an empty array (shouldnt display anything):");
        Iterator<BigInteger> iter2 = arr2.iterator(3);
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }

        Array2<BigInteger> arr3 = new Array2<>(new int[]{0, 0, 2, 0, 1, 2, 0});
        arr3.set(new BigInteger("20"), 2, 0);
        arr3.set(new BigInteger("21"), 2, 1);
        arr3.set(new BigInteger("40"), 4, 0);
        arr3.set(new BigInteger("50"), 5, 0);
        arr3.set(new BigInteger("51"), 5, 1);
        System.out.println("\ndisplaying every 2nd element of an array with some subarrays emmpty:");
        Iterator<BigInteger> iter3 = arr3.iterator(2);
        while (iter3.hasNext()) {
            System.out.println(iter3.next());
        }

        Array2<BigInteger> arr4 = new Array2<>(new int[]{0, 0, 0, 0, 0, 0, 0});
        System.out.println("\ndisplaying elements of an array of empty subarrays (shouldnt display anything):");
        Iterator<BigInteger> iter4 = arr4.iterator(2);
        while (iter4.hasNext()) {
            System.out.println(iter4.next());
        }

        System.out.println("\ntrying to display an array with illegal arguments:");
        try {
            Array2<BigInteger> arr5 = new Array2<>(new int[]{2, 1});
            arr5.set(new BigInteger("1"), 0, 0);
            arr5.set(new BigInteger("2"), 0, 1);
            Iterator<BigInteger> iter5 = arr4.iterator(-2);
            while (iter5.hasNext()) {
                System.out.println(iter5.next());
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
