import java.io.*;
import java.util.*;

public class naver2 {
    // BOOL - 1
    // SHORT - 2
    // FLOAT - 4
    // INT - 8
    // LONG - 16
    public static void main(String[] args) throws IOException {
        String[] arr = new String[] {"INT", "INT", "BOOL", "SHORT", "LONG"};
        // String[] arr = new String[] {"INT", "SHORT", "FLOAT", "INT", "BOOL"};
        // String[] arr = new String[] {"FLOAT", "SHORT", "BOOL", "BOOL", "BOOL", "INT"};
        int idx = 0;
        String temp = "";

        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            int value = change(arr[i]);

            if(value >= 8) {
                if(idx != 0) {
                    for(int j = idx; j < 8; j++) temp += ".";
                    idx = 0;
                    list.add(temp);
                    temp = "";
                }
                if(value == 8) list.add("########");
                else if(value == 16) {
                    list.add("########");
                    list.add("########");
                }
            } else {
                if(idx + value >= 8) {
                    for(int j = idx; j < 8; j++) temp += ".";
                    idx = 0;
                    list.add(temp);
                    temp = "";
                }
                if(value == 1) {
                    if(i + 1 != arr.length && arr[i + 1].equals("BOOL")) {
                        temp += "#";
                        idx++;
                    }
                    else {
                        temp += "#.";
                        idx += 2;
                    }
                }
                if(value == 2) {
                    if(idx != 0 && idx % 2 == 0) {
                        temp += ".";
                        idx++;
                    }
                    for(int j = 0; j < value; j++) temp += "#";
                    idx += value;
                }
                if(value == 4) {
                    if(idx >= 4) {
                        for(int j = idx; j < 8; j++) temp += ".";
                        list.add(temp);
                        idx = 0;
                    }
                    if(idx != 0) {
                        for(int j = idx; j < 4; j++) {
                            temp += ".";
                            idx++;
                        }
                    }
                    for(int j = 0; j < value; j++) temp += "#";
                    idx += value;
                }
            }
        }
        if(idx != 0) {
            for(int i = idx; i < 8; i++) temp += ".";
            list.add(temp);
        }

        System.out.println(list);
    }

    static int change(String str) {
        int value = 0;
        switch (str) {
            case "BOOL":
                value = 1;
                break;
        
            case "SHORT":
                value = 2;
                break;

            case "FLOAT":
                value = 4;
                break;

            case "INT":
                value = 8;
                break;

            case "LONG":
                value = 16;
                break;
        }

        return value;
    }
}
