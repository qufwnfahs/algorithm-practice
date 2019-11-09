package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정_1931 {

	static Schedule[] schedules;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		schedules = new Schedule[n];
		
		for (int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			schedules[i] = new Schedule(start, end);
		}
		
		Arrays.sort(schedules);
		
		int count = getMaxCount();
		
		System.out.println(count);
	}
	
	public static int getMaxCount()
	{
		Schedule curr = schedules[0];
		
		int count = 1;
		
		for (int i = 1; i < schedules.length; i++)
		{
			if (schedules[i].getStart() == schedules[i].getEnd())
			{
				count++;
			}
			else 
			{
				if (curr.isPossible(schedules[i]))
				{
					count++;
					
					curr = schedules[i];
				}
			}
		}
		
		return count;
	}
}

class Schedule implements Comparable<Schedule> {
	private int start;
	private int end;
	
	public Schedule(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	
	// 종료 시간이 작은 순서대로 정렬
	// 종료 시간이 같다면 시작 시간이 작은 순서대로 정렬.
	@Override
	public int compareTo(Schedule compare) {
		// TODO Auto-generated method stub
		if (end == compare.end)
		{
			return start - compare.start;
		}
		
		return end - compare.end;
	}
	
	public boolean isPossible(Schedule compare)
	{
		if (end <= compare.start)
		{
			return true;
		}
		return false;
	}
	
	public int getStart() { return start; }
	public int getEnd() { return end; }
	
	public String println() { return start + " | " + end; }
}
