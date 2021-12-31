import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


//최소힙
//부모가 자식노드보다 항상 작음
class MinHeap{
    private ArrayList<Integer> heap;

    public MinHeap(){
        heap = new ArrayList<Integer>();
        //첫번째 index인 0은 사용되지 않음(구현을 쉽게 하기 위해)
        heap.add(0);
    }


    //맨 밑에 넣었다가, 위로 끌어올림
    public void insert(int data){
        heap.add(data);
        int position = heap.size()-1;

        while(position>1 && heap.get(position/2)>heap.get(position)){
            int tmp = heap.get(position/2);
            heap.set(position,tmp);
            heap.set(position/2,data);

            position/=2;
        }
    }


    //삭제
    //가장 마지막 노드를 root에 올렸다가 끌어내림
    public int remove(){
        if(heap.size()-1 ==0) return 0;

        int removeData = heap.get(1);

        heap.set(1,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int position = 1;


        //범위 안에서
        while(position*2 < heap.size()){

            //왼쪽 자식
            int minPosition = position*2;
            int min = heap.get(minPosition);

            //오른쪽 자식이 더 작으면 교환
            if(minPosition+1 <= heap.size()-1 && min > heap.get(minPosition+1)){
                minPosition++;
                min = heap.get(minPosition);
            }

            //현재 자식노드의 값이 더 크면 break
            if(min>heap.get(position)) break;

            int tmp = heap.get(position);
            heap.set(position,heap.get(minPosition));
            heap.set(minPosition,tmp);
            position = minPosition;
        }

        return removeData;
    }

}


public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        MinHeap heap = new MinHeap();
        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp==0){
                System.out.println(heap.remove());
            }
            else{
                heap.insert(tmp);
            }
        }
    }
}
