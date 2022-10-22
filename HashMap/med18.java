package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class med18 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));

    }

    // 四数之和
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int k = i + 1; k < nums.length; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int left = k + 1;
                int right = nums.length - 1;
                while (left < right) {
//                    System.out.println("i:" + i + "  left:" + left + "  right:" + right);
//                    System.out.println(nums[i] + nums[k]);
//                    System.out.println(nums[i] + nums[k] +nums[left] + nums[right]);
//                    System.out.println(target - (nums[left] + nums[right]));
                    if ((long) nums[i] + nums[k] +nums[left] + nums[right] == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[k]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        out.add(tmp);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if ((long) nums[i] + nums[k] +nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return out;
    }
}
