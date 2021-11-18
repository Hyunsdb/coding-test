import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
        }

        int result=64;
        for(int n=0;n<N-7;n++){
            for(int m=0;m<M-7;m++){
                int cnt = find(n,m,arr);
                cnt = Math.min(cnt,64-cnt);
                result = Math.min(result,cnt);
            }
        }
        System.out.println(result);

	}

	public static int find(int n, int m,char[][] arr){
        int cnt=0;
        for(int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0 && arr[n + i][m + j] == 'B') cnt++;
                    else if (j % 2 == 1 && arr[n + i][m + j] == 'W') cnt++;
                } else {
                    if (j % 2 == 0 && arr[n + i][m + j] == 'W') cnt++;
                    else if (j % 2 == 1 && arr[n + i][m + j] == 'B') cnt++;
                }
            }
        }
        return cnt;
    }
}
