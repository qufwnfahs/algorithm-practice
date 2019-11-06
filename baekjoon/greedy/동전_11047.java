package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class µ¿Àü_11047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int count = getCount(coins, money);
		
		System.out.println(count);
	}
	
	public static int getCount(int[] coins, int money)
	{
		int count = 0;
		
		for (int i = coins.length-1; i >= 0; i--)
		{
			count += money / coins[i];
			money = money % coins[i];
		}
		
		return count;
	}
}
