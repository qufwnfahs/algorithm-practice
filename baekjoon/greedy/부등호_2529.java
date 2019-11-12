package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부등호_2529 
{
	static int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] Q;
	static String minString = "";
	static String maxString = "";
	
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] signs = new String[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++)
		{
			signs[i] = st.nextToken();
		}
		
		Q = new int[n+1];
		boolean[] visited = new boolean[10];
		
		for (int i = 0; i < arr.length; i++)
		{	
			Q[0] = arr[i];
			visited[i] = true;
			dfs(1, visited, signs);
			visited[i] = false;
		}
		
		System.out.println(maxString.replaceAll("[^0-9]", ""));
		System.out.println(minString.replaceAll("[^0-9]", ""));
	}
	
	public static void dfs(int row, boolean[] visited, String[] signs)
	{
		if (row == Q.length)
		{
			if (minString.equals(""))
			{
				minString = Arrays.toString(Q);
			}
			
			maxString = Arrays.toString(Q);
			return;
		}
		
		for (int i = 0; i < arr.length; i++)
		{
			if (!visited[i] && isPossible(row, i, signs))
			{
				Q[row] = arr[i];
				visited[i] = true;
				dfs(row+1, visited, signs);
				visited[i] = false;
			}
		}
	}
	
	public static boolean isPossible(int row, int i, String[] signs)
	{
		if (signs[row-1].equals("<"))
		{
			if (i > Q[row-1])
			{
				return true;
			}
			return false;
		}
		else
		{
			if (i < Q[row-1])
			{
				return true;
			}
			return false;
		}
	}
}
