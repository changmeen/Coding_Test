package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 도시와 비트코인
public class No_31575 {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M + 1][N + 1];
        for(int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int n = 1; n <= N; n++) {
                map[m][n] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static String bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1, 1});
        boolean[][] visited = new boolean[M + 1][N + 1];
        visited[1][1] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();

            if(p[0] == M && p[1] == N) return "Yes";

            for(int i = 0; i < 2; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if(nx <= M && ny <= N && map[nx][ny] == 1 & !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return "No";
    }
}
