package Arrays;

public class easy27 {
    public static void main(String[] args) {
        int out = removeElement2(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(out);
    }
    // 一个数组nums，目标值 val，删除数组中所有的val，返回数组的长度

    // 暴力解法
    public static int removeElement(int[] nums, int val) {
        int out = nums.length;
        for (int i = 0; i < out; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < out; j++) {
                    nums[j - 1] = nums[j];
                }
                out--;
                i--;
            }
        }
        return out;
    }

    // 双指针 ，快慢指针
    public static int removeElement2(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
