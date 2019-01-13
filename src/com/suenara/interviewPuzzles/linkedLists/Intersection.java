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


        int sizeA = 1;
        SingleLinkedNode<T> iterA = a;
        while (iterA != null) {
            iterA = iterA.next;
            sizeA++;
        }

        int sizeB = 1;
        SingleLinkedNode<T> iterB = b;
        while (iterB != null) {
            iterB = iterB.next;
            sizeB++;
        }

        if (iterA != iterB) return null;


        if (sizeA > sizeB) {
            iterA = a;
            iterB = b;
            int diff = sizeA - sizeB;
            while (diff > 0) {
                iterA = iterA.next;
                diff--;
            }

        } else if (sizeA < sizeB) {
            iterB = b;
            iterA = a;
            int diff = sizeB - sizeA;
            while (diff > 0) {
                iterB = iterB.next;
                diff--;
            }
        } else {
            iterA = a;
            iterB = b;
        }

        while (iterA != iterB) {
            iterA = iterA.next;
            iterB = iterB.next;
        }

        return iterA;
    }
}
