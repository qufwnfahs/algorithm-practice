package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단지번호붙이기_2667 {

	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1 }; // 상 하 좌 운
	static int count = 0;
	
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int node_num = Integer.parseInt(br.readLine());
		int[][] matrix = new int[node_num][node_num];
		
		init(matrix, br);
		
		boolean[][] visited = new boolean[node_num][node_num];
		
		int home = 0;
		int[] numOfHomes = new int[625];
		
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (!visited[i][j] && matrix[i][j] == 1)
				{
					DFS(i, j, visited, matrix);
					numOfHomes[home] = count;
					home++;
					
					count = 0;
				}
			}
		}
		Arrays.sort(numOfHomes, 0, home);
		
		System.out.println(home);
		
		for (int i = 0; i < home; i++)
		{
			System.out.println(numOfHomes[i]);
		}
	}
	
	private static void DFS(int row, int col, boolean[][] visited, int[][] matrix)
	{
		count++;
		visited[row][col] = true;

		for (int i = 0; i < 4; i++)
		{
			int x = row + dx[i];
			int y = col + dy[i];
			
			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y] && matrix[x][y] == 1)
			{
				DFS(x, y, visited, matrix);
			}
		}
	}
	
	private static void init(int[][] matrix, BufferedReader br) throws Exception
	{
		for (int i = 0; i < matrix.length; i++)
		{
			String str = br.readLine();
			
			for (int j = 0; j < matrix[0].length; j++)
			{
				matrix[i][j] = str.charAt(j) - '0';
			}
		}
	}
}
