package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - UCPC는 무엇의 약자일까?
public class No_15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.replaceAll("[^UCPC]", "");

        if(!str.contains("U")) {
            System.out.println("I hate UCPC");
            return;
        }
        str = str.substring(str.indexOf("U") + 1);
        
        if(!str.contains("C")) {
            System.out.println("I hate UCPC");
            return;
        }
        str = str.substring(str.indexOf("C") + 1);

        if(!str.contains("P")) {
            System.out.println("I hate UCPC");
            return;
        }
        str = str.substring(str.indexOf("P") + 1);

        if(!str.contains("C")) {
            System.out.println("I hate UCPC");
            return;
        }

        System.out.println("I love UCPC");
    }
}
