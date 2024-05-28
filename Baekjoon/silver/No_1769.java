package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 3의 배수
public class No_1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        
        int cnt = 0;
        while(true) {
            long sum = 0;
            if(x.length() == 1) break;

            for(int i = 0; i < x.length(); i++) {
                sum += Integer.parseInt(String.valueOf(x.charAt(i)));
            }
            cnt++;
            x = String.valueOf(sum);
        }

        System.out.println(cnt);
        if(Integer.parseInt(x) % 3 == 0) System.out.println("YES");
        else System.out.println("NO");
    }
}
