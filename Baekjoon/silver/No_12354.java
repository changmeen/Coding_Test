package Baekjoon.silver;
import java.io.*;
import java.util.*;

public class No_12354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            int max = 0;
            int answer = 0;

            for(int i = 0; i < n; i++) {
                int now = Integer.parseInt(st.nextToken());

                if(max < now) {
                    max = now;
                } else answer++;
            }

            System.out.println("Case #" + t + ": " + answer);
        }
    }    
}
