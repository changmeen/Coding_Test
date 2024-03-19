package Baekjoon.gold;
import java.io.*;
import java.util.*;

// 백준 골드5 달력
public class No_20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, S, E, answer = 0;
        int[] calculator = new int[1001];
        // 달력에서 일정이 처음으로 나오는 날
        int min = Integer.MAX_VALUE;
        // 달력에서 마지막 일정이 있는 날
        int max = Integer.MIN_VALUE;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            for(int j = S; j <= E; j++) {
                if(j < min) min = j;
                if(j > max) max = j;
                // 일정이 있는 날 해당 일의 일정 개수 입력
                calculator[j]++;
            }
        }

        // cnt는 연속되는 일정 기간 중 최대 일정의 개수를 저장하는 변수
        // idx는 연속되는 일정의 시작 날짜를 저장하는 변수
        int cnt = 0;
        int idx = 0;
        // 일정이 있는 기간만 살피며 중간에 일정이 없는 날이 있는 경우
        // 이전 까지 있었던 일정들 중 최대 일정 수 * 연속된 일정 기간을 더해줌
        for(int i = min; i <= max; i++) {
            // 일정이 없으며 바로 전 날에는 일정이 있었을 경우
            if(calculator[i] == 0 && calculator[i - 1] != 0) {
                answer += cnt * (i - idx);
                cnt = 0;
                idx = 0;
            }
            // 마지막 날 포함하여 계산
            else if(i == max) {
                if(cnt < calculator[i]) cnt = calculator[i];
                if(idx == 0) idx = i;
                answer += cnt * (i - idx + 1);
            }

            // 연속된 일정의 기간 중에는 idx값과 cnt의 값을 갱신
            if(calculator[i] != 0) {
                if(idx == 0) idx = i;
                if(cnt < calculator[i]) cnt = calculator[i];
            }
        }

        System.out.println(answer);
    }
}