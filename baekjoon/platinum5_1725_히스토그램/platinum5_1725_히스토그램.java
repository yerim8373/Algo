package Baekjoon;

import java.io.*;
import java.util.*;

public class platinum5_1725_히스토그램 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] height = new int[N+2]; // 맨앞, 맨뒤 계산해주려고
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        long max = stk.peek();
        for (int i = 1; i < N+2; i++) {
            // 스택 비어있지 않고 전에꺼보다 크면 전에꺼 다 꺼내주면서 최대 크기 체크해주기
            while(!stk.isEmpty()){
                int post = stk.peek();

                // 이전꺼보다 크거나 같으면 걍 넘기기
                if(height[post] <= height[i]) break;

                // 최댓값이랑 현재
                stk.pop();
                // 이전꺼 높이 * 이전꺼 가로 길이
                max = Math.max(max, height[post] * (i - stk.peek() - 1));
            }

            stk.push(i);
        }

        System.out.println(max);
    }
}