package Union_Find;

public class Sample {

	public static void main(String[] args) 
	{
		int[] node = new int[10];
		
		for (int i = 0; i < node.length; i++)
		{
			node[i] = i;
		}
		
		// 각 노드의 Parent를 자기 자신으로 초기화
		for (int i : node)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		unionParent(node, 0, 1);
		unionParent(node, 1, 2);
		
		unionParent(node, 4, 5);
		unionParent(node, 4, 6);
		unionParent(node, 6, 9);
		
		for (int i : node)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println(findParent(node, 1, 2));
		System.out.println(findParent(node, 0, 2));
		
		System.out.println(findParent(node, 4, 9));
	}
	
	// 합치기
	public static void unionParent(int[] node, int a, int b)
	{
		a = getParent(node, a);
		b = getParent(node, b);
		
		if (a < b)
		{
			node[b] = a;
		}
		else
		{
			node[a] = b;
		}
	}
	
	// 부모 찾기
	public static int getParent(int[] node, int parent)
	{
		if (node[parent] == parent)
		{
			return parent;
		}
		
		return node[parent] = getParent(node, node[parent]);
	}
	
	// 같은 그룹 확인
	public static boolean findParent(int[] node, int a, int b)
	{
		a = getParent(node, a);
		b = getParent(node, b);
		
		if (a == b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
