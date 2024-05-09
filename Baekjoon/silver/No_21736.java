package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 헌내기는 친구가 필요해
public class No_21736 {
    static int N, M, sx, sy;
    static String[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N + 1][M + 1];

        for(int n = 1; n <= N; n++) {
            String str[] = br.readLine().split("");
            for(int m = 1; m <= M; m++) {
                map[n][m] = str[m - 1];
                if(map[n][m].equals("I")) {
                    sx = n;
                    sy = m;
                }
            }
        }

        int num = bfs(sx, sy);

        if(num == 0) System.out.println("TT");
        else System.out.println(num);
    }

    static int bfs(int x, int y) {
        int num = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();

            if(map[p[0]][p[1]].equals("P")) num++;

            for(int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if(nx >= 1 && ny >= 1 && nx <= N && ny <= M) {
                    if(!map[nx][ny].equals("X") && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        return num;
    }
}
