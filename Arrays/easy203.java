package Arrays;

public class easy203 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 给你一个链表的头节点 head 和一个整数 val ，
    // 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmphead = new ListNode();
        tmphead.next = head;
        ListNode cur = tmphead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return tmphead.next;
    }
}
