package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 백준 - 골드4 - 직사각형 탈출
public class No_16973 {
    static int N, M, H, W, SX, SY, FX, FY;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    // 벽의 위치를 저장하기 위한 HashSet
    static HashSet<Point> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 격자판 저장
        board = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                // 현재 위치가 벽인 경우 벽의 좌표 저장
                if(board[i][j] == 1) {
                    hs.add(new Point(i, j, 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        SX = Integer.parseInt(st.nextToken());
        SY = Integer.parseInt(st.nextToken());
        FX = Integer.parseInt(st.nextToken());
        FY = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(SX, SY, 0));

        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[SX][SY] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();
            // 현재 직사각형의 왼쪽 위 좌표가 목적지일 경우 현재 까지의 최단 거리 return
            if(p.x == FX && p.y == FY) {
                return p.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 왼쪽 위 좌표 뿐만이 아니라 직사각형 전체가 유효한지 확인
                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if(nx + H - 1<= N && ny + W - 1<= M) {
                        // 왼쪽 위가 방문한 좌표가 아니고
                        // 전체 직사각형의 범위 안에 벽이 없는지 확인
                        if(!visited[nx][ny] && check(nx, ny)) {
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny, p.cnt + 1));
                        }
                    }
                }
            }
        }

        // 목적지에 도달하지 못했을 경우 -1 반환
        return -1;
    }

    // 저장해둔 벽의 위치들이 현재 직사각형의 범위 안에 포함되는 것이 있는지 체크
    static boolean check(int x, int y) {
        for(Point p : hs) {
            if(p.x >= x && p.x <= x + H - 1 && p.y >= y && p.y <= y + W - 1) {
                // 단 하나의 벽이라도 직사각형의 범위 안에 있을 시 false 반환
                return false;
            }
        }

        // 모든 벽이 직사각형의 범위 안에  없을 경우에만 true 반환
        return true;
    }
}

class Point {
    int x, y, cnt;

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
