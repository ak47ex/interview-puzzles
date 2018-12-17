package com.suenara.interviewPuzzles.linkedLists;

import static com.suenara.interviewPuzzles.linkedLists.ListUtils.createRandomList;
import static com.suenara.interviewPuzzles.linkedLists.SingleLinkedNode.printList;

/**
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 [partition = 5)
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
public class Partition {

    public static void main(String[] args) {

        SingleLinkedNode<Integer> head = createRandomList(10);

        printList(head);

        int pivot = 5;
        System.out.println(String.format("Pivot is %s", pivot));
        head = partition(head, pivot);
        printList(head);
    }

    public static <T extends Comparable<T>> SingleLinkedNode<T> partition(SingleLinkedNode<T> head, T pivot) {
        SingleLinkedNode<T> less = null;
        SingleLinkedNode<T> equalsOrGreater = null;

        SingleLinkedNode<T> startIter = null;
        SingleLinkedNode<T> midIter = null;

        while (head != null) {
            if (head.value.compareTo(pivot) < 0) {
                if (less == null) {
                    less = head;
                    startIter = less;

                } else {
                    startIter.next = head;
                    startIter = startIter.next;
                }
                head = head.next;
                startIter.next = null;

            } else {
                if (equalsOrGreater == null) {
                    equalsOrGreater = head;
                    midIter = equalsOrGreater;
                } else {
                    midIter.next = head;
                    midIter = midIter.next;
                }
                head = head.next;
                midIter.next = null;
            }
        }
        if (startIter != null) {
            startIter.next = equalsOrGreater;
            return less;
        } else {
            return equalsOrGreater;
        }
    }
}
