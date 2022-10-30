package stack;

import javax.print.DocFlavor;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class med347 {
    public static void main(String[] args) {

    }
    /**
    * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     **/
    public int[] topKFrequent(int[] nums, int k) {
        // 当时两个参数，key和value时，只能用hash，但是需要有序，且方便遍历，如何使用有限队列？

        // 初始化计数
        HashMap<Integer, Integer> tmpMap = new HashMap<>();
        for (int i : nums) {
            tmpMap.put(i, tmpMap.getOrDefault(i, 0) + 1);
        }
        // 使用优先队列快速排序
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (Integer key : tmpMap.keySet()) {
            queue.add(new int[]{key, tmpMap.get(key)});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
