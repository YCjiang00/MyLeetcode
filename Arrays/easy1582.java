package Arrays;

public class easy1582 {

    // 1582. 二进制矩阵中的特殊位置
    public int numSpecial(int[][] mat) {
        int out = 0;
        int[] sum_i = new int[mat.length];
        int[] sum_j = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++){
                sum_i[i] += mat[i][j];
                sum_j[j] += mat[i][j];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 1 & sum_i[i] == 1 && sum_j[j] == 1) {
                    out++;
                }
                sum_i[i] += mat[i][j];
                sum_j[j] += mat[i][j];
            }
        }
        return out;
    }
}
