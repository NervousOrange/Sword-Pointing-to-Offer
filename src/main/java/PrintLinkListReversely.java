import java.util.ArrayList;
import java.util.LinkedList;


public class PrintLinkListReversely {

    public static void main(String[] args) {
        PrintLinkListReversely printLinkListReversely = new PrintLinkListReversely();
        ListNode3 node0 = new ListNode3(0);
        ListNode3 node1 = node0.next = new ListNode3(1);
        ListNode3 node2 = node1.next = new ListNode3(2);
        ListNode3 node3 = node2.next = new ListNode3(3);
        ListNode3 node4 = node3.next = new ListNode3(4);
        ListNode3 node5 = node4.next = new ListNode3(5);
        ListNode3 node6 = node5.next = new ListNode3(6);
        System.out.println(printLinkListReversely.printListFromTailToHead(node0));
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode3 listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> stack = new LinkedList<>();
        while (listNode.next != null) {
            stack.addLast(listNode.val);
            listNode = listNode.next;
        }
        stack.addLast(listNode.val);
        ArrayList<Integer> result = new ArrayList<>();
        while (stack.size() > 0) {
            result.add(stack.removeLast());
        }
        return result;
    }
}


class ListNode3 {
    int val;
    ListNode3 next = null;
    ListNode3(int val) {
        this.val = val;
    }
}