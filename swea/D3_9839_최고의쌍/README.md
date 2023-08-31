# 📘 9839 최고의 쌍

## 소요시간, 메모리
642ms, 99116KB

## 풀이 방법
- 구현
- 배열 정렬 후 끝에서부터 두개씩 곱하면서 확인하기
- sb 사용할 때, 마지막에 \n 붙이고 println 또 해서 틀림!!!!!!!! 주의‼‼

## Code

```java
package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_9839_최고의쌍 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        L:for (int tc = 1; tc <= TC; tc++) {
            sb.append("#" + tc + " ");
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for (int j = N-1; j > 0; j--) {
                for (int k = j-1; k >= 0; k--) {
                    if(check(arr[j] * arr[k])) {
                        sb.append(arr[j] * arr[k] + "\n");
                        continue L;
                    }
                }
            }

            sb.append("-1\n");
        }
        System.out.print(sb);
    }

    private static boolean check(int n) {
        String num = Integer.toString(n);

        for (int i = 1; i < num.length(); i++) {
            if((num.charAt(i)-'0') - 1 != num.charAt(i-1) - '0') {
                return false;
            }
        }

        return true;
    }

}
```