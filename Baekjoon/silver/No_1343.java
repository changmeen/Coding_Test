package Baekjoon.silver;
import java.io.*;

public class No_1343 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String str = br.readLine();

        int length = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'X') length++;
            else if(c == '.' && length == 0) sb.append(".");
            else if(c == '.' && length != 0) {
                if(length % 2 != 0) {
                    sb = new StringBuffer();
                    sb.append(-1);
                    System.out.println(sb);
                    return;
                } else {
                    int n = length / 4;
                    for(int j = 1; j <= n; j++) sb.append("AAAA");
                    if(length % 4 != 0) sb.append("BB");
                    sb.append(".");
                    length = 0;
                }
            }
        }
        if(length != 0) {
            if(length % 2 != 0) {
                sb = new StringBuffer();
                    sb.append(-1);
                    System.out.println(sb);
                    return;
            }
            int n = length / 4;
            for(int i = 1; i <= n; i++) sb.append("AAAA");
            if (length % 4 != 0 && length > 1) sb.append("BB");
            if (sb.length() == 0) sb.append("-1");
        }

        System.out.println(sb);
    }
}
