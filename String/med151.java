package String;

public class med151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  the    sky   is blue  "));
    }

    public static String reverseWords(String s) {
        System.out.println(s);
        s = s.trim();
        while (s.contains("  ")) {
            s = s.replaceAll("  ", " ");
        }
        System.out.println(s);
        char[] arr = s.toCharArray();
        revernt(arr, 0, s.length() - 1);
        int poin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == ' ') {
                revernt(arr, poin, i - 1);
                poin = i + 1;
            }
        }
        revernt(arr, poin, s.length() - 1);
        return new String(arr);
    }

    private static void revernt(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
