package com.suenara.interviewPuzzles.linkedLists;

public class SingleLinkedNode<T> {
    SingleLinkedNode<T> next;
    T value;


    public static <T>void printList(SingleLinkedNode<T> head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
