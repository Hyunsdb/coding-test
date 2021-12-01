import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();

    	int N = Integer.parseInt(br.readLine());

    	Person[] p = new Person[N];
    	for(int i=0;i<N;i++){
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		int age = Integer.parseInt(st.nextToken());
    		String name = st.nextToken();
    		p[i]=new Person(age,name);
		}

    	Arrays.sort(p, (Person p1, Person p2)->{
    		return p1.age-p2.age;
		});

    	for(int i=0;i<N;i++){
    		sb.append(p[i]);
		}
		System.out.print(sb);
    }

    public static class Person{
    	int age;
    	String name;

    	public Person(int age,String name){
    		this.age = age;
    		this.name = name;
		}

		@Override
		public String toString(){
    		return age + " " + name + "\n";
		}
	}
}
