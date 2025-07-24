// @leet start
class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0"))
      return "0";
    String[] nums = new String[num2.length()];
    for (int i = 0; i < num2.length(); i++) {
      nums[i] = multiply(num1, num2, i);
    }
    return add(nums);
  }

  String multiply(String multiplicand, String num2, int index) {
    StringBuilder st = new StringBuilder();
    for (int i = 0, len = num2.length() - index - 1; i < len; i++)
      st.append(0);
    int carry = 0;
    int multiplier = num2.charAt(index) - '0';
    for (int i = multiplicand.length() - 1; i > -1; i--) {
      int product = ((multiplicand.charAt(i) - '0') * multiplier) + carry;
      carry = product / 10;
      st.append(product % 10);
    }
    while (carry > 0) {
      st.append(carry % 10);
      carry /= 10;
    }
    return st.toString();
  }

  String add(String[] nums) {
    int max = 0;
    for (String num : nums)
      max = Math.max(max, num.length());
    StringBuilder st = new StringBuilder();
    int carry = 0;
    for (int i = 0; i < max; i++) {
      int sum = carry;
      for (String num : nums) {
        if (num.length() <= i)
          continue;
        sum += num.charAt(i) - '0';
      }
      carry = sum / 10;
      st.append(sum % 10);
    }
    while (carry > 0) {
      st.append(carry % 10);
      carry /= 10;
    }
    return st.reverse().toString();
  }

}

// @leet end
