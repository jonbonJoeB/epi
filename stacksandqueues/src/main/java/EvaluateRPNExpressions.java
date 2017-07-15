import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateRPNExpressions {

    /*
    8.2
    */

    /**
     * Evalutes an expression represented in Reveres Polish Notation (RPN)
     *
     * Example:
     *
     *  3 4 +
     *
     *
     * @param RPNExpression
     * @return
     */
    public static Integer eval(String RPNExpression) {
        if (RPNExpression == null) {
            return 0;
        }

        // operators and operands
        final Deque<Integer> ops = new ArrayDeque<>();
        for (final Character c : RPNExpression.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (ops.size() < 2) {
                    throw new IllegalArgumentException("Invalid input");
                }

                final int op2 = ops.pop();
                final int op1 = ops.pop();

                ops.push(eval(c, op1, op2));
            } else {
                ops.push(Character.getNumericValue(c));
            }
        }

        return ops.peek();
    }

    private static Integer eval(Character operator, int operand1, int operand2) {
        switch (operator) {
            case 'x':
                return operand1 * operand2;
            case '-':
                return operand1 - operand2;
            case '+':
                return operand1 + operand2;
            case '/':
                return operand2 / operand1;
            default:
                throw new UnsupportedOperationException("Operator " + operator + " is not supported");
        }
    }
}
