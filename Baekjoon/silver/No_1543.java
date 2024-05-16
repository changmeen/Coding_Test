package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 문서 검색
public class No_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int answer = 0;
        while(document.contains(word)) {
            answer++;
            document = document.replaceFirst(word, " ");
        }

        System.out.println(answer);
    }
}
