package Baekjoon.gold;
import java.util.*;
import java.io.*;

// 백준 골드 3 :rightplant:
// https://solved.ac/arena/30/editorial의 D번 문제 풀이를 참고
public class No_31631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> H = new ArrayList<>();
        H.add(1);
        H.add(2);
        
        for(int i = 2; i < N; i++) {
            for(int j = 0; j < i; j++) {
                H.set(j, H.get(j) + 1);
            }

            int idx = (i % 4);
            if(idx % 2 == 0) {
                idx = i / 2;
            } else if(idx == 1) {
                idx = (i - 1) / 2;
            } else {
                idx = ((i - 1) / 2) + 1;
            }
            H.add(idx, 1);
        }

        for(int h : H) {
            System.out.print(h + " ");
        }
    }
}
