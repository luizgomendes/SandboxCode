package com.lgm.sandbox.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTree {

    private Node root;

    public void addNode(Integer value) {
        System.out.println("Adding " + value);
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, Integer value) {
        if(current == null) {
            return new Node(value);
        }

        if(value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value){
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            bt.addNode(random.nextInt(10));
        }

        bt.traverseLevelOrder();
    }
}
