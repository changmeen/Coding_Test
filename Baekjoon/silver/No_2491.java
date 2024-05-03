package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 수열
public class No_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][2];
        int min = arr[1];
        int max = arr[1];
        int answer = 1;

        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int i = 2; i <= N; i++) {
            if(arr[i] <= min) {
                min = arr[i];
                dp[i][0] = dp[i - 1][0] + 1;
                if(answer < dp[i][0]) answer = dp[i][0];
            } else if(arr[i] > min) {
                min = arr[i];
                dp[i][0] = 1;
            }

            if(arr[i] >= max) {
                max = arr[i];
                dp[i][1] = dp[i - 1][1] + 1;
                if(answer < dp[i][1]) answer = dp[i][1];
            } else if(arr[i] < max) {
                max = arr[i];
                dp[i][1] = 1;
            }
        }

        System.out.println(answer);
    }
}
