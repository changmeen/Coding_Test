package Baekjoon.silver;
import java.util.*;
import java.io.*;

// 백준 - 실버 - 구간 합 구하기 5
public class No_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i][j - 1] + board[i][j];
            }
        }

        for(int m = 0; m < M; m++) {
            int x1, y1, x2, y2;
            st = new StringTokenizer(br.readLine(), " ");
            
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int answer = 0;
            for(int i = x1; i <= x2; i++) {
                answer += dp[i][y2] - dp[i][y1 - 1];
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
