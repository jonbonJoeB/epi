import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * This class represents a stack with a constant time
 * max() operation. We achieve this by keeping 2 stacks,
 * one with the elements, and another with "snapshots" of
 * what the max currently is
 */
public class StackWithMax {

    private class MaxWithCount {
        final int value;
        int count;

        MaxWithCount(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    /*
    8.1
    */

    final Deque<MaxWithCount> cachedMax = new ArrayDeque<>();
    final Deque<Integer> stack = new ArrayDeque<>();

    public StackWithMax() { }

    public Integer max() {
        errorCheck();
        return cachedMax.peek().value;
    }

    public Integer pop() {
        errorCheck();
        final int x = stack.pop();
        if (x == cachedMax.peek().value) {
            if (cachedMax.peek().count == 0) {
                cachedMax.pop();
            } else {
                cachedMax.peek().count -= 1;
            }
        }
        return x;
    }

    public void push(Integer x) {
        stack.push(x);
        if (cachedMax.isEmpty() || x > cachedMax.peek().value) {
            cachedMax.push(new MaxWithCount(x, 1));
        } else if (x == cachedMax.peek().value) {
            cachedMax.peek().count += 1;
        }
    }

    private void errorCheck() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("The stack is empty");
        }
    }
}
