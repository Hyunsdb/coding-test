import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //중복 방지 위해
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i]=n;
            tmp[i]=n;
        }

        Arrays.sort(tmp);

        int cnt=0;

        for (int i = 0; i < tmp.length; i++) {
            //오름차순으로 정렬된 tmp 배열 보면서 확인
            //아래코드 == if(!map.containsKey(tmp[i])) : map에 tmp[i]값이 없으면
            if(!map.containsKey(tmp[i])) {
                //map에 push해줌
                map.put(tmp[i], cnt++);
            }
        }

        for(int i=0;i<N;i++){
            sb.append(map.get(arr[i]) + " ");
        }
        System.out.println(sb);
    }
}
