package Baekjoon.silver;
import java.io.*;

public class No_17520 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 1;
        int power = (n % 2 == 0) ? n / 2 : n / 2 + 1;

        for(int i = 0; i < power; i++) {
            answer = (answer * 2) % 16769023;
        }

        System.out.println(answer);
    }
}
