package com.suenara.interviewPuzzles.linkedLists;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        DoubleLinkedNode<Integer> head = new DoubleLinkedNode<>();

        DoubleLinkedNode<Integer> iter = head;

        for (int i = 0; i < 10; ++i) {
            if (i > 1 && Math.random() > 0.7) i--;

            DoubleLinkedNode<Integer> next = new DoubleLinkedNode<>();
            iter.value = i;
            iter.next = next;
            next.prev = iter;
            iter = next;
        }

        iter = head;
        while (iter.next != null) {
            System.out.print(iter.value);
            iter = iter.next;
        }

        System.out.println();
        removeDuplicate(head);

        iter = head;
        while (iter.next != null) {
            System.out.print(iter.value);
            iter = iter.next;
        }

    }

    public static <T>void removeDuplicate(DoubleLinkedNode<T> listHead) {
        DoubleLinkedNode<T> iterator = listHead;
        while (iterator != null) {
            DoubleLinkedNode<T> node = iterator.next;
            while (node != null) {
                if (iterator.value == node.value) removeNode(node);
                node = node.next;
            }
            iterator = iterator.next;
        }
    }

    public static void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode parent = node.prev;
        DoubleLinkedNode child = node.next;
        if (parent != null) parent.next = child;
        if (child != null) child.prev = parent;
    }

}
