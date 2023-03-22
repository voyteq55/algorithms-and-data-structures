package Lista03.Modyfikacja1;

import Lista03.Zad1.OneWayLinkedListWithSentinel;

import java.math.BigInteger;
import java.util.Arrays;

public class PalindromeTest {
    public static void main(String[] args) {
        OneWayLinkedListWithSentinel<Integer> testList1 = new OneWayLinkedListWithSentinel<>();
        System.out.println("is " + testList1 + " palindrome: " + testList1.isPalindrome());

        OneWayLinkedListWithSentinel<Integer> testList2 = new OneWayLinkedListWithSentinel<>();
        testList2.add(1);
        testList2.add(2);
        testList2.add(3);
        testList2.add(2);
        testList2.add(1);
        System.out.println("is " + testList2 + " palindrome: " + testList2.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList3 = new OneWayLinkedListWithSentinel<>();
        testList3.add(new BigInteger("100"));
        System.out.println("is " + testList3 + " palindrome: " + testList3.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList4 = new OneWayLinkedListWithSentinel<>();
        testList4.add(new BigInteger("100"));
        testList4.add(new BigInteger("101"));
        System.out.println("is " + testList4 + " palindrome: " + testList4.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList5 = new OneWayLinkedListWithSentinel<>();
        testList5.add(new BigInteger("100"));
        testList5.add(new BigInteger("100"));
        testList5.add(new BigInteger("100"));
        testList5.add(new BigInteger("101"));
        System.out.println("is " + testList5 + " palindrome: " + testList5.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList6 = new OneWayLinkedListWithSentinel<>();
        testList6.add(new BigInteger("1"));
        testList6.add(new BigInteger("2"));
        testList6.add(new BigInteger("3"));
        testList6.add(new BigInteger("4"));
        testList6.add(new BigInteger("1"));
        testList6.add(new BigInteger("2"));
        testList6.add(new BigInteger("3"));
        System.out.println("is " + testList6 + " palindrome: " + testList6.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList7 = new OneWayLinkedListWithSentinel<>();
        testList7.add(new BigInteger("100"));
        testList7.add(new BigInteger("101"));
        testList7.add(new BigInteger("102"));
        testList7.add(new BigInteger("103"));
        testList7.add(new BigInteger("104"));
        testList7.add(new BigInteger("104"));
        testList7.add(new BigInteger("103"));
        testList7.add(new BigInteger("102"));
        testList7.add(new BigInteger("101"));
        testList7.add(new BigInteger("100"));
        System.out.println("is " + testList7 + " palindrome: " + testList7.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList8 = new OneWayLinkedListWithSentinel<>();
        testList8.add(null);
        testList8.add(new BigInteger("5"));
        testList8.add(new BigInteger("5"));
        testList8.add(null);
        System.out.println("is " + testList8 + " palindrome: " + testList8.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList9 = new OneWayLinkedListWithSentinel<>();
        testList9.add(new BigInteger("8"));
        testList9.add(null);
        testList9.add(new BigInteger("5"));
        testList9.add(null);
        testList9.add(new BigInteger("7"));
        System.out.println("is " + testList9 + " palindrome: " + testList9.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList10 = new OneWayLinkedListWithSentinel<>();
        testList10.add(new BigInteger("11"));
        testList10.add(null);
        testList10.add(new BigInteger("12"));
        testList10.add(new BigInteger("13"));
        testList10.add(new BigInteger("14"));
        testList10.add(new BigInteger("13"));
        testList10.add(new BigInteger("12"));
        testList10.add(null);
        testList10.add(new BigInteger("11"));
        System.out.println("is " + testList10 + " palindrome: " + testList10.isPalindrome());

        OneWayLinkedListWithSentinel<BigInteger> testList11 = new OneWayLinkedListWithSentinel<>();
        testList11.add(null);
        System.out.println("is " + testList11 + " palindrome: " + testList11.isPalindrome());


    }
}
