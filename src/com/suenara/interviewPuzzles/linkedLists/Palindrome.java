package com.suenara.interviewPuzzles.linkedLists;

import java.util.Stack;

import static com.suenara.interviewPuzzles.linkedLists.SingleLinkedNode.writeNumberAsList;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(writeNumberAsList("123321")));
        System.out.println(isPalindrome(writeNumberAsList("12321")));
        System.out.println(isPalindrome(writeNumberAsList("123221")));
    }

    public static <T> boolean isPalindrome(SingleLinkedNode<T> list) {
        if (list == null) return false;
        if (list.next == null) return true;

        SingleLinkedNode<T> head = list;

        Stack<SingleLinkedNode<T>> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        head = list;
        while (head != null) {
            if (stack.empty()) break;

            if (!head.value.equals(stack.pop().value)) return false;

            head = head.next;
        }

        return true;
    }


}
