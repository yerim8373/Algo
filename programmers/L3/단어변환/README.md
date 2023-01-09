# 📘 단어 변환

## 풀이 방법
- 방문배열 만든 후 dfs 탐색
- 방문하지 않았고 한개의 알파벳만 다르다면 dfs
- dfs 함수 불러올 때 cnt++로 해서 시간 엄청 잡아먹움.. cnt+1...ㅠㅠ

## Code

```java
package programmers;

public class L3_단어변환 {
    static boolean[] visit;
    static int answer = 51;
    public static void main(String[] args) {
        String[] words = {"abb", "aba"};
        System.out.println(solution("aab", "aba", words));

    }

    public static int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer == 51? 0:answer;
    }

    private static void dfs(String begin, String target, String[] words, int cnt) {

        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if(!visit[i] && check(begin, words[i])) {
                visit[i] = true;
                dfs(words[i], target, words, cnt+1);
                visit[i] = false;
            }
        }
    }

    private static boolean check(String begin, String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == begin.charAt(i)) {
                cnt++;
            }
        }

        if(cnt == begin.length()-1) {
            return true;
        }

        return false;
    }
}


```