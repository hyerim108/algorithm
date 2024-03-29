import java.util.*;
import java.io.*;
public class Main
{
    static int max = 100000;
    static int min = Integer.MAX_VALUE;
    static int N,M;
    static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    visited = new boolean[max + 1];
	    bfs();
	    System.out.println(min);
	}
	public static void bfs(){
	    Queue<Node> queue = new LinkedList<>();
	    queue.add(new Node(N,0));
	    
	    while(!queue.isEmpty()){
	        Node node = queue.poll();
	        visited[node.x] = true;
	        
	        if (node.x == M) min = Math.min(min, node.time);
	        
	        if (node.x * 2 <= max && visited[node.x * 2] == false) queue.add(new Node(node.x * 2, node.time));
	        if (node.x + 1 <= max && visited[node.x + 1] == false) queue.add(new Node(node.x + 1, node.time + 1));
	        if (node.x - 1 >= 0 && visited[node.x - 1] == false) queue.add(new Node(node.x -1,node.time+1));
	    }
	    
	}
	public static class Node{
	    int x;
	    int time;
	    public Node(int x, int time){
	        this.x = x;
	        this.time = time;
	    }
	}
}
