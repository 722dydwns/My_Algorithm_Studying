package to_1218_2;
import java.io.*;
import java.util.*;

class Node {
    int num, count;

    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

public class Main {
    static int[] indegree_y;
    static ArrayList<Node>[] list;
    
    public static int[] topologySort(int n) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 1));
        int[] counter = new int[n + 1];
        counter[n] = 1;
 
        while(!q.isEmpty()) {
            Node current = q.poll();
 
            for(int i = 0; i < list[current.num].size(); i++) {
                Node next = list[current.num].get(i);
                counter[next.num] += counter[current.num] * next.count;
                indegree_y[next.num]--;
                if(indegree_y[next.num] == 0) q.offer(new Node(next.num, counter[next.num]));
            }
        }
        return counter;
    }
    //실행메인 
    public static void main(String[] args) throws IOException {
        
        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
 
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
 
        int[] indegree_x = new int[n + 1]; //기본 부품 찾기 용도
        indegree_y = new int[n + 1]; //위상정렬 용도
        for(int i = 0; i < m; i++) {
            String str = bf.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int x = Integer.parseInt(st.nextToken()); //부품번호
            int y = Integer.parseInt(st.nextToken());//먼저 만들어야하는 부품 번호
            int k = Integer.parseInt(st.nextToken());//개수 
            
            list[x].add(new Node(y, k)); //역순으로 담고 
            indegree_x[x]++;//e를 끝으로 하는 진입 배열과 
            indegree_y[y]++;//s를 끝으로 하는 진입 배열 담음 
        }
        //입력 끝
        int[] result = topologySort(n);
        for(int i = 1; i <= n; i++) {
            if(indegree_x[i] == 0) System.out.println(i + " " + result[i]);
        }
    }
}