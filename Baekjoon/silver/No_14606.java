package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 피자
public class No_14606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(0);
            return;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(N);

        int answer = 0;
        while(!arr.isEmpty()) {
            int n = arr.remove(arr.size() - 1);

            int a = n / 2;
            int b = n - a;

            answer += (a * b);
            if(a != 1) arr.add(a);
            if(b != 1) arr.add(b);
            Collections.sort(arr);
        }

        System.out.println(answer);
    }
}
