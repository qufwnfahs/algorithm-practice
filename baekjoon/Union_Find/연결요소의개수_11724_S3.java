package BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 연결 요소의 개수를 판단하는 것이므로
// 두 점의 연결을 판별하는 알고리즘 Disjoint-Set 알고리즘을 응용하였다.
// 처음에는 연결 요소를 이해하지 못하여 인터넷을 참조하였고 말 그대로 연결 요소라는 것을 이해, Disjoint-Set 알고리즘을 써야 한다는 것을 인터넷으로 봤지만 머리로도 이해함.
// 그러나 Disjoint-Set 알고리즘은 두 점의 연결관계를 확인하는 것이므로 지금처럼 연결 요소의 개수를 확인하려하니 조금의 응용이 필요했다.
// 그리고 unionParent() 메소드만 이용해서는 완성된 Parent 테이블이 갖춰지지 않는 것을 확인하였다.
// 결국 findParent()로 부모의 일치성을 확인할 수 있는 구조였다.
// 그래서 중복 값이 저장되지 않는 Set을 이용하여 모든 노드에게 findParent() 메소드를 호출하여 제대로 된 부모를 가리킬 수 있게 갱신함과 동시에 값을 Set에 넣어 Size를 도출해내어 문제를 해결하였다.
// 이러한 연결 요소의 개수를 구하려 했을 때 더 효율적인 해결방법은 무엇일까

// Set을 쓰지 않고 가능한 방법이 있었다.
// 테이블이 다 완성되지 않아도 완벽한 테이블이 아닌거지, 유추 가능한 테이블이란 소리다.
// 그러므로 부모 노드의 개수만 세면, 결국 연결 요소의 개수라는 거다.
// 즉, arr[i] = i인 노드의 개수만 세면, 연결 요소의 개수를 나타내는 것과 같다.

public class 연결요소의개수_11724_S3 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int vertex_num = Integer.parseInt(st.nextToken());
		int edge_num = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[vertex_num];
		for (int i = 0; i < vertex_num; i++)
		{
			parent[i] = i;
		}
		
		int connected_num = find(parent, edge_num, br);
		
		System.out.println(connected_num);
	}
	
	public static int find(int[] parent, int edge_num, BufferedReader br) throws Exception
	{
		for (int i = 0; i < edge_num; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			unionParent(parent, x, y);
		}
		
		int count = 0;
	
		for (int i = 0; i < parent.length; i++)
		{
			if (parent[i] == i)
			{
				count++;
			}
		}
		return count;
	}
	
	public static void unionParent(int[] parent, int x, int y)
	{
		x = getParent(parent, x);
		y = getParent(parent, y);
		
		if (x < y)
		{
			parent[y] = x;
		}
		else
		{
			parent[x] = y;
		}
	}
	
	public static int getParent(int[] parent, int x)
	{
		if (parent[x] == x)
		{
			return x;
		}
		
		return parent[x] = getParent(parent, parent[x]);
	}
}
