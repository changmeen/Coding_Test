package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 단어 나누기
public class No_1251 {
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        dfs(str, 1, 2);

        System.out.println(answer);
    }

    static void dfs(String str, int one, int two) {
        if(one == str.length()) return;

        String first = str.substring(0, one);
        String second = str.substring(one, two);
        String third = str.substring(two);

        first = new StringBuffer(first).reverse().toString();
        second = new StringBuffer(second).reverse().toString();
        third = new StringBuffer(third).reverse().toString();

        String now = first.concat(second).concat(third);
        if(one == 1 && two == 2) answer = now;
        if(answer.compareTo(now) >= 1) answer = now;

        two++;
        if(two == str.length()) {
            one++;
            two = one + 1;
            if(two >= str.length()) return;
        }

        dfs(str, one, two);
    }
}
