package com.suenara.interviewPuzzles.linkedLists;

import java.util.HashSet;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so
 * as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -) B -) C -) 0 -) E - ) C[thesameCasearlierl
 * Output: C
 */
public class LoopDetection {

    public static <T> SingleLinkedNode<T> hasLoop(SingleLinkedNode<T> head) {
        //TODO: not working yet
        HashSet<SingleLinkedNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }

        return null;
    }
}
