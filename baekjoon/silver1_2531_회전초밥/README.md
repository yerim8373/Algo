# 📘 2531 회전 초밥

## 소요시간, 메모리
188ms, 18620KB

## 풀이 방법
- 슬라이딩 윈도우
- 초밥 배열과 가짓수 방문 배열을 선언해서 처음부터 끝까지 지우고 추가하고 반복
- 방문 배열을 int로 선언한 이유는 boolean일 경우 똑같은 스시를 또 못먹게된다
-  중복이 있기때문에! (시작점을 false로 다시 바꿀순없자나)

## Code

```java
package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class silver1_2531_회전초밥 {
    static int N, d, k, c;
    static int[] plate;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        plate = new int[N];
        int[] sushi = new int[d+1]; // 가짓수 -> boolean으로 하면 먹었던 스시 또 못머금
        for (int i = 0; i < N; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        int tmp = 0;
        for (int i = 0; i < k; i++) {
            // 현재 스시를 먹지않았으면
            if(sushi[plate[i]] == 0){
                tmp++;
            }
            sushi[plate[i]]++;
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            // 최댓값 갱신
            if(result <= tmp){
                // 쿠폰 방문 여부 확인해서 추가
                if(sushi[c] == 0){
                    result = tmp+1;
                } else{
                    result = tmp;
                }
            }
            // 시작점 줄이기
            sushi[plate[i]]--;
            // 0이면 가짓수 줄여야함
            if(sushi[plate[i]] == 0){
                tmp--;
            }
            // 끝점 추가하기
            int end = (i + k) % N;
            // 0이면 가짓수 늘려야함
            if(sushi[plate[end]] == 0){
                tmp++;
            }
            sushi[plate[end]]++;
        }

        System.out.println(result);
    }

}
```