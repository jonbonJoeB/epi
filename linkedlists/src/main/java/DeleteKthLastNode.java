public class DeleteKthLastNode {

    /*
    7.7
    */

    public static void deleteNode(ListNode<Integer> list, int k) {
        if (list == null)
            return;

        int len = list.length();
        if (k == len) {
            list = list.next;
            return;
        }

        ListNode<Integer> dummy = new ListNode<>(0, list);

        int i = 1;
        while (i++ <= len - k) {
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
    }

    private static int lengthOf(ListNode<Integer> list) {
        int len = 0;
        ListNode<Integer> node = list;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
