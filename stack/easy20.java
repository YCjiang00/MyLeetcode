package stack;

import java.util.Stack;

public class easy20 {
    public static void main(String[] args) {
//        System.out.println(isValid("[]"));
        System.out.println(isValid("][[["));
    }
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
     */
    public static boolean isValid(String s) {
        /**
         * 核心是，三种不满足的情况
         */
        int len = s.length();
        int i = 0;
        Stack<Character> tmp = new Stack<>();
        while (len > i) {
            System.out.println("tmp:"+ tmp);
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                tmp.push(s.charAt(i));
                i++;
            } else {
                if (tmp.isEmpty()) {
                    return false;  // 匹配之初就是右括号，不满足
                }
                char char_tmp = tmp.pop();
                if (char_tmp == '(' && s.charAt(i) == ')' || char_tmp == '[' && s.charAt(i) == ']' || char_tmp == '{' && s.charAt(i) == '}') {
                    i++;
                } else {
                    return false;  // 遍历过程中，有不对于左右括号项
                }
            }
        }
        if (tmp.size() == 0) {
            return true;
        } else {
            return false; // 遍历结束之后，有剩余左括号没有匹配到
        }
    }
}
