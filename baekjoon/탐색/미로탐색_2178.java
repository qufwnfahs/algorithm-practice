package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 불려온 이전 값의 저장된 value + 1로 몇 번째 탐색인지 알 수 있는 IDEA를 캐치하지 못함.
// 배웠던 것인데 알지 못했음. 왜일까 ?
// BFS의 정확한 동작 개념을 제대로 이해하지 못해서 일까 ?
// 그 개념을 머리 속에 다시 넣고 더 많은 문제를 풀어보자.
public class 미로탐색_2178 {

	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = {  0, 0, -1, 1 }; // 상 하 좌 우
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[row][col];
		init(matrix, br);
		
		BFS(matrix);
		
		System.out.println(matrix[row-1][col-1]);
	}
	
	private static void BFS(int[][] matrix)
	{
		Queue<String> queue = new LinkedList<String>();
		queue.add("0 0");
		
		while (!queue.isEmpty())
		{
			StringTokenizer st = new StringTokenizer(queue.poll(), " ");	

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
	
			for (int i = 0; i < 4; i++)
			{
				int newX = x + dx[i];
				int newY = y + dy[i];
				
				if (newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[0].length && matrix[newX][newY] == 1)
				{
					queue.add(newX + " " + newY);
					matrix[newX][newY] = matrix[x][y] + 1;
				}
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
