package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class gold5_23843_콘센트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int[] sum = new int[M];
        if(N <= M) {
            System.out.println(pq.poll());
            return;
        }

        int cur = 0;
        while(!pq.isEmpty()){
            // 처음꺼로 돌아오면 그냥 추가해줘야함!!
            if(cur == 0){
                sum[cur] += pq.poll();
            }
            // 현재꺼가 전꺼보다 작으면 추가해주기
            else if(sum[cur] + pq.peek() <= sum[0]){
                sum[cur] += pq.poll();
                continue;
            }
             // 크면 다음꺼로 넘기기
             cur = (cur+1)%M;
        }

        System.out.println(sum[0]);
    }
}