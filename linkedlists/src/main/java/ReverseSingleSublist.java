public class ReverseSingleSublist {

    /*
    7.2
    */

    public static ListNode<Integer> reverseSublist(ListNode<Integer> input, int s, int f) {
        if (input == null || input.next == null) {
            return input;
        }

        ListNode<Integer> dummy = new ListNode<>(0, input);
        ListNode<Integer> sublistHead = dummy;

        int i = 1;
        while (i++ < s) {
            sublistHead = sublistHead.next;
        }

        ListNode<Integer> cur = sublistHead.next;
        while (s++ < f) {
            ListNode<Integer> next = cur.next;
            cur.next = next.next;
            next.next = sublistHead.next;
            sublistHead.next = next;
        }

        return dummy.next;
    }
}
