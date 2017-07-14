public class TestCyclicity {

    /*
    7.3
    */

    public static ListNode<Integer> isCyclic(ListNode<Integer> list) {
        if (list == null || list.next == null) {
            return null;
        }

        ListNode<Integer> head = list, slow = list.next, fast = list.next.next;
        while (fast != null && fast.next != null) {
            if (slow.equals(fast)) {

                // Find the start of the cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // or fast
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return null;
    }
}
