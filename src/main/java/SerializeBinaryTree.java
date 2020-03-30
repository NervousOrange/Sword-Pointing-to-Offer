
/*请实现两个函数，分别用来序列化和反序列化二叉树

二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。*/


public class SerializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
        System.out.println(serializeBinaryTree.Serialize(root));
        serializeBinaryTree.Deserialize(serializeBinaryTree.Serialize(root));
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        serializeHelper(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("#,");
            return;
        }
        stringBuilder.append(root.val);
        stringBuilder.append(",");
        serializeHelper(root.left, stringBuilder);
        serializeHelper(root.right, stringBuilder);
    }

    int index = -1;
    TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] strings = str.split(",");
        return deserializeHelper(strings);
    }

    private TreeNode deserializeHelper(String[] strings) {
        index++;
        TreeNode root = new TreeNode(0);
        if (!strings[index].equals("#")) {
            root.val = Integer.parseInt(strings[index]);
            root.left = deserializeHelper(strings);
            root.right = deserializeHelper(strings);
            return root;
        }
        return null;
    }
}
