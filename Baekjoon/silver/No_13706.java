package Baekjoon.silver;
import java.io.*;
import java.math.*;

// 백준 - 실버 - 제곱근
public class No_13706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());

        BigInteger left = BigInteger.ONE;
        BigInteger right = N;
        BigInteger mid = (left.add(right)).divide(BigInteger.TWO);

        while(mid.compareTo(N) != 0) {
            mid = (left.add(right)).divide(BigInteger.TWO);
            if(mid.pow(2).compareTo(N) == 0) break;
            else if(mid.pow(2).compareTo(N) == 1) right = mid.subtract(BigInteger.ONE);
            else if(mid.pow(2).compareTo(N) == -1) left = mid.add(BigInteger.ONE);
        }

        System.out.println(mid);
    }
}
