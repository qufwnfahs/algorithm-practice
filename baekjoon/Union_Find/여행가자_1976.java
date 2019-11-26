package Union_Find;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자_1976 {

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int city_num = Integer.parseInt(br.readLine());
		int planCity_num = Integer.parseInt(br.readLine());
		
		int[] cities = new int[city_num];
		int[] planCities = new int[planCity_num];
		int[][] adj_matrix = new int[city_num][city_num];
		
		for (int i = 0; i < city_num; i++)
		{
			cities[i] = i;
		}
		
		init(adj_matrix, br);
		init(planCities, br);
		
		doUnion(cities, adj_matrix);
		
		String canTravel = checkTravelPossible(cities, planCities);
		
		System.out.println(canTravel);
	}
	
	private static void init(int[][] adj, BufferedReader br) throws Exception
	{
		for (int i = 0; i < adj.length; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < adj[0].length; j++)
			{
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void init(int[] planCities, BufferedReader br) throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		for (int i = 0; i < planCities.length; i++)
		{
			planCities[i] = Integer.parseInt(st.nextToken()) - 1;
		}
	}
	
	private static void doUnion(int[] cities, int[][] adj)
	{
		for (int i = 0; i < adj.length-1; i++)
		{
			for (int j = i+1; j < adj[0].length; j++)
			{
				if (adj[i][j] == 1)
				{
					unionParent(cities, i, j);
				}
			}
		}
	}
	
	private static void unionParent(int[] cities, int a, int b)
	{
		a = getParent(cities, a);
		b = getParent(cities, b);
		
		if (a < b)
		{
			cities[b] = a;
		}
		else
		{
			cities[a] = b;
		}
	}
	
	private static int getParent(int[] cities, int target)
	{
		if (cities[target] == target)
		{
			return target;
		}
		
		return cities[target] = getParent(cities, cities[target]);
	}
	
	private static String checkTravelPossible(int[] cities, int[] planCities)
	{
		int parent = cities[planCities[0]];
		
		for (int i = 1; i < planCities.length; i++)
		{
			if (parent != getParent(cities, planCities[i]))
			{
				return "NO";
			}
		}
		return "YES";
	}
}
