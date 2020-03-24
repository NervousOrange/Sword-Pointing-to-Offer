/* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5 */

public class DuplicateInLinkedList {
    public static void main(String[] args) {
        ListNode2 node0 = new ListNode2(1);
        ListNode2 node1 = node0.next = new ListNode2(2);
        ListNode2 node2 = node1.next = new ListNode2(3);
        ListNode2 node3 = node2.next = new ListNode2(3);
        ListNode2 node4 = node3.next = new ListNode2(4);
        ListNode2 node5 = node4.next = new ListNode2(4);
        ListNode2 node6 = node5.next = new ListNode2(5);

        DuplicateInLinkedList duplicateInLinkedList = new DuplicateInLinkedList();
        ListNode2 resultNode = duplicateInLinkedList.deleteDuplication(node0);
        while (resultNode.next != null) {
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }
        System.out.print(resultNode.val);

        System.out.println();
        System.out.println("second test: ------------------");
        test();
    }

    private static void test() {
        ListNode2 node0 = new ListNode2(1);
        ListNode2 node1 = node0.next = new ListNode2(1);
        ListNode2 node2 = node1.next = new ListNode2(1);
        ListNode2 node3 = node2.next = new ListNode2(1);
        ListNode2 node4 = node3.next = new ListNode2(1);
        ListNode2 node5 = node4.next = new ListNode2(1);
        // ListNode2 node6 = node5.next = new ListNode2(2);

        DuplicateInLinkedList duplicateInLinkedList = new DuplicateInLinkedList();
        ListNode2 resultNode = duplicateInLinkedList.deleteDuplication(node0);
        if (resultNode != null) {
            while (resultNode.next != null) {
                System.out.print(resultNode.val + " ");
                resultNode = resultNode.next;
            }
            System.out.print(resultNode.val);
        }
    }

    public ListNode2 deleteDuplication(ListNode2 pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode2 head = new ListNode2(0);
        head.next = pHead;
        ListNode2 pre = head;
        ListNode2 last = head.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }
}

class ListNode2 {
    int val;
    ListNode2 next = null;

    ListNode2(int val) {
        this.val = val;
    }
}
