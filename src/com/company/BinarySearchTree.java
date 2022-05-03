package com.company;

public class BinarySearchTree {

    public class Node {
        int value;
        Node parent, left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node rootNode;

    public BinarySearchTree() {
        rootNode = null;
    }

    public Node getRootNode() {
        return rootNode;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "rootNode=" + rootNode +
                '}';
    }

    private Node insertRecursively(Node root, int number) {

        if (root == null) {
            root = new Node(number);
        }
        if (number < root.value) {
            Node leftNode = insertRecursively(root.left, number);
            root.left = leftNode;
            leftNode.parent = root;
        } else if (number > root.value) {
            Node rightNode = insertRecursively(root.right, number);
            root.right = rightNode;
            rightNode.parent = root;
        }
        return root;
    }

    public void insert (int number) {
        rootNode = insertRecursively(rootNode, number);
    }
}
