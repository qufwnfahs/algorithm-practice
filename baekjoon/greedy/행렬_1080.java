package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬_1080 
{
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		int[][] arr_tg = new int[n][m];
		
		init(arr, br);
		init(arr_tg, br);
		
		int count = findMin(arr, arr_tg);

		System.out.println(count);
	}
	
	public static int findMin(int[][] arr, int[][] arr_tg)
	{
		int count = 0;

		for (int i = 0; i < arr.length-2; i++)
		{
			for (int j = 0; j < arr[i].length-2; j++)
			{
				if (arr[i][j] != arr_tg[i][j])
				{
					doConvert(arr, arr_tg, i, j);
					count++;
				}
			}
		}
		
		if (isMatch(arr, arr_tg))
		{
			return count;
		}
		
		return -1;
	}
	
	public static void doConvert(int[][] arr, int[][] arr_tg, int row, int col)
	{
		for (int i = row; i < row + 3; i++)
		{
			for (int j = col; j < col + 3; j++)
			{
				arr[i][j] = (arr[i][j] + 1) % 2;
			}
		}
	}
	
	public static void init(int[][] arr, BufferedReader br) throws Exception
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				arr[i][j] = br.read() - 48;
			}
			br.readLine();
		}
	}
	
	public static boolean isMatch(int[][] arr, int[][] arr_tg)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				if (arr[i][j] != arr_tg[i][j])
				{
					return false;
				}
			}
		}	
		return true;
	}
}
