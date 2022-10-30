package stack;

import javax.print.DocFlavor;
import java.util.Stack;

public class med150 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("-999"));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    /**
     * 逆波兰表达式求值
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> tmp_num = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tmp_num);
            if (tokens[i].equals("+")) {
                int a = tmp_num.pop();
                int b = tmp_num.pop();
                tmp_num.push(b + a);
            } else if (tokens[i].equals("-")) {
                int a = tmp_num.pop();
                int b = tmp_num.pop();
                tmp_num.push(b - a);
            } else if (tokens[i].equals("*")) {
                int a = tmp_num.pop();
                int b = tmp_num.pop();
                tmp_num.push(b * a);
            } else if (tokens[i].equals("/")) {
                int a = tmp_num.pop();
                int b = tmp_num.pop();
                tmp_num.push(b / a);
            } else {
                tmp_num.push(Integer.parseInt(tokens[i]));
            }
        }
        return tmp_num.pop();
    }
}
