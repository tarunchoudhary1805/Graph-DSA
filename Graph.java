import java.util.*;

public class Graph {
    static ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
    int v;

    public Graph(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            a.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int src, int dest) {
        a.get(src).add(dest);
        a.get(dest).add(src);
    }

    public static void dfs(int src, boolean[] visit){
        visit[src] = true;
        System.out.print(src + " ");

        for(Integer neighbour : a.get(src)){
            if(!visit[neighbour]){
                dfs(neighbour,visit);
            }
        }
    } 
    public static void main(String [] args){
        int v = 5;
        Graph graph = new Graph(v);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(1, 4);

        boolean [] visit = new boolean[v];
        dfs(0,visit);
    }
}