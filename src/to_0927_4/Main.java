package to_0927_4;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
     
        int n = kb.nextInt();
        int total_length = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String tmp = kb.next();
            for (int j = 0; j < n; j++) {
                if (tmp.charAt(j) == '0')
                    continue;
                else{
                    int t = toLength(tmp.charAt(j));
                    total_length += t;
                    if(i!=j&&t!=0) pq.add(new Edge(i, j, toLength(tmp.charAt(j))));
                }
            }
        }
        // 이제 mst 를 찾자.
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        
        int mst_length=0;
        int used=0;
        while (!pq.isEmpty()) {
            Edge now_edge = pq.poll();
            if(find(now_edge.st)!=find(now_edge.end)){
                union(now_edge.st, now_edge.end);
                mst_length+=now_edge.w;
                used++;
            }
        }
        if(used==n-1)
            System.out.println(total_length-mst_length);
        else System.out.println(-1);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    static int find(int a) {
        if (a == parent[a])
            return a;
        else return parent[a] = find(parent[a]);
    }

    static int toLength(char ele) {
        if (ele >= 'a' && ele <= 'z') {
            return ele - 'a' + 1;
        } else {
            return ele - 'A' + 27;
        }
    }

    static class Edge implements Comparable<Edge> {
        int st;
        int end;
        int w;

        public Edge(int s, int e, int w) {
            this.st = s;
            this.end = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge v) {
            return this.w > v.w ? 1 : -1;
        }
    }
}
