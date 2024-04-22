package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 타일 장식물
public class No_13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long [] dp = new long [N + 1];

        dp[1] = 1L;
        if(N >= 2) dp[2] = 1L;

        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(2 * (dp[N] + dp[N - 1]) + 2 * dp[N]);
    }
}
