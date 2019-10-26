package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
		
		Arrays.sort(arr);
		
		System.out.println(getGreedyTime(arr));
	}
	
	public static int getGreedyTime(int[] arr)
	{
		int time = 0;
		int weight = 0;
		
		for (int i : arr)
		{
			time += i + weight;
			weight = i + weight;
		}
		
		return time;
	}	
}
