import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int N;
    static int[] dx = {0,0,-1,1};//상하좌우
    static int[] dy = {1,-1,0,0};
    static int cnt = 0;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j]=str.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==1 && !visit[i][j]){
                    dfs(i,j);
                    //bfs(i,j);
                    result.add(cnt);
                    cnt=0;
                }
            }
        }
        Collections.sort(result);
        sb.append(result.size()+"\n");
        for (Integer val : result) {
            sb.append(val+"\n");
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y){
        visit[x][y]=true;
        cnt++;

        for(int i=0;i<4;i++){
            int nxtx = dx[i]+x;
            int nxty = dy[i]+y;

            if(nxtx<0 || nxty<0 || nxtx>=N || nxty>=N) continue;
            if(!visit[nxtx][nxty] && arr[nxtx][nxty]==1){
                visit[nxtx][nxty]=true;
                dfs(nxtx,nxty);
            }
        }
    }

    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        //

        while(!q.isEmpty()){
            Point cur = q.poll();
            visit[cur.x][cur.y]=true;
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nxtx = dx[i] + cur.x;
                int nxty = dy[i] + cur.y;

                if (nxtx < 0 || nxty < 0 || nxtx >= N || nxty >= N) continue;
                if (!visit[nxtx][nxty] && arr[nxtx][nxty] == 1) {
                    visit[nxtx][nxty] = true;
                    q.offer(new Point(nxtx, nxty));
                }
            }
        }

    }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
