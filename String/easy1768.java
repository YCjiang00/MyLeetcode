package String;

public class easy1768 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("12345", ""));
    }
    /*
        给你两个字符串 word1 和 word2 。
        请你从 word1 开始，通过交替添加字母来合并字符串。
        如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     */
    public static String mergeAlternately(String word1, String word2) {
        String result = "";
        int l1 = word1.length();
        int l2 = word2.length();
        int i = 0;
        int j = 0;
        while (l1 > i && l2 > j) {
            result += word1.charAt(i++);
            result += word2.charAt(j++);
        }
        if (l1 == i && l2 == j) {
            return result;
        }
        else if (l1 == i) {
            result += word2.substring(j, l2);
        } else {
            result += word1.substring(i, l1);
        }
        return result;
    }

    public static String mergeAlternately1(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int i = 0;
        int j = 0;
        StringBuffer nes = new StringBuffer();
        while (i < l1 || j < l2) {
            if (i < l1) {
                nes.append(word1.charAt(i++));
            }
            if (j < l2) {
                nes.append(word2.charAt(j++));
            }
        }
        return nes.toString();
    }
}
