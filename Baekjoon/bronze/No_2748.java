package Baekjoon.bronze;
import java.io.*;

// 백준 - 브론즈 - 피보나치 수 2
public class No_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[91];
        dp[0] = 0L;
        dp[1] = 1L;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
