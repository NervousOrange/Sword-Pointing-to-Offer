// 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintBinaryTreeMultipleLines {
    public static void main(String[] args) {
        PrintBinaryTreeMultipleLines printBinaryTreeMultipleLines = new PrintBinaryTreeMultipleLines();
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        printBinaryTreeMultipleLines.Print(treeNode);
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> nodesInCurrentRows = new LinkedList<>();
        if (pRoot == null) {
            return result;
        }
        nodesInCurrentRows.add(pRoot);
        int now = 1;
        int next = 0;
        while (!nodesInCurrentRows.isEmpty()) {
            TreeNode t = nodesInCurrentRows.remove();
            now--;
            temp.add(t.val);
            if (t.left != null) {
                nodesInCurrentRows.add(t.left);
                next++;
            }
            if (t.right != null) {
                nodesInCurrentRows.add(t.right);
                next++;
            }
            if (now == 0) {
                result.add(new ArrayList<>(temp));
                temp.clear();
                now = next;
                next = 0;
            }
        }
        return result;
    }
}


