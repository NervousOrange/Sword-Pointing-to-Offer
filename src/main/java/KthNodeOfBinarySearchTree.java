/*给定一棵二叉搜索树，请找出其中的第k小的结点。
例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4*/

public class KthNodeOfBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = root.left = new TreeNode(3);
        TreeNode node2 = root.right = new TreeNode(7);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(4);
        node2.left = new TreeNode(6);
        node2.right = new TreeNode(8);

        KthNodeOfBinarySearchTree kthNodeOfBinarySearchTree = new KthNodeOfBinarySearchTree();
        kthNodeOfBinarySearchTree.KthNode(root, 3);
    }

    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            System.out.println(pRoot.val);
            TreeNode temp = KthNode(pRoot.left, k);
            if (temp != null) {
                return temp;
            }
            index++;
            if (index == k) {
                return pRoot;
            }
            System.out.println(pRoot.val);
            TreeNode temp2 = KthNode(pRoot.right, k);
            if (temp2 != null) {
                return temp2;
            }
        }
        return null;
    }
}
