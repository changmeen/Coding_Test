package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 -  실버 - 아기 상어 2
public class No_17086 {
    static int N, M, answer = 0;
    static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[] {x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();

            if(map[p[0]][p[1]] == 1) {
                if(answer < p[2]) answer = p[2];
                break;
            }

            for(int i = 0; i < 8; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    q.add(new int[] {nx, ny, p[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
