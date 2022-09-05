import java.util.*;
import java.io.*;
 
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String[] split = firstLine.split(" ");
        int n = Integer.valueOf(split[0]);
        int m = Integer.valueOf(split[1]);
        int k = Integer.valueOf(split[2]);
        int[][] matrix = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            split = line.split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.valueOf(split[j]);
            }
        }
        boolean exist = find(matrix, k);
        System.out.println(exist ? "Yes" : "No");
    }
    
    public static boolean find(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int r = 0;
        int c = m - 1;
        while (r < n && c >= 0) {
            if (matrix[r][c] == k) {
                return true;
            } else if (matrix[r][c] < k) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}