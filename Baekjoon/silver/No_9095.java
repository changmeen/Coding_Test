package Baekjoon.silver;
import java.io.*;

// 백준 - 실버3 - 1, 2, 3 더하기
public class No_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 12; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for(int i = 0; i < T; i++) {
            int test_case = Integer.parseInt(br.readLine());
            System.out.println(dp[test_case]);
        }
    }
}
