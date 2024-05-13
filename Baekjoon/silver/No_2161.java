package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 카드1
public class No_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) deque.add(i);

        while(deque.size() != 1) {
            System.out.print(deque.pollFirst() + " ");
            deque.addLast(deque.pollFirst());
        }
        System.out.println(deque.poll());
    }
}
