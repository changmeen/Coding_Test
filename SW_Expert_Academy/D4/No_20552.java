package SW_Expert_Academy.D4;
import java.io.*;
import java.util.*;

public class No_20552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        long X, S;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            X = Long.parseLong(st.nextToken());
            S = Long.parseLong(st.nextToken());

            if(X > S) {
                sb.append("-1").append("\n");
                continue;
            }
            else if(X == S) {
                if(X == 0) sb.append(0).append("\n");
                else sb.append(1).append("\n").append(X).append("\n");
                continue;
            }

            long[] result = dfs(X, S, 62, 0L, 0L, 0L);
            if(result == null) {
                sb.append(-1).append("\n");
                continue;
            }

            int len = 3;
            while(result[len - 1] == 0) len--;

            sb.append(len).append("\n");

            for(int i = 0; i < len; i++) {
                if(i > 0) sb.append(" ");
                sb.append(result[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static long[] dfs(long X, long S, int shift, long r0, long r1, long r2) {
        if(r0 + r1 + r2 > (S >> (shift + 1))) return null;
        if(r0 + r1 + r2 + 4 < (S >> (shift + 1))) return null;

        if(shift < 0) {
            if(r0 + r1 + r2 == S) {
                long[] ret = {r0, r1, r2};
                return ret;
            } else return null;
        }

        int xi = (X & (1L << shift)) != 0 ? 1 : 0;

        long[] ret = null;

        if(xi == 0) {
            ret = dfs(X, S, shift - 1, r0 * 2, r1 * 2, r2 * 2);
            if(ret != null) return ret;

            ret = dfs(X, S, shift - 1, r0 * 2 + 1, r1 * 2 + 1, r2 * 2);
            if(ret != null) return ret;
        } else {
            ret = dfs(X, S, shift - 1, r0 * 2 + 1, r1 * 2, r2 * 2);
            if(ret != null) return ret;

            ret = dfs(X, S, shift - 1, r0 * 2 + 1, r1 * 2 + 1, r2 * 2 + 1);
            if(ret != null) return ret;
        }

        return null;
    }
}
