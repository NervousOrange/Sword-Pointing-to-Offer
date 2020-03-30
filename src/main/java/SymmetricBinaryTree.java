// 请实现一个函数，用来判断一颗二叉树是不是对称的。
// 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

import java.util.LinkedList;

public class SymmetricBinaryTree {
    public static void main(String[] args) {
        SymmetricBinaryTree symmetricBinaryTree = new SymmetricBinaryTree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println("True: " + symmetricBinaryTree.isSymmetrical2(root));
        root.right.left = new TreeNode(1);
        System.out.println("False: " + symmetricBinaryTree.isSymmetrical2(root));
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        if (pRoot.left == null && pRoot.right == null) {
            return true;
        }
        if (pRoot.left == null || pRoot.right == null) {
            return false;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(pRoot.left);
        stack.addLast(pRoot.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.removeLast();
            TreeNode right = stack.removeLast();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            stack.addLast(left.left);
            stack.addLast(right.right);
            stack.addLast(left.right);
            stack.addLast(right.left);
        }
        return true;
    }

    // 递归法
    boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetricalHelper(pRoot.left, pRoot.right);
    }

    private boolean isSymmetricalHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricalHelper(left.left, right.right) && isSymmetricalHelper(left.right, right.left);
    }
}



