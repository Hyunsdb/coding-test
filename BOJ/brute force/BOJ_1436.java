import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 665;
        while(cnt!=N){
            int tmp = ++num;
            while(tmp>=666){
                if(tmp%1000==666){
                    cnt++;
                    break;
                }
                tmp/=10;
            }
        }

        System.out.println(num);
    }
}
