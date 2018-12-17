package com.suenara.interviewPuzzles.linkedLists;

import static com.suenara.interviewPuzzles.linkedLists.SingleLinkedNode.printList;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class ReturnKth {


    public static void main(String[] args) {
        SingleLinkedNode<Integer> head = new SingleLinkedNode<>();
        SingleLinkedNode<Integer> iter = head;
        for (int i = 0; i < 10; ++i) {
            iter.next = new SingleLinkedNode<>();
            iter.value = i;
            iter = iter.next;
        }
        printList(head);

        System.out.println(returnKth(head, 5));

    }

    public static <T> T returnKth(final SingleLinkedNode<T> head, int k) {

        SingleLinkedNode<T> iter = head;

        for (int i = 0; i < k; ++i) {
            if (iter == null) return null;
            iter = iter.next;
        }

        SingleLinkedNode<T> kth = head;

        while (iter.next != null) {
            kth = kth.next;
            iter = iter.next;
        }

        return kth.value;
    }
}
