package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타줄_1049 
{
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int package_min = 1000;
		int indiv_min = 1000;
		
		for (int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			
			int pack = Integer.parseInt(st.nextToken());
			int indiv = Integer.parseInt(st.nextToken());
			
			if (package_min > pack)
			{
				package_min = pack;
			}
			
			if (indiv_min > indiv)
			{
				indiv_min = indiv;
			}
		}		
		
		int money = calculate(N, package_min, indiv_min);
		
		System.out.println(money);
	}
	
	public static int calculate(int N, int package_min, int indiv_min)
	{
		int money = 0;
		
		if (package_min == 0 || indiv_min == 0)
		{
			return money;
		}
		
		if (package_min >= 6 * indiv_min)
		{
			money += N * indiv_min;
		}
		else
		{
			money += N / 6 * package_min;
			
			money += (N % 6) * indiv_min > package_min ? package_min : indiv_min * (N % 6);
		}
		
		return money;
	}
}
