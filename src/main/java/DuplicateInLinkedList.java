/* 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5 */

public class DuplicateInLinkedList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = node0.next = new ListNode(2);
        ListNode node2 = node1.next = new ListNode(3);
        ListNode node3 = node2.next = new ListNode(3);
        ListNode node4 = node3.next = new ListNode(4);
        ListNode node5 = node4.next = new ListNode(4);
        ListNode node6 = node5.next = new ListNode(5);

        testDuplicateInLinkedList(node0);

        System.out.println();
        System.out.println("second test: ------------------");
        test();
    }

    private static void testDuplicateInLinkedList(ListNode node0) {
        DuplicateInLinkedList duplicateInLinkedList = new DuplicateInLinkedList();
        ListNode resultNode = duplicateInLinkedList.deleteDuplication(node0);
        if (resultNode != null) {
            while (resultNode.next != null) {
                System.out.print(resultNode.val + " ");
                resultNode = resultNode.next;
            }
            System.out.print(resultNode.val);
        }
    }

    private static void test() {
        ListNode node0 = new ListNode(1);
        ListNode node1 = node0.next = new ListNode(1);
        ListNode node2 = node1.next = new ListNode(1);
        ListNode node3 = node2.next = new ListNode(1);
        ListNode node4 = node3.next = new ListNode(1);
        ListNode node5 = node4.next = new ListNode(1);
        // ListNode2 node6 = node5.next = new ListNode2(2);

        testDuplicateInLinkedList(node0);
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = head.next;
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

