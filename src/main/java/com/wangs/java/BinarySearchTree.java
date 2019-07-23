package com.wangs.java;

/**
 * @Author: Sheng Wang
 * @Description:
 * @Date: Created in 2019/7/23
 * @Modified By:
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = buildTree();
        TreeOrder.floorOrder(root);
        System.out.print("\n------------------------------\n");
        System.out.println(search(root, 25).getValue());
        System.out.println(search(root, 55).getValue());
        System.out.println(search(root, 19).getValue());
        System.out.print("\n------------------------------\n");
        insert(root, 60);
        insert(root, 48);
        TreeOrder.floorOrder(root);
        System.out.print("\n------------------------------\n");
        delete(root, 18);
        delete(root, 13);
        delete(root, 55);
        delete(root, 33);
        TreeOrder.floorOrder(root);
    }

    public static TreeNode search(TreeNode root, int data) {
        TreeNode node = root;
        while (node != null) {
            if (data < node.getValue()) {
                node = node.getLeft();
            } else if (data > node.getValue()) {
                node = node.getRight();
            } else {
                return node;
            }
        }
        return new TreeNode(-1);
    }

    public static void insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
        }

        TreeNode node = root;
        while (node != null) {
            if (data > node.getValue()) {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode(data));
                    return;
                }
                node = node.getRight();
            } else {
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode(data));
                    return;
                }
                node = node.getLeft();
            }
        }
    }

    public static void delete(TreeNode root, int data) {
        TreeNode node = root;
        TreeNode pnode = null;
        while (node != null && node.getValue() != data) {
            pnode = node;
            if (data > node.getValue()) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }

        //Not found node value equal data
        if (node == null) {
            return;
        }

        // left and right subtree are not empty
        if (node.getLeft() != null && node.getRight() != null) {
            // find min node in right subtree
            TreeNode minNode = node.getRight();
            TreeNode minPNode = node;
            while (minNode.getLeft() != null) {
                minPNode = minNode;
                minNode = minNode.getLeft();
            }

            node.setValue(minNode.getValue());
            node = minNode;
            pnode = minPNode;
        }

        // node has just one non-empty subtree, or leaf node itself
        TreeNode cnode;
        if (node.getLeft() != null) {
            cnode = node.getLeft();
        } else if (node.getRight() != null) {
            cnode = node.getRight();
        } else {
            cnode = null;
        }

        if (pnode == null) {
            root = cnode;
        } else if (pnode.getLeft() == node) {
            pnode.setLeft(cnode);
        } else {
            pnode.setRight(cnode);
        }
    }

    public static TreeNode buildTree() {
        TreeNode node19 = new TreeNode(19);
        TreeNode node27 = new TreeNode(27);
        TreeNode node55 = new TreeNode(55);

        TreeNode node15 = new TreeNode(15);
        TreeNode node17 = new TreeNode(17);
        TreeNode node25 = new TreeNode(25, node19, node27);
        TreeNode node51 = new TreeNode(51, null, node55);
        TreeNode node66 = new TreeNode(66);

        TreeNode node13 = new TreeNode(13, null, node15);
        TreeNode node18 = new TreeNode(18, node17, node25);
        TreeNode node34 = new TreeNode(34);
        TreeNode node58 = new TreeNode(58, node51, node66);

        TreeNode node16 = new TreeNode(16, node13, node18);
        TreeNode node50 = new TreeNode(50, node34, node58);

        TreeNode node33 = new TreeNode(33, node16, node50);

        return node33;
    }
}
