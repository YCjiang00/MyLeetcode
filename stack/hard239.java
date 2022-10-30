package stack;

import java.util.*;

public class hard239 {
    public static void main(String[] args) {
        Queue<Integer> tt = new PriorityQueue<>();
        tt.add(3);
        tt.add(4);
        tt.add(2);
        tt.add(9);
//        System.out.println(tt);
        while (tt.peek() == 9) {
            tt.poll();
            System.out.println(tt);
        }
    }

    /**
     * 滑动窗口最大值
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> tmp = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] A, int[] B) {
                return A[0] != B[0] ? B[0] - A[0] : B[1] - A[1];
            }
        });
        // 队列有要求，要求队列有序，可以直接返回最大值，且队列保持有序

        int out_len = nums.length - k + 1;

        for (int i = 0; i < k; i++) {
            tmp.add(new int[]{nums[i], i});
        }

        int[] out = new int[out_len];
        out[0] = tmp.peek()[0];
        for (int i = k; i < nums.length; i++) {
            tmp.add(new int[]{nums[i], i});
            // 遍历，找到左坐标，去除
            while (tmp.peek()[1] <= i - k) {  // 如果遇到了，再进行删除，可以一次删除多个，也可以不删除
                tmp.poll();
            }
            out[i - k + 1] = tmp.peek()[0];
        }
        return out;
    }
}
