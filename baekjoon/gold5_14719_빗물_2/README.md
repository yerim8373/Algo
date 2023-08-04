# 📘 14719 빗물

## 소요시간, 메모리
140ms, 14296KB

## 풀이 방법
- 현재 열 기준으로 왼쪽 제일 큰 값과 오른쪽 제일 큰 값 구해서 둘 중 더 작은값 구해서 차이값 더해줌
- 맨앞, 맨뒤는 안해도됨 -> left or right 둘 중 하나가 0이면 걍 리턴
- 처음에 시간계산 잘못해서 이 방법으로는 안되는 줄 알고 ...

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold5_14719_빗물 {
    static int result = 0;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W-1; i++) {
            rain(i);
        }

        System.out.println(result);
    }

    private static void rain(int i) {
        int left = 0, right = 0;

        for (int j = 0; j < i; j++) {
            if(arr[j] > arr[i] && arr[j] > left){
                left = arr[j];
            }
        }

        for (int j = i+1; j < arr.length; j++) {
            if(arr[j] > arr[i] && arr[j] > right){
                right = arr[j];
            }
        }

        if(left == 0 || right == 0) {
            return;
        }

        result += Math.min(left, right) - arr[i];
    }
}
```