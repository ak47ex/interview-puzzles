package com.suenara.interviewPuzzles.linkedLists;

public class DoubleLinkedNode<T> {
    DoubleLinkedNode<T> next;
    DoubleLinkedNode<T> prev;
    T value;

    public static <T>void printList(DoubleLinkedNode<T> head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
