# 📘 다음 큰 숫자

## 풀이 방법
- n을 하나씩 증가시키면서 조건 확인
- Integer.toBinaryString()을 사용했는데 Integer.bitCount()라는 함수가 있었음
- Integer.bitCount() -> 2진수로 변환 후 1의 개수 카운트해줌!

## Code

```java
package programmers;

public class L2_다음큰숫자 {

    public static void main(String[] args) {
        System.out.println(solution(78));
    }

    public static int solution(int n) {
        int answer = n;
        int cnt_n = 0;

        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                cnt_n++;
            }
        }

        while(true) {
            int cnt_next = 0;
            answer++;
            String str_next = Integer.toBinaryString(answer);
            for(int i = 0; i < str_next.length(); i++) {
                if(str_next.charAt(i) == '1') {
                    cnt_next++;
                }
            }

            if(cnt_n == cnt_next) {
//                System.out.println(cnt_next);
                break;
            }
        }

        return answer;
    }
}

```