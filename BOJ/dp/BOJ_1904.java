import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[1000001];
        int N = Integer.parseInt(br.readLine());

        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 15746;
        }

        sb.append(dp[N]);
        System.out.println(sb);
    }
}
