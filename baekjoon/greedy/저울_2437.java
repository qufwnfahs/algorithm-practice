package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 직관적으론 모든 조합을 구한 상태에서 조합에 포함되지 않는 가장 작은 자연수를 구해야 하는 문제로 인식했다.
// 그러나 완전 탐색으로는 N 제곱이 걸렸고 시간 초과를 피하지 못했다.

// 조합을 모두 구하지 않고 미리 최소값을 구할 수 있을 지에 대해 생각해보았다.
// 무게추를 이용해 무게를 구하는 것이기 때문에 무게와 비슷한 가장 큰 추부터 음수가 나오지 않게 계속 빼 나가면
// 최소 무게를 구할 수 있을 거라고 생각하고 이 문제를 풀었다.
// 그러나 시간이 너무 오래 걸렸다. 이 방법도 N 제곱에 가까울 테니 운 좋게 통과했다고 느껴진다.

// 그럼 더 효율적인 알고리즘은 뭘까 ?

// 분할해서 문제를 쪼개어 보면 답이 나온 문제였다.
// 1 2 3 10을 놓고 보자
// 처음은 1이므로 1은 무게추로 잴 수 있다.
// 그 다음은 2이다. 2은 무게추로 잴 수 있고 또한 3도 무게추로 잴 수 있다. (1과 2가 있으므로)
// 그 다음은 3이다. 3은 무게추로 잴 수 있고 6도 무게추로 잴 수 있다.
// 자 여기서 재밌는 사실을 알 수 있다.
// 1과 2와 3의 무게추가 있으면 1부터 6까지의 모든 무게를 잴 수 있다.
// 1, 2, 3, 4(3+1), 5(3+2), 6(3+2+1)

// 1, 1, 2, 3, 4, 10을 놓고 보자
// 1
// 1 = 2(1, 2)
// 2 = 4(1, 2, 1+2, 1+1+2)
// 3 = 7(1, 2, 1+2, 1+1+2, 2+3, 1+2+3, 1+1+2+3)

// 1,2,4,10
// 1
// 2 = 3(1, 2, 1+2)
// 4 = 7(1, 2, 1+2, 4, 4+1, 4+2, 4+2+1)

// 여기서 재밌는 사실을 하나 알 수 있다.
// 3은 결국 3을 만들 수 있는 모든 경우의 수가 존재한고
// 3이 있으니 4를 합쳐 7까지 모든 경우의 수가 존재하게 된다.
// 그러나 3에서 5를 합쳤다면 8까지 모든 경우의 수가 존재하지는 않는다. 5, 1+5 = 6, 2+5 = 7, 3+5 = 8, 결국 4의 경우의 수가 비게 된다.

public class 저울_2437 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] weights = new int[n];
	
		init(weights, br);
		
		Arrays.sort(weights);
		
		int result = findMinWeight(weights);
		
		System.out.println(result);
	}
	
	public static int findMinWeight(int[] weights)
	{
		int sum = 0;
		
		for (int i = 0; i < weights.length; i++)
		{
			if (weights[i] > sum + 1)
			{
				break;
			}
			sum += weights[i];
		}
		
		return sum+1;
	}
	
	private static void init(int[] weights, BufferedReader br) throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < weights.length; i++)
		{
			weights[i] = Integer.parseInt(st.nextToken());
		}
	}
}
