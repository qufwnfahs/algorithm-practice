package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Thirty_10610 {
	
	static char[] arr;

	// 3의 배수는 각 자리의 수의 합이 3의 배수이다.
	// 정규식을 사용하는 건 느리다.
	// 아스키 코드 값.
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = br.readLine().toCharArray();
		
		int sum = 0;
		
		boolean isZero = false;
		
		for (int i = arr.length-1; i > -1; i--)
		{
			sum += arr[i] - 48;
			
			if (arr[i] - 48 == 0)
			{
				isZero = true;
			}
		}
		
		if (!isZero || sum % 3 != 0)
		{
			System.out.println(-1);
		}
		else
		{
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder(new String(arr));
			
			System.out.println(sb.reverse().toString());
		}
	}
}
