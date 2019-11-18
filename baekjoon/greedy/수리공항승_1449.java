package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 각 위치를 막는데 테이프의 길이 1 소요된다.
// 앞에서부터 탐색하는 것과 뒤에서 부터 탐색하는 것에 차이가 있을까?
// 순전히 앞에서부터 탐색하여 테이프를 자를 수도 없으니 그냥 길이만큼 붙인 뒤 남은 구멍 개수를 보면 된다.

// Arrays.binarySearch 특징을 이용해 막아야 할 다음 구멍이 어딘지 쉽게 찾아냈다.

public class 수리공항승_1449 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int holeN = Integer.parseInt(st.nextToken());
		int tapeLen = Integer.parseInt(st.nextToken());
		int[] holes = new int[holeN];
		
		init(holes, br);
		
		int minUse = findMinUseN(holes, tapeLen);
		
		System.out.println(minUse);
	}
	
	private static int findMinUseN(int[] holes, int tapeLen)
	{
		int index = 0;
		int count = 0;
		
		while (true)
		{
			if (index == holes.length)
			{
				break;
			}
			
			int start = holes[index];
			count++;
			
			int next = Arrays.binarySearch(holes, start+tapeLen);
			index = next >= 0 ? next : -next-1;
		}
		
		return count;
	}
	
	private static void init(int[] holes, BufferedReader br) throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < holes.length; i++)
		{
			holes[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(holes);
	}
}
