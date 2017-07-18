import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class FindKLargest {

    /*
    14.3
    */

    public static List<Integer> findLargest(BinaryTree<Integer> tree, int k) {
        if (tree == null) {
            return Collections.emptyList();
        }

        final List<Integer> kLargest = new ArrayList<>();
        final Stack<BinaryTree<Integer>> stack = new Stack<>();

        BinaryTree<Integer> subtree = tree;
        while (subtree != null) {
            stack.push(subtree);
            subtree = subtree.right;
        }

        while (!stack.isEmpty()) {
            subtree = stack.pop();
            kLargest.add(subtree.data);

            if (k == kLargest.size()) {
                break;
            }

            if (subtree.left != null) {
                subtree = subtree.left;
                while (subtree != null) {
                    stack.push(subtree);
                    subtree = subtree.right;
                }
            }
        }

        if (k != kLargest.size()) {
            throw new IllegalArgumentException("Invalid input");
        }

        return kLargest;
    }
}
