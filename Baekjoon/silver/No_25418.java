package Baekjoon.silver;
import java.io.*;
import java.util.*;

public class No_25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, K));
    }

    static int bfs(int A, int K) {
        boolean[] visited = new boolean[K + 1];
        visited[A] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {A, 0});

        while(!q.isEmpty()) {
            int[] p = q.poll();

            if(p[0] == K) return p[1];

            if(p[0] * 2 <= K && !visited[p[0] * 2]) {
                q.offer(new int[] {p[0] * 2, p[1] + 1});
                visited[p[0] * 2] = true;
            }
            if(p[0] + 1 <= K && !visited[p[0] + 1]) {
                q.offer(new int[] {p[0] + 1, p[1] + 1});
                visited[p[0] + 1] = true;
            }
        }

        return -1;
    }
}
