package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 뒤집기
public class No_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        int zero_cnt = 0;
        int one_cnt = 0;
        int before = Integer.parseInt(str[0]);
        if(before == 0) zero_cnt++;
        else one_cnt++;

        for(int i = 1; i < str.length; i++) {
            int now = Integer.parseInt(str[i]);

            if(now == before) continue;
            else {
                if(now == 0) zero_cnt++;
                else if(now == 1) one_cnt++;

                before = now;
            }
        }

        System.out.println(Math.min(zero_cnt, one_cnt));
    }
}
