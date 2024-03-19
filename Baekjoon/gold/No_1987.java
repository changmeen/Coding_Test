package Baekjoon.gold;
import java.util.*;
import java.io.*;

public class No_1987 {
    static int R, C;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R + 1][C + 1];

        for(int i = 1; i <= R; i++) {
            String str = br.readLine();

            for(int j = 1; j <= str.length(); j++) {
                board[i][j] = str.charAt(j - 1);
            }
        }
        boolean[][] visited = new boolean[R + 1][C + 1];
        dfs(visited, "" + board[1][1], 1, 1);

        System.out.println(answer);
    }

    static void dfs(boolean[][] visited, String route, int x, int y) {
        answer = Math.max(answer, route.length());

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= R && ny >= 1 && ny <= C) {
                if(!visited[nx][ny] && !route.contains(String.valueOf(board[nx][ny]))) {
                    visited[nx][ny] = true;
                    dfs(visited, route + board[nx][ny], nx, ny);
                    visited[nx][ny] = false;
                }
            }
        }

        return;
    }
}
