package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 카드 구매하기
public class No_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] card = new int[N + 1];
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
