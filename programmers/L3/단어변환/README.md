# π λ¨μ΄ λ³ν

## νμ΄ λ°©λ²
- λ°©λ¬Έλ°°μ΄ λ§λ  ν dfs νμ
- λ°©λ¬Ένμ§ μμκ³  νκ°μ μνλ²³λ§ λ€λ₯΄λ€λ©΄ dfs
- dfs ν¨μ λΆλ¬μ¬ λ cnt++λ‘ ν΄μ μκ° μμ²­ μ‘μλ¨Ήμ.. cnt+1...γ γ 

## Code

```java
package programmers;

public class L3_λ¨μ΄λ³ν {
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