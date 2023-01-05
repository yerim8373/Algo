package programmers;

import java.util.*;

public class L2_JadenCase문자열만들기 {

	public static void main(String[] args) {
		System.out.println(solution("3people   unFollowed me "));
	}
	
	public static String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
        	if(str[i].equals("")) {
        		sb.append(" ");
        	} else {
        		sb.append(str[i].substring(0, 1).toUpperCase()).append(str[i].substring(1).toLowerCase()).append(" ");
        	}
		}
        
        if(s.substring(s.length()-1).equals(" ")) {
        	sb.append(" ");
        }
        
        answer = sb.substring(0, sb.length()-1);
        return answer;
    }
}
