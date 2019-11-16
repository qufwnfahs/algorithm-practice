package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// row와 col의 값이 1 ~ 2,000,000,000이기에 행렬로 푸는 것은 아니라고 생각했다.
// 병든 나이트는 위쪽과 아래쪽으로도 이동하긴 하지만, 결국 오른쪽으로만 이동하기 때문에 문제의 key는 col의 값이 몇으로 주어지냐라고 생각했다.
// 그러나 위쪽와 아래쪽, 즉 y축으로도 이동을 하기 때문에 row의 값에 대한 영향을 받을 수 밖에 없었다. 단지 row가 1이냐 2이냐 3 이상이냐로 나눌 수 있었다는 점.
// 조건 3개 정도면 최적화된 조건이라 생각할만 했을 것이다.

// 처음엔 row와 col을 둘다 고려하면서 로직을 구현했지만 row를 기준으로 조건을 정했다면 더 간결하게 짤 수 있었다고 생각한다.
// 그리고 한 가지 더 생각 못했던건 row가 2일 때 col이 7보다 작을 경우 col이 3~4일 땐 이동 횟수가 2, 5~6일 때는 이동 횟수가 3이므로 col 값에 1을 더해서 2로 나눠주면 그것이 이동 횟수가 된다라는 점.
// row가 2일 때는 최대가 4를 넘지 못하므로 Math.min을 이용해서 조건식을 간단히 할 수 있었던 점을 생각하지 못했었다.

// 최대가 A를 넘지 못하는 조건에선 Math.min이 유용하다는 점, 어느 조건이 1을 gap으로 두고 같은 값으로 수렴한다면 1 또는 -1을 해서 2로 나눠주면 된다는 점을 기억하고 넘어가자.

public class 병든나이트_1783 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int result = findMaxMoveCount(row, col);
		
		System.out.println(result);
	}
	
	private static int findMaxMoveCount(int row, int col)
	{
		int result = 0;
		
		if (row == 1)
		{
			result = 1;
		}
		else if (row == 2)
		{
			result = Math.min(4, (col+1) / 2);
		}
		else
		{
			if (col >= 7)
			{
				result = col - 2;
			}
			else
			{
				result = Math.min(4, col);
			}
		}
		return result;
	}
}
