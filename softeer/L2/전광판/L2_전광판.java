import java.util.*;
import java.io.*;


public class Main
{
	static boolean[][] light = {{true, true, true, false, true, true, true},
		{false,false,true,false,false,true,false},
		{true,false,true,true,true,false,true},
		{true,false,true,true,false,true,true},
		{false,true,true,true,false,true,false},
		{true,true,false,true,false,true,true},
		{true,true,false,true,true,true,true},
		{true,true,true,false,false,true,false},
		{true,true,true,true,true,true,true},
		{true,true,true,true,false,true,true},
		{false,false,false,false,false,false,false}};

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int a = A, b = B;
			int result = 0;

			for(int i = 4; i >= 0; i--){
				int ta = a/(int)(Math.pow(10, i));
				int tb = b/(int)(Math.pow(10, i));

				// 맨앞자리가 모두 꺼져있을수도 있음...
				if(A < (int)(Math.pow(10, i))){
					ta = 10;
				}
				if(B < (int)(Math.pow(10, i))){
					tb = 10;
				}

				// 숫자다르면 실행
				if(ta != tb){
					for(int j = 0; j < 7; j++){
						if(light[ta][j] != light[tb][j]){
							result++;
						}
					}
				}

				a = a%(int)(Math.pow(10, i));
				b = b%(int)(Math.pow(10, i));
			}

			System.out.println(result);
		}
	}
}