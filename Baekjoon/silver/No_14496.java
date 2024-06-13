package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 그대, 그머가 되어
public class No_14496 {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
    static int a, b, M, N, answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            map.get(num1).add(num2);
            map.get(num2).add(num1);
        }

        bfs(a);

        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    static void bfs(int start) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {start, 0});
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] p = q.poll();
            if(p[0] == b) {
                answer = Math.min(answer, p[1]);
                continue;
            }

            for(int i = 0; i < map.get(p[0]).size(); i++) {
                if(!visited[map.get(p[0]).get(i)]) {
                    q.add(new int[] {map.get(p[0]).get(i), p[1] + 1});
                    visited[map.get(p[0]).get(i)] = true;
                }
            }
        }
    }
}
