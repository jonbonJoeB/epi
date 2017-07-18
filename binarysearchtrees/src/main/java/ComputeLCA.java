public class ComputeLCA {

    /*
    14.4
    */

    public static BinaryTree<Integer> findLCA(BinaryTree<Integer> tree,
                                              BinaryTree<Integer> s,
                                              BinaryTree<Integer> b) {
        if (s.data == b.data) {
            return s;
        }

        if (tree.data == s.data || tree.data == b.data) {
            return tree;
        }

        BinaryTree<Integer> lca = null;
        BinaryTree<Integer> subtree = tree;
        while (subtree != null) {
            if ((subtree.data >= s.data && subtree.data <= b.data)
                || (subtree.data <= s.data && subtree.data >= b.data)){
                lca = subtree;
                break;
            }

            if (subtree.data <= s.data) {
                subtree = subtree.right;
            } else {
                subtree = subtree.left;
            }
        }

        return lca;
    }
}
