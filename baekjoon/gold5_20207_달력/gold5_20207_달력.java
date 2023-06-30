import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int min = 366, max = 0;
        int[] arr = new int[366];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            min = Math.min(min, start);
            max = Math.max(max, end);
            for (int j = start; j <= end; j++) {
                arr[j]++;
            }
        }

        int col = 0, row = 0, result = 0;
        for (int i = min; i <= max; i++) {
            if(arr[i] > 0) {
                col++;
                row = Math.max(row, arr[i]);
            } else {
                result += col * row;
                col = 0; row = 0;
            }
        }
        result += col * row;

        System.out.println(result);
    }
}