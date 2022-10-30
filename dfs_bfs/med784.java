package dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class med784 {
    /***
     * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
     * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
     */
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("3z4"));
    }

    public static List<String> result = new Vector<>();
    public static String ss;
    public static String tt = "";

    public static List<String> letterCasePermutation(String s) {
        ss = s;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                tt += (char)(s.charAt(i) + 32);
            } else if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                tt += (char)(s.charAt(i) - 32);
            } else {
                tt += s.charAt(i);
            }
        }
        bacing(0, "");
        return result;
    }

    public static void bacing(int index, String tmpString) {
        if (tmpString.length() == ss.length()) {
            result.add(tmpString);
            return;
        }
        String tmp = tmpString;
        if (!Character.isDigit(ss.charAt(index))) {  // 字母，变/不变
            bacing(index + 1, tmpString + tt.charAt(index));
        }
        bacing(index + 1, tmpString + ss.charAt(index));
    }

}
