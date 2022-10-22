package Arrays;

public class med209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    // 给定一个nums数组和 一个target ，找出最小长度的 连续子数组，且子数组和 大于等于 target

    // 暴力解法 外层遍历每个节点，内层计算和，大于target时终止，计算长度，取最小长度
    // 暴力法超时
    public static int minSubArrayLen(int target, int[] nums) {
        int mid = nums.length;
        boolean flg = false;
        for (int i = 0; i < nums.length; i++) {
            int sum_tmp = 0;
            for (int j = i; j < nums.length; j++) {
                sum_tmp += nums[j];
                if (sum_tmp >= target) {
                    flg = true;
                    mid = Math.min(mid, j - i + 1);
                    break;
                }
            }
        }
        if (flg) {
            return mid;
        } else {
            return 0;
        }
    }

    // 滑动窗口
    public static int minSubArrayLen2(int target, int[] nums) {
        int end = 0;
        int len = nums.length + 1;
        int sum = 0;
        for (int star = 0; star < nums.length; star++) {
            sum += nums[star];
            while (sum >= target) {
                len = Math.min(len, star - end + 1);
                sum -= nums[end];
                end++;
            }
        }
        if (len == nums.length + 1) {
            return 0;
        } else {
            return len;
        }
    }

}
