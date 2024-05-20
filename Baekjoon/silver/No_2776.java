package Baekjoon.silver;
import java.io.*;
import java.util.*;

// 백준 - 실버 - 암기왕
public class No_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++) {
                sb.append(binarySearch(arr, Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int binarySearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;

            if(arr[mid] == num) return 1;
            else if(arr[mid] < num) start = mid + 1;
            else end = mid - 1;
        }

        return 0;
    }
}
