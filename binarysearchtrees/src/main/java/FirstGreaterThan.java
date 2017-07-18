public class FirstGreaterThan {

    /*
    14.2
    */

    public static BinaryTree<Integer> find(BinaryTree<Integer> tree, Integer k) {
        if (tree == null) {
            return null;
        }

        BinaryTree<Integer> it = tree;
        BinaryTree<Integer> firstGreaterThan = null;

        while (it != null) {
            if (k < it.data) {
                firstGreaterThan = it;
                it = it.left;
            } else {
                it = it.right;
            }
        }

        return firstGreaterThan;
    }
}
