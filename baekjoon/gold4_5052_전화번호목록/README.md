# 📘 5052 전화번호 목록

## 소요시간, 메모리
572ms, 33420KB

## 풀이 방법
- 번호를 String 배열에 저장한 후 정렬
- 문자열 오름차순으로 정렬했으니 앞뒤만 비교해주면 된다
- ex) 113, 12, 123 -> 이 순서로 정렬되니까 앞뒤만 비교해주면 됨❕
  - 문자열 비교할 때, startsWith() 함수 사용

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class gold4_5052_전화번호목록 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        L:for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);

            for (int i = 1; i < arr.length; i++) {
                if(arr[i].startsWith(arr[i-1])){
                    System.out.println("NO");
                    continue L;
                }
            }
            System.out.println("YES");
        }
    }
}
```
