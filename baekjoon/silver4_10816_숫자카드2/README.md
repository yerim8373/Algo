# 📘 10816 숫자 카드 2

## 소요시간, 메모리
1600ms, 124060KB

## 풀이 방법
- upperBound, lowerBound
- 자바에서는 이 함수 지원안함, 그래서 직접 구현해야함
- index 넘 헷갈

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