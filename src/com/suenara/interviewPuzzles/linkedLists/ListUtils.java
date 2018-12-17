package com.suenara.interviewPuzzles.linkedLists;

public class ListUtils {

    public static SingleLinkedNode<Integer> createIntListFromZeroToN(int n) {
        SingleLinkedNode<Integer> head = new SingleLinkedNode<>();
        SingleLinkedNode<Integer> iter = head;
        for (int i = 0; i < n; ++i) {
            if (i < n-1) iter.next = new SingleLinkedNode<>();
            iter.value = i;
            iter = iter.next;
        }
        return head;
    }

    public static SingleLinkedNode<Integer> createRandomList(int size) {
        SingleLinkedNode<Integer> head = new SingleLinkedNode<>();
        SingleLinkedNode<Integer> iter = head;
        for (int i = 0; i < size; ++i) {
            if (i < size -1) iter.next = new SingleLinkedNode<>();
            iter.value = (int)(Math.random() * size);
            iter = iter.next;
        }
        return head;
    }

}
