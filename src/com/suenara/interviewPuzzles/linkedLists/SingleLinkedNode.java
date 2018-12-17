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

    public static SingleLinkedNode<Integer> writeNumberAsList(String number) {
        SingleLinkedNode<Integer> result = new SingleLinkedNode<>();

        SingleLinkedNode<Integer> iter = result;
        for (int i = 0; i < number.length(); ++i) {
            iter.value = Character.getNumericValue(number.charAt(i));
            if (i != number.length() - 1) {
                iter.next = new SingleLinkedNode<>();
                iter = iter.next;
            }
        }
        return result;
    }

    public static <T> SingleLinkedNode reverse(SingleLinkedNode<T> list) {
        SingleLinkedNode<T> head = null;
        while (list != null) {
            SingleLinkedNode<T> node = list.next;
            list.next = head;
            head = list;
            list = node;
        }
        return head;
    }
}
