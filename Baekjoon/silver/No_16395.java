package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 파스칼의 삼각형
public class No_16395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = 1;
        if(n >= 2) {
            dp[2][1] = 1;
            dp[2][2] = 1;
        }

        for(int i = 3; i <= n; i++) {
            dp[i][1] = 1;
            dp[i][i] = 1;

            for(int j = 2; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}
