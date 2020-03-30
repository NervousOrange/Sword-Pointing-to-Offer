import java.util.ArrayList;
import java.util.LinkedList;


public class PrintLinkListReversely {

    public static void main(String[] args) {
        PrintLinkListReversely printLinkListReversely = new PrintLinkListReversely();
        ListNode node0 = new ListNode(0);
        ListNode node1 = node0.next = new ListNode(1);
        ListNode node2 = node1.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(3);
        ListNode node4 = node3.next = new ListNode(4);
        ListNode node5 = node4.next = new ListNode(5);
        ListNode node6 = node5.next = new ListNode(6);
        System.out.println(printLinkListReversely.printListFromTailToHead(node0));
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
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


