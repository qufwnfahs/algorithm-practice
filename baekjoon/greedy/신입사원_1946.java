package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입사원_1946 {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cases; i++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] persons = new int[n];
			
			for (int j = 0; j < n; j++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				persons[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
			}
			
			int count = findNumberOfPerson(persons);
			
			System.out.println(count);
		}
	}
	
	public static int findNumberOfPerson(int[] persons)
	{
		// 1등은 항상 들어감
		int count = 1;
		int rank = persons[0];
		
		for (int i = 1; i < persons.length; i++)
		{
			if (rank > persons[i])
			{
				count++;
				rank = persons[i];
			}
		}
		
		return count;
	}
}
