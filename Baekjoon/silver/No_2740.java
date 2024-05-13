package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 행렬 곱셈
public class No_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] A = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M + 1][K + 1];
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[N + 1][K + 1];

        for(int n = 1; n <= N; n++) {
            for(int k = 1; k <= K; k++) {
                for(int m = 1; m <= M; m++) {
                    answer[n][k] += A[n][m] * B[m][k];
                }
                System.out.print(answer[n][k] + " ");
            }
            System.out.println();
        }
    }
}
