import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
/*
link : https://cses.fi/problemset/task/1674
 */
public class subordinates {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n + 1];
        String[] str = new String[n];
        str = br.readLine().split(" ");
        for(int i = 0; i < n - 1; i++)
            arr[i] = Integer.parseInt(str[i]);

        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        tree.put(1 , new ArrayList<Integer>());
        for(int i = 0; i < n - 1; i++){
            List<Integer> temp = new ArrayList<>();
            if(tree.containsKey(arr[i])){
                temp = tree.get(arr[i]);
                temp.add(i + 2);
                tree.put(arr[i], temp);
            }
            else{
                temp.add(i + 2);
                tree.put(arr[i], temp);
            }
        }

        //System.out.println("Tree : " + tree);
        StringBuilder res = new StringBuilder("");
        for(int i = 1; i <= n; i++){
           // System.out.print(dfs(i, tree, dp) + " ");
            res.append(dfs(i, tree, dp) + " ");
        }
        System.out.println(res);






    }

    private static int dfs(int node, HashMap<Integer, List<Integer>> tree, int[] dp) {

        if(!tree.containsKey(node))
            return 0;
        if(dp[node] != 0) return dp[node];

        int res = 0;
        for(int neighbour: tree.get(node)){
            res += 1 + dfs(neighbour, tree, dp);
        }

        return dp[node] = res;
    }
}
