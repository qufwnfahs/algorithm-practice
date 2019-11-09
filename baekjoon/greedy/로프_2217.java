package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 로프_2217 {

	static Integer[] lopes;
	static int n;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		lopes = new Integer[n];
		
		for (int i = 0; i < n; i++)
		{
			lopes[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(lopes, Comparator.reverseOrder());
		
		int max = 0;
		
		for (int i = 1; i <= n; i++)
		{
			if (max < lopes[i-1] * i)
			{
				max = lopes[i-1] * i;
			}
		}
			
		System.out.println(max);
	}
}
