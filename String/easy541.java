package String;

public class easy541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            revernt(arr, i, Math.min(k + i, s.length()) - 1);
        }
        return new String(arr);
    }

    private void revernt(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

}
