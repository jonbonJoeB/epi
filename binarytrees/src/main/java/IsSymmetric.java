public class IsSymmetric {

    /*
    9.2
    */

    public static boolean isSymmetric(BinaryTree<Integer> tree) {
        if (tree == null) return true;
        return isSymmetric(tree.left, tree.right);
    }

    public static boolean isSymmetric(BinaryTree<Integer> left, BinaryTree<Integer> right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.data != right.data) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
