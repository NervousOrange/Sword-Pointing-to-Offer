public class Question08_nextNode_binaryTree {
    /*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/

/*    给定一个二叉树和其中的一个结点，
    请找出中序遍历顺序的下一个结点并且返回。
    注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。*/

    /* 分几种情况：
    1.如果节点存在右子节点，那么下一个节点就是右子树的最左节点。
    2.节点没有右子树，且节点为父节点的左子树，则返回父节点
    3.节点没有右子树，且节点为父节点的右子树，再判断 父节点是不是 爷爷节点的左节点，（若不是，继续向上遍历）返回爷爷节点
    4.接上条，向上遍历过程中，如爷爷节点不存在，则表明达到了根节点，返回 null.
     */

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {   // 如果有右子树，返回右子树的最左边的节点。
            TreeLinkNode pointer = pNode.right;
            while (pointer.left != null) {
                pointer = pointer.left;
            }
            return pointer;
        }
        while (pNode.next != null) {    // （没有右子树）存在 有父节点的情况
            if (pNode == pNode.next.left) {   //自己是父节点的左节点，就返回父节点。
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;  // （没有右子树） 没有父节点
    }
}
