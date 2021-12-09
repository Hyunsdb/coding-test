import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[45];

        arr[0]=0;
        arr[1]=1;

        for(int i=2;i<45;i++){
            arr[i]=arr[i-2]+arr[i-1];
        }

        for(int i=0;i<N;i++) {
            int req = Integer.parseInt(br.readLine());
            if (req == 0)
                System.out.println("1 0");
            else if (req == 1)
                System.out.println("0 1");
            else {
                System.out.println(arr[req - 1] + " " + arr[req]);
            }
        }

    }
}
