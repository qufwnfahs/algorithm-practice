package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 모든 구멍이 꼽혀 있어 빼야할 걸 찾을 때
// 가장 늦게 사용될 거 같은 기기를 빼야 하는게 이 문제의 key였다.

public class 멀티탭스케줄링_1700 
{
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int holeN = Integer.parseInt(st.nextToken());
		int useN = Integer.parseInt(st.nextToken());
		int[] sequenceInfos = new int[useN];
		
		init(sequenceInfos, br);
		
		int minPlugOff = findMinPlugOffN(sequenceInfos, holeN);
		
		System.out.println(minPlugOff);
	}
	
	private static int findMinPlugOffN(int[] sequenceInfos, int holeN)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 0;
		
		for (int i = 0; i < sequenceInfos.length; i++)
		{
			if (!list.contains(sequenceInfos[i]))
			{
				if (list.size() == holeN)
				{
					// find remove item
					int item = findRemoveItemIndex(list, sequenceInfos, i);
					list.remove(new Integer(item));
					count++;
					list.add(sequenceInfos[i]);
				}
				else
				{
					list.add(sequenceInfos[i]);
				}
			}
		}
		
		return count;
	}
	
	private static int findRemoveItemIndex(ArrayList<Integer> list, int[] sequenceInfos, int i)
	{
		int index = Integer.MIN_VALUE;
		int target = 0;
		
		int[] temp = Arrays.copyOfRange(sequenceInfos, i+1, sequenceInfos.length);
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
		for (int t : temp)
		{
			tempList.add(t);
		}
		
		for (int x : list)
		{
			int compare = tempList.indexOf(x);
			
			if (compare == -1)
			{
				index = compare;
				target = x;
				break;
			}
			else
			{
				if (index < compare)
				{
					index = compare;
					target = x;
				}
			}
		}
		
		return target;
	}
	
	private static void init(int[] sequenceInfos, BufferedReader br) throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < sequenceInfos.length; i++)
		{
			sequenceInfos[i] = Integer.parseInt(st.nextToken());
		}
		
	}
}
