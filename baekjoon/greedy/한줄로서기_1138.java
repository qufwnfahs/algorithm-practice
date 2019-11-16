package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 키가 1인 사람부터 왼쪽에 자기보다 키가 큰 사람이 몇 명있는지를 나타낸다.
// 이 문제를 거꾸로 접근한다면
// 역으로 줄서기를 한다면 현재 들어갈 사람이 들고 있는 값은 이미 줄을 서 있는 사람의 명 수에 따라서 자신이 몇 번쨰로 서야 하는지 알 수 있는 값이 된다.
// 왜냐하면 현재 들어갈 사람보다 키가 큰 사람은 이미 들어가 있는 사람들의 명 수가 되는 것이기 때문이다.

// 여기까지 도달한 것은 다른 사람의 코드를 복기해서 였지만
// 애초에 이 문제의 key 접근은 잘하였다. 이 문제의 key는 '왼쪽에 자기보다 큰 사람이 몇 명있는지를 나타내주고 있다'라는 것이라고 생각한다.

// 앞에서부터 줄을 세우려고 하여 들어갈 index를 계산해주느라 결과를 저장할 1차원 배열 'result'와 남은 방의 상태를 나타내는 ArrayList 'remainIndexes'를 사용하였지만
// 위에 원리를 통해서 뒤에서 부터 줄을 세우면 현재 줄을 서있는 명 수를 나타내는 int형 size를 통해 ArrayList에 알맞게 insert만 하면 이 문제는 해결된다.

// 작은 순으로 넣으면 현재 남은 방을 봐야했지만
// 큰 순으로 넣으면 size만 비교해서 그 index 값으로 넣을 수 있다.
// 키가 큰 사람을 나타내니까 키가 큰 순서대로 집어 넣는게 더 정확하고 직관적인 것 같다.

// -------------------- 성능 개선 ------------------------
// 큰 수를 나타내므로 가장 큰 수를 먼저 넣고
// 그 다음 수는 들어간 수보다는 작으므로 그 값이 index 값으로 순전히 직결된다.
// 아마 LinkedList를 이용해서 풀면 더 빠르지 않을까?

// 속도는 비슷했다.삭제가 없어서 그런듯 오히려 ArrayList가 메모리를 덜 잡아 먹는다.
// LinkedList는 순차 접근만이 가능하기 때문에 index를 이용하여 자료를 검색하는 Application에는 적합하지 않다.

public class 한줄로서기_1138 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numOfBig = new int[n];
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		init(numOfBig, br);
		
		doLining(result, numOfBig, n);
		
		for (int i : result)
		{
			System.out.print(i + " ");
		}
	}
	
	private static void doLining(ArrayList<Integer> result, int[] numOfBig, int n)
	{
		result.add(n);
		
		int size = 1;
		
		for (int i = n-2; i >= 0; i--)
		{
			if (size == numOfBig[i])
			{
				result.add(i+1);
			}
			else
			{
				result.add(numOfBig[i], i+1);
			}
			
			size++;
		}
	}
	
	private static void init(int[] numOfBig, BufferedReader br) throws Exception
	{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < numOfBig.length; i++)
		{
			numOfBig[i] = Integer.parseInt(st.nextToken());
		}
	}
}