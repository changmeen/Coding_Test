package Baekjoon.silver;
import java.io.*;
import java.math.BigInteger;

// 백준 - 실버 - 피보나치 수 4
public class No_10826 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[n + 1];

        dp[0] = BigInteger.ZERO;
        if(n >= 1) dp[1] = BigInteger.ONE;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        System.out.println(dp[n]);
    }
}
