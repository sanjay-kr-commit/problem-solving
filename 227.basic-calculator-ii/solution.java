// @leet start

import java.util.Stack;

class Solution {
  public int calculate(String s) {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Character> ops = new Stack<>();
    char op = '+';
    boolean isNegative = false;
    boolean valueAdded = false;
    int temp = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ')
        continue;
      if (c == '+' || c == '-' || c == '/' || c == '*') {
        if ((c == '-' || c == '+') && !valueAdded) {
          isNegative = c == '-';
          continue;
        }
        if (op == '*' || op == '/') {
          if (st.isEmpty())
            continue;
          int pop = st.pop();
          if (op == '*')
            pop *= ((isNegative) ? -1 : 1) * temp;
          else
            pop /= ((isNegative) ? -1 : 1) * temp;
          st.push(pop);
        } else {
          ops.push(op);
          st.push(((isNegative) ? -1 : 1) * temp);
        }
        op = c;
        temp = 0;
        valueAdded = false;
        isNegative = false;
        continue;
      }
      valueAdded = true;
      temp *= 10;
      temp += c - '0';
    }
    if (valueAdded) {
      if (op == '*' || op == '/') {
        int pop = st.pop();
        if (op == '*')
          pop *= ((isNegative) ? -1 : 1) * temp;
        else
          pop /= ((isNegative) ? -1 : 1) * temp;
        st.push(pop);
      } else {
        ops.push(op);
        st.push(((isNegative) ? -1 : 1) * temp);
      }
    }
    int sum = 0;
    while (!st.isEmpty()) {
      op = ops.pop();
      temp = st.pop();
      switch (op) {
        case '+':
          sum += temp;
          break;
        case '-':
          sum -= temp;
          break;
        case '*':
          sum *= temp;
          break;
        default:
          sum /= temp;
          break;
      }
    }

    return sum;

  }
}
// @leet end
