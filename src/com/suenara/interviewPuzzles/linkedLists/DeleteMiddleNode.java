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


    public static <T> void delete(SingleLinkedNode<T> node) {
        if (node == null || node.next == null) return;
        node.value = node.next.value;
        node.next = node.next.next;
    }

    public static <T> void delete(DoubleLinkedNode<T> node) {
        if (node == null) return;

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
    }

}
