package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class silver2_16401_과자나눠주기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long result = 0;
        long max = 0;
        long[] snack = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }

        long left = 1, right = max;
        while(left <= right){
            long mid = (right + left) / 2;
            int cnt = 0;
            for (int i = 0; i < snack.length; i++) {
                cnt += snack[i] / mid;
            }

            if(cnt >= M){
                result = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(result);
    }
}
