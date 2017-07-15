import java.util.HashSet;
import java.util.Set;

public class ComputeLCAWithParent {

    /*
    9.4
    */

    public static BinaryTreeParent<Integer> LCA(BinaryTreeParent<Integer> node0, BinaryTreeParent<Integer> node1) {
        if (node0 == node1) {
            return node0;
        }

        final Set<Integer> set = new HashSet<>();
        while (node0 != null) {
            set.add(node0.data);
            node0 = node0.parent;
        }

        while (node1 != null && !set.contains(node1.data)) {
            node1 = node1.parent;
        }

        return node1;
    }

}
