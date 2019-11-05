package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queens_Problem 
{
	static int[] Q;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N 
		N = Integer.parseInt(br.readLine());
		// 각 row(index)의 Q의 위치
		Q = new int[N];
		
		for (int i = 0; i < N; i++)
		{
			Q[0] = i;
			
			dfs(1);
		}
	}
	
	public static void dfs(int row)
	{
		// row가 N이라면 마지막 행에서도 유망성 검사를 통과하여
		// dfs(row+1)을 수행했다는 이야기이므로
		// 여기서 종료조건을 건다.
		if (row == N)
		{
			printQueen();
		}
			
		for (int i = 0; i < N; i++)
		{
			// 유망성을 미리 검사
			if (isPossible(row, i))
			{
				Q[row] = i;
				dfs(row + 1);
			}
		}
	}
	
	public static boolean isPossible(int row, int col) 
	{
		for (int i = 0; i < row; i++)
		{
			// 같은 열에 있는지 검사
			if (Q[i] == col)
			{
				return false;
			}
			// 대각선 위치 검사식
			else if (Math.abs(i-row) == Math.abs(Q[i]-col))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void printQueen()
	{
		for (int i = 0; i < N; i++)
		{
			if (i == N-1)
				System.out.print("(" + i + ", " + Q[i] + ")");
			else
				System.out.print("(" + i + ", " + Q[i] + "), ");
		}
		System.out.println();
	}
}