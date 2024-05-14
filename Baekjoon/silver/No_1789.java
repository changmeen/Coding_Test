package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 수들의 합
public class No_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long S = Long.parseLong(br.readLine());

        int answer = 0;
        Long sum = 0L;
        while(sum <= S) {
            answer++;
            sum += answer;
        }

        System.out.println(answer - 1);
    }
}
