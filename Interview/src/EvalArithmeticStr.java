import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by youlongli on 3/3/15.
 *
 * Evaluate an arithmetic string.
 */
public class EvalArithmeticStr {
  /**
   * Has unary operators and parenthesis.
   */
  public int solution(String str) {
    Deque<Character> operators = new ArrayDeque<>(); // Stack
    Deque<Integer> operands = new ArrayDeque<>(); // Stack

    int i = 0;
    int n = str.length();

    while (i < n) {
      if (i != 0 && isOperator(str.charAt(i)) && !isOperator(str.charAt(i - 1))
          && str.charAt(i - 1) != '(') {
        // Operator
        char operator = str.charAt(i);
        if (!operators.isEmpty() && hasPrecedence(operators.peek(), operator)) {
          operands.push(eval(operators.pop(), operands.pop(), operands.pop()));
        }
        operators.push(str.charAt(i));
        i++;
      } else if (str.charAt(i) == '(') {
        operators.push(str.charAt(i));
        i++;
      } else if (str.charAt(i) == ')') {
        while (operators.peek() != '(') {
          operands.push(eval(operators.pop(), operands.pop(), operands.pop()));
        }
        operators.pop();
        i++;
      } else {
        // Operand
        int num = 0;
        int sign = 1;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
          sign = str.charAt(i) == '+' ? 1 : -1;
          i++;
        }
        while (i < n && Character.isDigit(str.charAt(i))) {
          int digit = str.charAt(i) - '0';
          num = num * 10 + digit;
          i++;
        }
        // Deal with unary operator '-'
        if (!operators.isEmpty() && operators.peek() == '-') {
          num = -num;
          operators.pop();
          operators.push('+');
        }
        operands.push(num * sign);
      }
    }

    while (!operators.isEmpty()) {
      operands.push(eval(operators.pop(), operands.pop(), operands.pop()));
    }

    return operands.pop();
  }

  private boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
  }

  // Return true if op1 has higher precedence
  private boolean hasPrecedence(char op1, char op2) {
    return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
  }

  private int eval(char operator, int o2, int o1) {
    switch (operator) {
      case '+': return o1 + o2;
      case '-': return o1 - o2;
      case '*': return o1 * o2;
      default: return o1 / o2;
    }
  }
}
