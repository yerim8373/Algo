# 📘 10815 숫자 카드

## 소요시간, 메모리
1308ms, 111820KB

## 풀이 방법
- 이분 탐색 (left, right, mid)
- 전역변수로 N 선언해놓고 int N 또 선언한거... ㅠ

## Code

```java
package BAEKJOON;

import java.io.*;
import java.util.*;

public class silver5_10815_숫자카드 {
    static int N;
    static int[] sang;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sang = new int[N];
        for (int i = 0; i < sang.length; i++) {
            sang[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sang);
        //		System.out.println(Arrays.toString(sang));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int vs = Integer.parseInt(st.nextToken());
            if(binarySearch(vs)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int vs) {
        int left = 0;
        int right = N - 1;

        while(left <= right) {
            int mid = (right + left) / 2;

            if(vs > sang[mid]) {
                left = mid+1;
            } else if(vs < sang[mid]){
                right = mid-1;
            } else {
                return true;
            }
        }

        return false;
    }

}


```