package com.wangs.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Sheng Wang
 * @Description:
 * @Date: Created in 2019/7/19
 * @Modified By:
 */
public class TreeOrder {
    public static void main(String[] args) {
        TreeNode root = buildTree();
        preOrder(root);
        System.out.print("\n------------------------------\n");
        inOrder(root);
        System.out.print("\n------------------------------\n");
        postOrder(root);
        System.out.print("\n------------------------------\n");
        floorOrder(root);
    }

    public static TreeNode buildTree() {
        TreeNode node15 = new TreeNode(15);
        TreeNode node14 = new TreeNode(14);
        TreeNode node13 = new TreeNode(13);
        TreeNode node12 = new TreeNode(12);
        TreeNode node11 = new TreeNode(11);
        TreeNode node10 = new TreeNode(10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);

        TreeNode node4 = new TreeNode(4, node8, node9);
        TreeNode node5 = new TreeNode(5, node10, node11);
        TreeNode node6 = new TreeNode(6, node12, node13);
        TreeNode node7 = new TreeNode(7, node14, node15);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode node1 = new TreeNode(1, node2, node3);

        return node1;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    public static void floorOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        queue.offer(root);
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            array.add(node.getValue());
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
