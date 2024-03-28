package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 쉬운 계단 수
public class No_10844 {
    static final long MOD = 1_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for(int i = 0; i <= 9; i++) {
            dp[1][i] = 1L;
        }

        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];

            for(int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }

            dp[i][9] = dp[i - 1][8];
        }

        long answer = 0L;
        for(int i = 1; i <= 9; i++) {
            answer += dp[n][i];
            answer %= MOD;
        }

        System.out.println(answer);
    }
}
