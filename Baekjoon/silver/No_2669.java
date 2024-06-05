package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 직사각형 네개의 합집합의 면적 구하기
public class No_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[101][101];

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken()); // 1
            int x1 = Integer.parseInt(st.nextToken()); // 2

            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int n = x1; n < x2; n++) {
                for(int m = y1; m < y2; m++) {
                    map[n][m] = 1;
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                if(map[i][j] == 1) answer++;
            }
        }

        System.out.println(answer);
    }
}
