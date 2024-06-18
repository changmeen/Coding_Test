import java.io.*;
import java.util.*;

public class naver1 {
    public static void main(String[] args) throws IOException {
        // int[] arr = new int[] {1, 2, 3, 3, 3, 3, 4, 4};
        // int[] arr = new int[] {3, 2, 4, 4, 2, 5, 2, 5, 5};
        int[] arr = new int[] {3, 5, 7, 9, 1};

        // 일단 Map이라는 자료구조는 key와 Value라는 쌍 구조로 이루어져 있음
        // 즉 Key에 해당하는 값을 저장해 두는 자료 구조라는 것
        // 일반 Map(HashMap)과는 다르게 TreeMap은 key 값이 오름차순 정렬되서 데이터가 저장됨
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        // 즉 이 for문은 arr의 배열에 있는 값들을 하나 씩 꺼내서 확인하면서
        // tm 즉 TreeMap이 이미 해당 값의 key가 존재하는지 확인하고
        // 있으면 그 value값을 없으면 0을 가져와서 + 1을 해준다는 내용
        // 이 for문이 끝나게 되면 첫번째 arr 배열 기준으로
        // 1 - 1
        // 2 - 1
        // 3 - 4
        // 4 - 2
        // 이런식으로 key value가 쌍을 이루면서 저장되어 있음
        for(int i = 0; i < arr.length; i++) {
            tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);
        }

        // 이제 답을 출력하기 위한 LinkedList를 준비해두고
        LinkedList<Integer> list = new LinkedList<>();
        // TreeMap을 살펴보면서 (살피기 위해 tm.keySet()으로 key의 배열을 불러오고)
        // Integer key : 를 적음으로서 하나씩 확인한다는 내용
        // 현재 확인하는 key값에 해당하는 value 값이 2 이상인 경우
        // list에 넣어준다
        // 즉 모든 for문을 다 돌면 value가 2 이상인 3과 4가 들어가 있게 됨
        for(Integer key : tm.keySet()) {
            if(tm.get(key) >= 2) {
                list.add(tm.get(key));
            }
        }

        // 만약 list에 아무런 값이 안들어가게 되면 (3번째 arr 처럼)
        // -1을 넣어준다는 내용
        if(list.size() == 0) list.add(-1);

        // list를 출력
        System.out.println(list);
    }
}
