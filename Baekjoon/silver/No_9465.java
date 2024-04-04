package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 스티커
public class No_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        // 주어진 테스트 케이스 만큼 반복
        for(int t = 0; t < T; t++) {
            // 가로길이 n (1 ~ 100,000의 범위이기에 배열을 100,001로 설정)
            int n = Integer.parseInt(br.readLine());

            // 제공되는 점수 데이터를 담기 위한 board 2차원 배열
            int[][] board = new int[3][100_001];
            // dp를 저장하기 위한 2차원 배열
            int[][] dp = new int[3][100_001];
            for(int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j <= n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp[1][1]과 dp[2][1]은 각각 자기 자리의 board 값을 넣어준다
            dp[1][1] = board[1][1];
            dp[2][1] = board[2][1];

            // n이 2이상인 경우
            // 이전에 사용된 스티커의 상하좌우는 사용 불가능하기에 대각선의 스티커만 사용이 가능
            // 따라서 dp[1][2]의 값은 아래 왼쪽 대각선의 dp값과 현재 위치의 board값
            // dp[2][2]의 값은 위 왼쪽 대각선의 dp값과 현재 위치의 board값
            if(n >= 2) {
                dp[1][2] = dp[2][1] + board[1][2];
                dp[2][2] = dp[1][1] + board[2][2];
            }

            // n이 3부터는 경우의 수가 2가지가 존재
            // 1. n이 2일때 구한 것처럼 이전 줄의 대각선의 dp값 + 현재 위치의 board값
            // 2. 전전 줄(n - 2)의 대각선의 dp값 + 현재 위치의 board값
            // 2번의 경우 바로 이전 줄의 스티커는 사용하지 않는 경우가 더욱 효율적인 경우를 비교하는 케이스다.
            for(int i = 3; i <= n; i++) {
                dp[1][i] = Math.max(dp[2][i - 1] + board[1][i], dp[2][i - 2] + board[1][i]);
                dp[2][i] = Math.max(dp[1][i - 1] + board[2][i], dp[1][i - 2] + board[2][i]);
            }

            // n번째 줄에서 최대의 dp값을 얻어내면 그것이 가장 높은 점수의 스티커들을 고르는 방법이다.
            System.out.println(Math.max(dp[1][n], dp[2][n]));
        }
    }
}
