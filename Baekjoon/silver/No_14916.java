package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 거스름돈
public class No_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        if(n >= 6) {
            dp[1] = -1;
            dp[2] = 1;
            dp[3] = -1;
            dp[4] = 2;
            dp[5] = 1;
        }
        else {
            if(n == 1) System.out.println(-1);
            else if(n == 2) System.out.println(1);
            else if(n == 3) System.out.println(-1);
            else if(n == 4) System.out.println(2);
            else if(n == 5) System.out.println(1);
            return;
        }

        for(int i = 6; i <= n; i++) {
            if(dp[i - 2] == -1 && dp[i - 5] == -1) dp[i] = -1;
            else if(dp[i - 2] == -1) dp[i] = dp[i - 5] + 1;
            else if(dp[i - 5] == -1) dp[i] = dp[i - 2] + 1;
            else dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
        }

        System.out.println(dp[n]);
    }
}
