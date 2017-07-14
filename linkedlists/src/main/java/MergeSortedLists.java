public class MergeSortedLists {

    /*
    7.1
    */

    public static ListNode<Integer> mergeLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode<Integer> dummy = new ListNode<>(0);

        ListNode<Integer> left = list1;
        ListNode<Integer> right = list2;

        ListNode<Integer> list = dummy;

        while (left != null && right != null) {
            if (left.data < right.data) {
                list.next = left;
                left = left.next;
            } else {
                list.next = right;
                right = right.next;
            }
            list = list.next;
        }

        if (left != null) list.next = left;
        if (right != null) list.next = right;

        return dummy.next;
    }
}
