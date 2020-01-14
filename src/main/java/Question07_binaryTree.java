/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Question07_binaryTree {
    /*输入某二叉树的前序遍历和中序遍历的结果，
    请重建出该二叉树。假设输入的前序遍历和
    中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}
    和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。*/
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0) {
            return null;
        }
        // 找到根的值，建立根
        int rootValue = pre[0];
        TreeNode tree = new TreeNode(rootValue);

        // 在中序遍历中找到根的位置
        int rootpositionIn = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootValue) {
                rootpositionIn = i;
            }
        }
        if (rootpositionIn == -1) {
            return null;
        }

        // 建立左子树
        int leftChildTreeNum = rootpositionIn;
        int[] leftPre = new int[leftChildTreeNum];
        System.arraycopy(pre, 1, leftPre, 0, leftChildTreeNum);
        int[] leftIn = new int[leftChildTreeNum];
        System.arraycopy(in, 0, leftIn, 0, leftChildTreeNum);
        tree.left = reConstructBinaryTree(leftPre, leftIn);

        // 建立右子树
        int rightChildTreeNum = in.length - 1 - rootpositionIn;
        int[] rightPre = new int[rightChildTreeNum];
        System.arraycopy(pre, rootpositionIn + 1, rightPre, 0, rightChildTreeNum);
        int[] rightIn = new int[rightChildTreeNum];
        System.arraycopy(in, rootpositionIn + 1, rightIn, 0, rightChildTreeNum);
        tree.right = reConstructBinaryTree(rightPre, rightIn);

        return tree;
    }

    // 方法二： 精简的写法

    public TreeNode reConstructBinaryTree3(int[] pre, int[] in) {
        return reConstructBinaryTree3(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree3(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode tree = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {     // i = rootPosition in
                tree.left = reConstructBinaryTree3(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                tree.right = reConstructBinaryTree3(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }
        return tree;
    }
}
