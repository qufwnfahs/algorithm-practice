package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 
{
	// 모든 점에 대해서 가능성을 조사하기엔 너무 큰 경우의 수가 나와서
	// 확인해야 할 점을 줄일 수 있는 방법은 없는가에 초점을 맞췄음
	// 2가 확산할 자리를 미리 벽으로 그어가며 확인해보는 방법이었는데
	// 벽이 하나도 없을 때는 이 방법이 소용이 없었음
	
	// 완전탐색을 하면 안될거라 생각했었다.
	// 봐야할 경우의 수가 너무 클거라 생각했지만 문제를 다시 보니 최대 8 by 8이었기 때문에
	// 최악의 경우 64 * 63 * 62인 25만 정도의 경우의 수가 나온다.
	// 이 정도는 무식하게 풀만 했기 때문에
	// 완전 탐색을 썼어야 했다.
	// 모든 경우의 수를 보는 것도 막막했다고 생각한다.
	// 실제로 보니 쉬운 문제였다.
	// 바이러스 확산은 BFS로 쉽게 구현
	// 벽의 경우의 수는 DFS로 쉽게 구현하였다. (나올 수 있는 2차원 조합의 수를 구하는 거였기 때문에 쉽게 와닿지 않았다고 생각)
	public static int max = 0;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[row][col];
		int[][] copy = new int[row][col];
		
		ArrayList<Node> virusList = new ArrayList<Node>();
		
		init(matrix, copy, virusList, br);
		
		setWall(0, 0, matrix, copy, virusList);
		
		System.out.println(max);
	}
	
	private static void setWall(int start, int depth, int[][] matrix, int[][] copy, ArrayList<Node> virusList)
	{
		if (depth == 3)
		{
			// virus 확산
			copyMatrix(matrix, copy);
			
			for (Node node : virusList)
			{
				spreadVirus(node, copy);
			}
			
			max = Math.max(max, getSafeArea(copy));
			
			return;
		}
		
		for (int i = start; i < matrix.length * matrix[0].length; i++)
		{
			int x = i / matrix[0].length;
			int y = i % matrix[0].length;
			
			if (matrix[x][y] == 0)
			{
				matrix[x][y] = 1;
				setWall(i+1, depth+1, matrix, copy, virusList);
				matrix[x][y] = 0;
			}
		}
	}
	
	private static void spreadVirus(Node node, int[][] copy)
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		while (!queue.isEmpty())
		{
			Node curr = queue.poll();
			
			for (int i = 0; i < 4; i++)
			{
				int x = curr.x + dx[i];
				int y = curr.y + dy[i];
				
				if (x >= 0 && x < copy.length && y >= 0 && y < copy[0].length && copy[x][y] == 0)
				{
					copy[x][y] = 2;
					queue.add(new Node(x, y));
				}
			}
		}
	}
	
	private static int getSafeArea(int[][] copy)
	{
		int count = 0;
		
		for (int i = 0; i < copy.length; i++)
		{
			for (int j = 0; j < copy[0].length; j++)
			{
				if (copy[i][j] == 0)
				{
					count++;
				}
			}
		}
		
		return count;
	}
	
	private static void copyMatrix(int[][] matrix, int[][] copy)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
		}
	}
	
	private static void init(int[][] matrix, int[][] copy, ArrayList<Node> virusList, BufferedReader br) throws Exception
	{
		for (int i = 0; i < matrix.length; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < matrix[0].length; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
				
				if (matrix[i][j] == 2)
				{
					virusList.add(new Node(i, j));
				}
			}
		}
	}
}

class Node
{
	int x, y;
	
	public Node(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}