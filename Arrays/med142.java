package Arrays;

public class med142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode tmp1 = head;
                ListNode tmp2 = slow;

                while (tmp2 != tmp1) {
                    tmp1 = tmp1.next;
                    tmp2 = tmp2.next;
                }
                return tmp1;
            }
        }
        return null;
    }
}
