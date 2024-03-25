package Baekjoon.silver;
import java.io.*;
import java.util.*;

public class No_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int[] dp = new int[1001];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            dp[i] = 1;

            for(int j = 1; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
