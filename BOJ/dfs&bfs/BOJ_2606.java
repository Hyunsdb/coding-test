import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int N,M;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visit = new boolean[N+1];
        for(int i=0;i<=N;i++){
            arr.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        bfs(1);

        System.out.print(--cnt);
    }

    static void dfs(int v){
        visit[v]=true;
        ++cnt;

        for(int i=0;i<arr.get(v).size();i++){
            int nxt = arr.get(v).get(i);
            if(!visit[nxt]){
                visit[nxt]=true;
                dfs(nxt);
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v]=true;
        cnt++;

        while(!q.isEmpty()){
            int cur = q.poll();
            
            visit[cur]=true;

            for(int i=0;i<arr.get(cur).size();i++){
                int nxt = arr.get(cur).get(i);

                if(!visit[nxt]){
                    visit[nxt]=true;
                    q.offer(nxt);
                    cnt++;
                }
            }
        }
    }
}
