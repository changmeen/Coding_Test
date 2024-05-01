package Baekjoon.silver;
import java.io.*;
import java.util.StringTokenizer;

// 백준 - 실버 - 투자의 귀재 배주형
public class No_19947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dp = new int[Y + 1];
        dp[0] = H;

        for(int i = 1; i <= Y; i++) {
            dp[i] = (int) (dp[i - 1] * 1.05);

            if(i >= 3) {
                dp[i] = Math.max(dp[i], (int) (dp[i - 3] * 1.2));
            }
            
            if(i >= 5) {
                dp[i] = Math.max(dp[i], (int) (dp[i - 5] * 1.35));
            }
        }

        System.out.println(dp[Y]);
    }
}
