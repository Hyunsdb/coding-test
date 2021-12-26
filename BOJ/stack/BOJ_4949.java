import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean check=true;

            if(str.equals(".")) break;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                //여는 괄호면
                if (c == '[' || c == '(') {
                    //push
                    stack.push(c);
                }
                //닫는 괄호면
                else if (c == ']' || c == ')') {
                    //stack 비어있으면
                    if (stack.isEmpty()) {
                        check=false;
                        break;
                    } else {
                        char tmp = stack.pop();
                        //닫는 괄호가 stack에 있는 괄호랑 같지 않으면
                        if ((tmp == '[' && c == ']') || (tmp == '(' && c == ')')) {
                            continue;
                        }
                        else{
                            check=false;
                            break;
                        }
                    }
                }
            }
            if (check && stack.isEmpty()) {
                sb.append("yes\n");
            }
            else {
                sb.append("no\n");
            }

        }

        System.out.print(sb);
    }
}
