package Baekjoon.gold;

import java.io.*;
import java.util.*;

// 호석이 두 마리 치킨
public class No_21278 {

    static int N, M;
    static int build1 = -1, build2 = -1, min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        combination(new int[] {-1, -1}, 0, 0);

        System.out.println((build1 + 1) + " " + (build2 + 1) + " " + (min * 2));
    }

    public static void combination(int[] buildings, int cnt, int idx){
        if(idx == graph.size() - 1 && cnt < 2) return;
        if(cnt == 2){
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(i == buildings[0] || i == buildings[1]) continue;
                int time1 = bfs(i, buildings[0]);
                int time2 = bfs(i, buildings[1]);

                sum += Math.min(time1, time2);
            }

            if(min > sum){
                min = sum;
                build1 = buildings[0];
                build2 = buildings[1];
            }else if(min == sum){
                if(build1 != buildings[0]){
                    if(build1 > buildings[0]){
                        build1 = buildings[0];
                        build2 = buildings[1];
                    }
                }else{
                    if(build2 > buildings[1]){
                        build1 = buildings[0];
                        build2 = buildings[1];
                    }
                }
            }
        }

        if(cnt == 0){
            buildings[0] = idx;
            combination(buildings, cnt + 1, idx + 1);
            combination(buildings, cnt, idx + 1);
        }else if(cnt == 1){
            buildings[1] = idx;
            combination(buildings, cnt + 1, idx + 1);
            combination(buildings, cnt, idx + 1);
        }
    }

    public static int bfs(int start, int target){
        boolean[] visited = new boolean[N];
        visited[start] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));

        while(!q.isEmpty()){
            Node n = q.poll();

            if(n.idx == target){
                return n.cnt;
            }

            for(int i = 0; i < graph.get(n.idx).size(); i++){
                if(!visited[graph.get(n.idx).get(i)]){
                    visited[graph.get(n.idx).get(i)] = true;
                    q.offer(new Node(graph.get(n.idx).get(i), n.cnt + 1));
                }
            }
        }

        return 0;
    }
}

class Node{
    int idx;
    int cnt;

    Node(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}