package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 날짜 계산
public class No_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        int e = 0, s = 0, m = 0;
        while(true) {
            answer++;
            e++;
            s++;
            m++;

            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;

            if(e == E && s == S && m == M) break;
        }

        System.out.println(answer);
    }
}
