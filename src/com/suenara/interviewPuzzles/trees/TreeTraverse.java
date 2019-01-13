package com.suenara.interviewPuzzles.trees;

import java.util.LinkedList;
import java.util.Stack;

public class TreeTraverse {

    public static void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public static void iterativePreOrder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.left);
        System.out.print(root.val + " ");
        traverseInOrder(root.right);
    }

    public static void iterativeInOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    public static void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void iterativePostOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node lastVisited = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                Node top = stack.peek();
                if (top.right != null && lastVisited != top.right) {
                    root = top.right;
                } else {
                    System.out.print(top.val + " ");
                    lastVisited = stack.pop();
                }
            }
        }
    }

    public static void traverseByLevel(Node root) {

        LinkedList<Node> levelNodes = new LinkedList<>();
        levelNodes.add(root);

        while (!levelNodes.isEmpty()) {
            Node node = levelNodes.pop();
            System.out.print(node.val + " ");
            if (node.left != null) levelNodes.add(node.left);
            if (node.right != null) levelNodes.add(node.right);
        }
    }

    public static void main(String[] args) {
        Node root = prepareTree();

        //prints "1 2 3 4 5 6 7 8 9"
        System.out.println("Recursive pre-order traverse");
        traversePreOrder(root);
        System.out.println();

        //prints "1 2 3 4 5 6 7 8 9"
        System.out.println("Iterative pre-order traverse");
        iterativePreOrder(root);
        System.out.println();

        //prints "3 2 5 4 6 1 7 8 9"
        System.out.println("Recursive in-order traverse");
        traverseInOrder(root);
        System.out.println();

        //prints "3 2 5 4 6 1 7 8 9"
        System.out.println("Iterative in-order traverse");
        iterativeInOrder(root);
        System.out.println();

        //prints "3 5 6 4 2 9 8 7 1"
        System.out.println("Recursive post-order traverse");
        traversePostOrder(root);
        System.out.println();

        //prints "3 5 6 4 2 9 8 7 1"
        System.out.println("Iterative post-order traverse");
        iterativePostOrder(root);
        System.out.println();

        //prints "1 2 7 3 4 8 5 6 9"
        System.out.println("Traverse by level");
        traverseByLevel(root);
    }

    /**
     * Creates tree:
     *                           (1)
     *                         /    \
     *                      (2)      (7)
     *                     / \      /
     *                  (3)  (4)   (8)
     *                      /   \     \
     *                    (5)   (6)    (9)
     * @return root of the tree
     */
    private static Node prepareTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);

        Node left = root.left;
        left.left = new Node(3);
        left.right = new Node(4);
        Node right = left.right;
        right.left = new Node(5);
        right.right = new Node(6);

        right = root.right;
        right.left = new Node(8);
        right.left.right = new Node(9);

        return root;
    }

    private static class Node {
        int val;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }
}
