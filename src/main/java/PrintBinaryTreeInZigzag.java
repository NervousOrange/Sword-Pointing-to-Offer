import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。*/

public class PrintBinaryTreeInZigzag {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        ArrayList<Integer> resultInCurrentRow = new ArrayList<>();
        LinkedList<TreeNode> nodesInCurrentRow = new LinkedList<>();
        nodesInCurrentRow.addLast(null);       // 加入分隔符
        nodesInCurrentRow.addLast(pRoot);
        boolean fromLeftToRight = true;
        while (nodesInCurrentRow.size() != 1) {
            TreeNode isSeparator = nodesInCurrentRow.removeFirst();
            if (isSeparator == null) {
                Iterator<TreeNode> iterator = null;
                if (fromLeftToRight) {
                    iterator = nodesInCurrentRow.iterator();
                } else {
                    iterator = nodesInCurrentRow.descendingIterator();
                }
                while (iterator.hasNext()) {
                    resultInCurrentRow.add(iterator.next().val);
                }
                result.add(new ArrayList<>(resultInCurrentRow));
                fromLeftToRight = !fromLeftToRight;
                resultInCurrentRow.clear();
                nodesInCurrentRow.addLast(null);  // 添加层分隔符
                continue;
            }

            if (isSeparator.left != null) {
                nodesInCurrentRow.add(isSeparator.left);
            }
            if (isSeparator.right != null) {
                nodesInCurrentRow.add(isSeparator.right);
            }
        }
        return result;
    }
}
