import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] cnt = new int[8001];

        int sum = 0; //평균 구하기 위해
        int mode = 0; //최빈값

        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i]=tmp;
            cnt[tmp+4000]++;
            sum+=tmp;
        }

        Arrays.sort(arr);


        //'두 번째' 작은 값인지 확인하기 위해
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<8001;i++){
            if(cnt[i]==0) continue;

            //첫번째 작은 값
            if(cnt[i]>max){
                max=cnt[i];
                mode=i-4000;
                flag=true;
            }
            //두번째 작은 값
            else if(flag && max==cnt[i]) {
                mode = i - 4000;
                flag=false;
            }
        }

        System.out.println((int) Math.round((double) sum / N));
        System.out.println(arr[N/2]);
        System.out.println(mode);
        System.out.println(arr[N-1]-arr[0]);
    }
}
