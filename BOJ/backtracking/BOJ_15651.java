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

            dfs(0);
            System.out.print(sb);
        }

        static void dfs(int depth){
            if (depth == M) {
                for (int num : arr) {
                    sb.append(num + " ");
                }
                sb.append("\n");
            return;
        }


        for(int i=0;i<N;i++){
                arr[depth]=i+1;
                visit[i]=true;
                dfs(depth+1);
                visit[i]=false;
        }
    }
}