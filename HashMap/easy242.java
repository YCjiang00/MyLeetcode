package HashMap;

public class easy242 {
    public boolean isAnagram(String s, String t) {
        int[] str = new int[26];
        for (int i = 0; i < s.length(); i++) {
            str[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            str[t.charAt(i)-'a']--;
        }
        for (int i : str) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
