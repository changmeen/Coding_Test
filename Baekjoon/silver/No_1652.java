package Baekjoon.silver;
import java.io.*;

// 백준 - 실버 - 누울 자리를 찾아라
public class No_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Character[][] map = new Character[101][101];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
            map[i][N] = map[N][i] = 'X';
        }

        int row = 0, col = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == '.' && map[i][j + 1] == '.' && map[i][j + 2] == 'X') row++;
                if(map[j][i] == '.' && map[j + 1][i] == '.' && map[j + 2][i] == 'X') col++;
            }
        }

        System.out.println(row + " " + col);
    }
}
