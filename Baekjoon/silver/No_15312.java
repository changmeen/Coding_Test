package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 이름 궁합
public class No_15312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = br.readLine().split("");
        String[] B = br.readLine().split("");

        int[][] dp = new int[A.length * 2 + 1][A.length * 2 + 1];

        int length = 2 * A.length;
        int a_idx = 1;
        int b_idx = 2;
        for(int i = 0; i < A.length; i++) {
            dp[1][a_idx] = alphabet_write(A[i]);
            a_idx += 2;
        }
        for(int i = 0; i < B.length; i++) {
            dp[1][b_idx] = alphabet_write(String.valueOf(B[i]));
            b_idx += 2;
        }
        length--;

        for(int i = 2; i <= 2 * A.length - 1; i++) {
            for(int j = 1; j <= length; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j + 1]) % 10;
            }
            length--;
        }

        System.out.println(dp[A.length * 2 - 1][1] + "" + dp[A.length * 2 - 1][2]);
    }

    static int alphabet_write(String c) {
        int answer = 0;
        switch(c) {
            case "A":
            answer = 3;
            break;

            case "B":
            answer = 2;
            break;

            case "C":
            answer = 1;
            break;

            case "D":
            answer = 2;
            break;

            case "E":
            answer = 3;
            break;

            case "F":
            answer = 3;
            break;

            case "G":
            answer = 2;
            break;

            case "H":
            answer = 3;
            break;

            case "I":
            answer = 3;
            break;

            case "J":
            answer = 2;
            break;
            
            case "K":
            answer = 2;
            break;

            case "L":
            answer = 1;
            break;

            case "M":
            answer = 2;
            break;

            case "N":
            answer = 2;
            break;

            case "O":
            answer = 1;
            break;
            
            case "P":
            answer = 2;
            break;

            case "Q":
            answer = 2;
            break;

            case "R":
            answer = 2;
            break;

            case "S":
            answer = 1;
            break;

            case "T":
            answer = 2;
            break;

            case "U":
            answer = 1;
            break;

            case "V":
            answer = 1;
            break;

            case "W":
            answer = 1;
            break;
            
            case "X":
            answer = 2;
            break;

            case "Y":
            answer = 2;
            break;

            case "Z":
            answer = 1;
            break;
        }

        return answer;
    }
}
