package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 최대 상승
public class No_25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max_earn = 0;

        min = price[1];

        for(int i = 2; i <= N; i++) {
            max_earn = Math.max(max_earn, price[i] - min);
            if(min > price[i]) min = price[i];
        }

        System.out.println(max_earn);
    }
}
