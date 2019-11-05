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
		// �� row(index)�� Q�� ��ġ
		Q = new int[N];
		
		for (int i = 0; i < N; i++)
		{
			Q[0] = i;
			
			dfs(1);
		}
	}
	
	public static void dfs(int row)
	{
		// row�� N�̶�� ������ �࿡���� ������ �˻縦 ����Ͽ�
		// dfs(row+1)�� �����ߴٴ� �̾߱��̹Ƿ�
		// ���⼭ ���������� �Ǵ�.
		if (row == N)
		{
			printQueen();
		}
			
		for (int i = 0; i < N; i++)
		{
			// �������� �̸� �˻�
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
			// ���� ���� �ִ��� �˻�
			if (Q[i] == col)
			{
				return false;
			}
			// �밢�� ��ġ �˻��
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