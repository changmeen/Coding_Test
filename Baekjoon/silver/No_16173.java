package Baekjoon.silver;
import java.io.*;
import java.util.*;

public class No_16173 {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static String bfs() {
        boolean[][] visited = new boolean[N + 1][N + 1];
        visited[1][1] = true;
        Queue<Block> q = new LinkedList<>();
        q.offer(new Block(1, 1, map[1][1]));

        while(!q.isEmpty()) {
            Block p = q.poll();

            if(p.x == N && p.y == N && p.move == -1) {
                return "HaruHaru";
            }

            for(int i = 0; i < 2; i++) {
                int nx = p.x + dx[i] * p.move;
                int ny = p.y + dy[i] * p.move;

                if(nx <= N && ny <= N && !visited[nx][ny] && map[nx][ny] != 0) {
                    q.offer(new Block(nx, ny, map[nx][ny]));
                }
            }
        }

        return "Hing";
    }
}

class Block {
    int x, y, move;

    Block(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}