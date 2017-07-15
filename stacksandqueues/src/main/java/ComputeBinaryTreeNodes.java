import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ComputeBinaryTreeNodes {

    /*
    8.7
    */

    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTree<Integer> tree) {
        final List<List<Integer>> levels = new ArrayList<>();
        if (tree == null) {
            return levels;
        }

        final Deque<BinaryTree<Integer>> nodes = new LinkedList<>();
        nodes.offer(tree);

        while (!nodes.isEmpty()) {
            int size = nodes.size();

            final List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                final BinaryTree<Integer> cur = nodes.poll();
                level.add(cur.data);

                if (cur.left != null) {
                    nodes.add(cur.left);
                }
                if (cur.right != null) {
                    nodes.add(cur.right);
                }
            }
            levels.add(level);
        }

        return levels;
    }
}
