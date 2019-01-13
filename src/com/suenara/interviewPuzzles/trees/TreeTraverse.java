package com.suenara.interviewPuzzles.trees;

import java.util.LinkedList;

public class TreeTraverse {

    public static void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.println(root.val);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    public static void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.left);
        System.out.println(root.val);
        traverseInOrder(root.right);
    }

    public static void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.println(root.val);
    }

    public static void traverseByLevel(Node root) {

        LinkedList<Node> levelNodes = new LinkedList<>();
        levelNodes.add(root);

        while (!levelNodes.isEmpty()) {
            Node node = levelNodes.pop();
            System.out.println(node.val);
            if (node.left != null) levelNodes.add(node.left);
            if (node.right != null) levelNodes.add(node.right);
        }
    }

    public static void main(String[] args) {
        Node root = prepareTree();

        //prints "1 2 3 4 5 6 7 8 9"
        System.out.println("Pre-order traverse");
        traversePreOrder(root);

        //prints "3 2 5 4 6 1 7 8 9"
        System.out.println("In-order traverse");
        traverseInOrder(root);

        //prints "3 5 6 4 2 9 8 7 1"
        System.out.println("Post-order traverse");
        traversePostOrder(root);

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
