import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(0,0);
        System.out.print(sb);
    }

    static void dfs(int depth,int idx){
        if(depth==M){
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=idx;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                arr[depth] = i+1;
                dfs(depth + 1, i+1);
                visit[i] = false;
            }
        }
    }
}
