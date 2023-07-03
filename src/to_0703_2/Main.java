package to_0703_2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 백준 1753번. 최단 경로 구하기 */
class Node implements Comparable<Node>{
	int v;
	int value;
	Node(int v, int value){
		this.v = v;
		this.value = value;
	}
	public int compareTo(Node o) {
		if(this.value > o.value) return 1;
		else return -1;
	}
}

public class Main {
	static int V, E, K;
	static int distance[];
	static boolean visited[];
	static ArrayList<Node> list[];
	static PriorityQueue<Node> Q = new PriorityQueue<Node>();

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		V = kb.nextInt();
		E = kb.nextInt();
		K = kb.nextInt();
		
		//초기화
		distance = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i]= new ArrayList<Node>();
		}
		
		for(int i=0; i<= V; i++) {
			distance[i]= Integer.MAX_VALUE;
		}
		
		//가중치 있는 인접리스트 초기화 
		for(int i=0; i<E; i++) {
			int u = kb.nextInt();
			int a = kb.nextInt();
			int w = kb.nextInt();
			
			list[u].add(new Node(a, w));
		}
		
		//시작 점 처리
		Q.add(new Node(K, 0));
		distance[K] = 0;//시작지점 처리 
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			int cv = cur.v;
			if(visited[cv]) continue;
			visited[cv] = true;
			
			for(int i=0; i<list[cv].size(); i++) {
				Node tmp = list[cv].get(i);
				int nx = tmp.v;
				int val = tmp.value;
				if(distance[nx] > distance[cv]+val) {
					distance[nx]= val + distance[cv];
					Q.add(new Node(nx, distance[nx]));
				}
			}
		}
		
		for(int i=1; i<=V; i++) {
			if(visited[i]) System.out.println(distance[i]);
			else System.out.println("INF");
		}	
	}
}