package com.suenara.interviewPuzzles.linkedLists;

/**
 * Sum Lists: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
 * function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7-) 1 -) 6) + (5 -) 9 -) 2).Thatis,617 + 295.
 * Output: 2 -) 1 -) 9. That is, 912.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6 -) 1 -) 7) + (2 -) 9 -) 5).Thatis,617 + 295.
 * Output: 9 -) 1 -) 2. That is, 912.
 */
public class SumLists {

    public static void main(String[] args) {
        testReverse();
        testForward();
    }

    private static void testForward() {
        SingleLinkedNode<Integer> iterator;
        SingleLinkedNode<Integer> a = writeNumberAsList("617");
        SingleLinkedNode<Integer> b = writeNumberAsList("295");


        iterator = sumForward(a, b);
        StringBuilder sumBuilder = new StringBuilder();
        while (iterator != null) {
            sumBuilder.append(iterator.value);
            iterator = iterator.next;
        }
        System.out.println(sumBuilder.toString().equals("912"));
    }

    private static void testReverse() {
        SingleLinkedNode<Integer> sumReversed = sumReversed(writeNumberAsList("716"), writeNumberAsList("592"));

        SingleLinkedNode<Integer> iterator = sumReversed;
        StringBuilder sumBuilder = new StringBuilder();
        while (iterator != null) {
            sumBuilder.append(iterator.value);
            iterator = iterator.next;
        }
        System.out.println(sumBuilder.toString().equals("219"));
    }

    public static SingleLinkedNode<Integer> sumReversed(SingleLinkedNode<Integer> a, SingleLinkedNode<Integer> b) {
        int buffer = 0;

        if (a == null || b == null) return null;

        SingleLinkedNode<Integer> result = new SingleLinkedNode<>();
        SingleLinkedNode<Integer> resultIter = result;

        while (a != null && b != null) {
            buffer += a.value + b.value;
            resultIter.value = buffer % 10;
            buffer /= 10;

            if (a.next != null && b.next != null) {
                resultIter.next = new SingleLinkedNode<>();
                resultIter = resultIter.next;
            }
            a = a.next;
            b = b.next;
        }

        SingleLinkedNode<Integer> lastIter = null;
        if (a == null && b != null) {
            lastIter = b;
        } else if (b == null && a != null) {
            lastIter = a;
        }
        if (lastIter != null) {
            resultIter.next = new SingleLinkedNode<>();
            resultIter = resultIter.next;
            while (lastIter != null) {
                buffer += lastIter.value;
                resultIter.value = buffer % 10;
                buffer /= 10;
                if (lastIter.next != null) {
                    resultIter.next = new SingleLinkedNode<>();
                    resultIter = resultIter.next;
                }
                lastIter = lastIter.next;
            }
        }

        while (buffer > 0) {
            resultIter.next = new SingleLinkedNode<>();
            resultIter = resultIter.next;
            resultIter.value = buffer % 10;
            buffer /= 10;
        }

        return result;
    }

    public static SingleLinkedNode<Integer> sumForward(SingleLinkedNode<Integer> a, SingleLinkedNode<Integer> b) {
        if (a == null || b == null) return null;

        SingleLinkedNode<Integer> result = new SingleLinkedNode<>();
        SingleLinkedNode<Integer> resultIter = result;

        result.value = a.value + b.value;
        result.next = sumForward(a.next, b.next);

        if (result.next != null) {
            result.value = result.next.value / 10 + result.value;
            result.next.value = result.next.value % 10;
        }

        return result;
    }

    private static SingleLinkedNode<Integer> writeNumberAsList(String number) {
        SingleLinkedNode<Integer> result = new SingleLinkedNode<>();

        SingleLinkedNode<Integer> iter = result;
        for (int i = 0; i < number.length(); ++i) {
            iter.value = Character.getNumericValue(number.charAt(i));
            if (i != number.length() - 1) {
                iter.next = new SingleLinkedNode<>();
                iter = iter.next;
            }
        }
        return result;
    }
}
