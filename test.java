import java.io.*;

class test {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int answer = 0;
        map = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        while(true) {
            int cnt = checkBlock(m, n);
            if(cnt == 0) break;
            answer += cnt;
            
            dropBlock(m, n);
        }
        
        System.out.println(answer);
    }
    
    private static int checkBlock(int m, int n) {
        int cnt = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(map[i][j] == '-') continue;
                visited = checkFour(i, j, visited);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) {
                    map[i][j] = '-';
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private static boolean[][] checkFour(int m, int n, boolean[][] visited) {
        if(map[m][n] == map[m + 1][n] && map[m][n] == map[m][n + 1]
          && map[m][n] == map[m + 1][n + 1]) {
            visited[m][n] = true;
            visited[m + 1][n] = true;
            visited[m][n + 1] = true;
            visited[m + 1][n + 1] = true;
        }
        
        return visited;
    }
    
    private static void dropBlock(int m, int n) {
        for(int c = 0; c < n; c++) {
            for(int r = m - 1; r >= 0; r--) {
                if(map[r][c] == '-') {
                    for(int nr = r - 1; nr >= 0; nr--) {
                        if(map[nr][c] == '-') {
                            map[nr][c] = map[nr - 1][c];
                            map[nr- 1][c] = '-';
                        }
                    }
                }
            }
        }
    }
}