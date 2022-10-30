package dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class med934 {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<int[]> island = new ArrayList<int[]>();
        Queue<int[]> queue = new ArrayDeque<int[]>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {   // 开始找到陆地
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;  // 记录后，将1标记为-1
                    while (!queue.isEmpty()) {   // 有这个起始开始，搜索第一块陆地 队列为空时，每个陆地都已经queue进入，出去过
                        int[] cell = queue.poll();   // 接收起始位置坐标
                        int x = cell[0], y = cell[1];  // 开始搜索上下左右
                        island.add(cell);  // 初始值加入list
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dirs[k][0];
                            int ny = y + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) { // 记录后 grid[nx][ny] == 1 标记为-1
                                queue.offer(new int[]{nx, ny});  // 加入队列
                                grid[nx][ny] = -1;  // 记录后标记为 -1
                            }
                        }
                    }
                    // 到此为止，第一块陆地都已经遍历完成 queue此时为空， island 中记录了所有陆地元素
                    for (int[] cell : island) {
                        queue.offer(cell);
                    } //将元素全部 入队列，通过逐个出队列，出来都关联项进入队列套路进行后续操作

                    int step = 0; // 初始距离为 0
                    while (!queue.isEmpty()) {  // 通过逐个出队列，出来都关联项进入队列套路进行后续操作，队列为空时结束循环
                        int sz = queue.size(); // 本次循环，出队列数量为 sz，保证sz个出来，sz个周边相关都都进入，层序遍历一层都思想
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {  // 符合条件都，即从来没有标记过都，就纳入，入队列，同时标记 -1
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step; // 已经接触到第二个陆地，可以直接返回当前都圈数
                                    }
                                }
                            }
                        }
                        step++;  // for遍历完成一次，就一层/一圈 结束，该圈中元素都出队列，关联项都入队列
                    }
                }
            }
        }
        return 0;
    }
}
