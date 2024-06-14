package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 점프 점프
public class No_14248 {
    static int[] stone;
    static boolean[] visited;
    static int n, s, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        stone = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        dfs(s);

        System.out.println(answer);
    }

    static void dfs(int now) {
        if(!visited[now]) {
            answer++;
            visited[now] = true;
        }

        if(now - stone[now] >= 1) dfs(now - stone[now]);
        if(now + stone[now] <= n) dfs(now + stone[now]);
    }
}
