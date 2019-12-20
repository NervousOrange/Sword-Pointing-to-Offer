/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */

import java.util.ArrayList;
import java.util.Stack;

public class Question06_LinkedList {

/*输入一个链表，按链表从尾到头的顺序返回一个ArrayList。*/

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> printArray = new ArrayList<>();
            if (listNode == null) {
                return printArray;
            }
            Stack<Integer> arrayData = new Stack<>();
            while (listNode != null) {
                arrayData.push(listNode.val);
                listNode = listNode.next;
            }
            while (!arrayData.isEmpty()) {
                printArray.add(arrayData.pop());
            }
            return printArray;
        }
}
