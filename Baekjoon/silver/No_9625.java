package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - BABBA
public class No_9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[K + 1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;
        if(K >= 2) {
            dp[2][0] = 1;
            dp[2][1] = 1;
        }

        for(int i = 3; i <= K; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }

        System.out.println(dp[K][0] + " " + dp[K][1]);
    }
}
