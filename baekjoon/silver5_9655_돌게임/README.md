# 📘 9655 돌 게임

## 소요시간, 메모리
136ms, 14344KB

## 풀이 방법
- dp
- 처음에 2개도 가져가도 되는 줄..!

## Code

```java
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class silver5_9655_돌게임 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        N %= 2;
        if(N == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

}

```