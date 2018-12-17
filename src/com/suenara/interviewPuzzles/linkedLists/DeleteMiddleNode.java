package com.suenara.interviewPuzzles.linkedLists;

import static com.suenara.interviewPuzzles.linkedLists.ListUtils.createIntListFromZeroToN;
import static com.suenara.interviewPuzzles.linkedLists.SingleLinkedNode.printList;

/**
 * Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * Input: the node c from the linked list a - >b- >c - >d - >e- >f
 * Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
 */
public class DeleteMiddleNode {

    public static void main(String[] args) {
        SingleLinkedNode<Integer> head = createIntListFromZeroToN(10);

        SingleLinkedNode<Integer> iter = head;
        for (int i = 0; i < 5; ++i) {
            iter = iter.next;
        }
        printList(head);

        System.out.println();

        delete(iter);
        printList(head);
    }


    public static <T>void delete(SingleLinkedNode<T> node) {
        SingleLinkedNode<T> iter = node;
        while (iter.next != null) {
            iter.value = iter.next.value;
            if (iter.next.next == null) {
                iter.next = null;
                break;
            }
            iter = iter.next;
        }
    }

}
