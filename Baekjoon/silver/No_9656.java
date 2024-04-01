package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 돌 게임2
public class No_9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n % 2 == 0) System.out.println("SK");
        else System.out.println("CY");
    }
}
