package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class med130 {

    // BFS 遍历
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;

        Queue<int[]> queue = new LinkedList<>(); // 核心队列

        // 将边界中 O的值如 核心列表
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
                board[i][m - 1] = 'A';
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n - 1, i});
                board[n - 1][i] = 'A';
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        // 核心列表中的元素进行广度遍历，把有关联的都入队，赋值 A
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int mx = tmp[0];
            int my = tmp[1];
            // 每拿到一个元素，队列中出来的每个元素，都对他的上下左右进行遍历
            for (int i = 0; i < 4; i++) {
                int x = mx + dx[i];   //非常容易出错，每次都是新的坐标值，需要新定义
                int y = my + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m || board[x][y] != 'O') {
                    continue;
                }
                board[x][y] = 'A';
                queue.offer(new int[]{x, y});
            }
        }

        // 将所有有问题的 O还原，A-> O ， 将所有正常的O 改成X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }


    // DFS 遍历
    public void solve_dfs(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }

        // 将所有有问题的 O还原，A-> O ， 将所有正常的O 改成X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }
}
