import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,V;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];

        for(int i=0;i<=N;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        for(int i=1;i<=N;i++){
            Collections.sort(arr.get(i));
        }


        dfs(V);
        Arrays.fill(visit, false);
        sb.append("\n");
        bfs();

        System.out.print(sb);
    }

    public static void dfs(int v){
        sb.append(v + " ");
        visit[v]=true;

        for (int nxt : arr.get(v)) {
            if(!visit[nxt]){
                visit[nxt]=true;
                dfs(nxt);
            }
        }
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        q.offer(V);
        visit[V]=true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur + " ");

            for(int nxt : arr.get(cur)){
                if(!visit[nxt]){
                    visit[nxt]=true;
                    q.offer(nxt);
                }
            }

        }
    }
}
