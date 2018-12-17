package com.suenara.interviewPuzzles.linkedLists;

/**
 * Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the
 * intersecting node. Note that the intersection is defined based on reference, not value. That is, if the
 * kth node of the first linked list is the exact same node (by reference) as the jth node of the second
 * linked list, then they are intersecting.
 */
public class Intersection {

    public static <T> SingleLinkedNode<T> isIntersects(SingleLinkedNode<T> a, SingleLinkedNode<T> b) {
        if (a == null || b == null) return null;

        SingleLinkedNode<T> iterA = a;
        while (iterA != null) {
            SingleLinkedNode<T> iterB = b;
            while (iterB != null) {
                if (iterA == iterB) return iterA;
                iterB = iterB.next;
            }
            iterA = iterA.next;
        }
        return null;
    }
}
