package HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class easy349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums2) {
            if (map1.getOrDefault(i, 0) != 0) {
                set.add(i);
            }
        }
        int len = set.size();
        int[] out = new int[len];
        for (int i : set) {
            out[len-1] = i;
            len--;
        }
        return out;
    }
}
