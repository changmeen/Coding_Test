import java.util.*;
import java.io.*;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        Long result = 0L;
        while(pq.size() != 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int sum = num1 + num2;

            result += (num1 + num2);
            pq.offer(sum);
        }

        System.out.println(result);
    }
}
