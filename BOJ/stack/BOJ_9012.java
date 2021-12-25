import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- != 0) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean check = true;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    //안비었으면
                    if(!stack.empty()) stack.pop();
                    //비었으면
                    else {
                        check=false;
                        break;
                    }
                }
            }
            //비었으면
            if(check && stack.empty()) sb.append("YES").append("\n");
            //안비었으면
            else sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }
}
