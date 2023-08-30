package Baekjoon.silver;
import java.io.*;

public class No_1003 {

    static Integer[][] dp = new Integer[41][2];

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int test_case = Integer.parseInt(br.readLine());

        for(int t = 0; t < test_case; t++){
            int n = Integer.parseInt(br.readLine());
            fibo(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    static Integer[] fibo(int n){
        if(dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            dp[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }

        return dp[n];
    }
}
