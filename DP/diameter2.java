import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class diameter2 {

    static int max = 0, maxNode = 1;
    static LinkedList<Integer> adj[];
    public static void addEdge(int source, int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //Graph graph = new Graph(n);
        adj = new LinkedList[n + 1];
        for(int i = 0; i <= n; i++)
            adj[i] = new LinkedList<Integer>();

        String[] ip = new String[n - 1];
        for(int i = 0; i < n - 1; i++){
            ip = br.readLine().split(" ");
            int src = Integer.parseInt(ip[0]);
            int dst = Integer.parseInt(ip[1]);
            addEdge(src, dst);
        }
        // Print the edges
//        for(int i = 1; i <= n; i++){
//            System.out.print(i + " : ");
//            for(Integer x : adj[i])
//                System.out.print(x + ",");
//            System.out.println();
//        }
        boolean visited[] = new boolean[n + 1];
        int farthest = 0;
        for(int i = 1; i <= n; i++){
            dfs(0, i, visited, adj);
        }

        Arrays.fill(visited, false);
        max = 0;
        dfs(0, maxNode, visited, adj);
        System.out.println(max);

    }
    private static void dfs(int h, int node, boolean[] visited, LinkedList<Integer>[] adj) {

        visited[node] = true;
        if(h > max){
            max = h;
            maxNode = node;
        }
        for(Integer neigh : adj[node]){
            if(!visited[neigh]){
                dfs(1 + h, neigh, visited, adj);
            }
        }
    }
}
