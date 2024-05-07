package Baekjoon.silver;
import java.io.*;

public class No_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0.0;
        int num = 0;

        for(int i = 0; i < 20; i++) {
            String[] s = br.readLine().split("\\s+");
            if(s[2].equals("P")) continue;

            else{
                num += Double.parseDouble(s[1]);

                sum += (Double.parseDouble(s[1]) * change(s[2]));
            }
        }

        if(sum == 0.0) {
            System.out.println("0.000000");
            return;
        }
        Double answer = sum / num;
        System.out.printf("%.6f", answer);
    }

    static Double change(String grade) {
        Double result = 0.0;

        switch (grade) {
            case "A+":
            result = 4.5;
            break;

            case "A0":
            result = 4.0;
            break;

            case "B+":
            result = 3.5;
            break;

            case "B0":
            result = 3.0;
            break;

            case "C+":
            result = 2.5;
            break;

            case "C0":
            result = 2.0;
            break;

            case "D+":
            result = 1.5;
            break;

            case "D0":
            result = 1.0;
            break;

            case "F":
            result = 0.0;
            break;
        }

        return result;
    }
}
