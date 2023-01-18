# 📘 성적 평균

## 풀이 방법

## Code

```java
import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] score = new int[N];
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int j=start-1; j<end; j++){
                sum += score[j];
            }
            sb.append(String.format("%.2f", (double)sum/(end-start+1))).append("\n");
        }
        System.out.println(sb);
    }
}

```