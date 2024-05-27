package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 알고리즘 수업 - 너비 우선 탐색 2
public class No_24445 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int N, M, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0; i <= N; i++) graph.add(new ArrayList<Integer>());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i < N; i++) Collections.sort(graph.get(i), Collections.reverseOrder());

        bfs();
    }

    static void bfs() {
        boolean[] visited = new boolean[N];
        visited[R] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(R);
        int sequence = 1;
        int[] order = new int[N];

        while(!q.isEmpty()) {
            int p = q.poll();
            order[p] = sequence++;

            for(int i = 0; i < graph.get(p).size(); i++) {
                if(!visited[graph.get(p).get(i)]) {
                    visited[graph.get(p).get(i)] = true;
                    q.offer(graph.get(p).get(i));
                }
            }
        }

        for(int i = 0; i < N; i++) {
            System.out.println(order[i]);
        }
    }
}
