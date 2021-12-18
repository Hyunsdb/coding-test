import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] color = new int[1001][3];
        int[][]dp = new int[1001][3];

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = color[0][0];
        dp[0][1] = color[0][1];
        dp[0][2] = color[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1]+color[i][0],dp[i-1][2]+color[i][0]);
            dp[i][1] = Math.min(dp[i-1][0]+color[i][1],dp[i-1][2]+color[i][1]);
            dp[i][2] = Math.min(dp[i-1][1]+color[i][2],dp[i-1][0]+color[i][2]);
        }

        System.out.println(Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2])));
    }
}
