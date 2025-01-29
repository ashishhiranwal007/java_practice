package others;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static class Edge {
        int src, dst, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges
        graph[0].add(new Edge(0, 0, 1)); // Self-loop
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));

        // Sort neighbors by destination vertex for consistent BFS ordering
        for (ArrayList<Edge> edges : graph) {
            edges.sort((e1, e2) -> Integer.compare(e1.dst, e2.dst));
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsutil(graph, i, vis);
            }
        }
    }

    public static void dfsutil(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        // visiting the first element true in the graph
        vis[curr] = true;
        // getting the next element or neighbouring element
        for (int i = 0; i < graph[curr].size(); i++) {
            // getting the edge e
            Edge e = graph[curr].get(i);
            if (!vis[e.dst]) {
                dfsutil(graph, e.dst, vis);
            }
        }
    }

    public static boolean detectcycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i =0;i<graph.length;i++){
            if(!vis[i]){
                if(detectcycleutil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectcycleutil(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        vis[curr] = true;
        for(int i =0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dst]){
                if(detectcycleutil(graph, vis, e.dst, curr)){
                    return true;
                }
            }
            else if(e.dst!=par){
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[] =new boolean[graph.length];
        for(int i =1;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                };

            }
        }
        return false;
    }
    
    public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        vis[curr] =true;
        for(int i =0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dst]){
                if(detectCycleUtil(graph, vis, e.dst, curr)){
                    return true;
                }
            }
            else if(e.dst!=par){
                return true;


            }
        }
        return false;
    }
    public static boolean isBarpititeGraph(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for(int i =0;i<color.length;i++){
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0 ;i<graph.length;i++){
            if(color[i] ==-1){
                q.add(i);
                color[i]=0;
            }
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int j=0;j<graph[curr].size();j++){
                    Edge e = graph[curr].get(j);
                    if(e.dst ==-1){
                        int newcolor = color[curr] ==0 ?1:0;
                        color[e.dst] = newcolor;
                        q.add(e.dst);
                    }
                    else if(color[e.dst] == color[curr]){
                        return false;
                    }
                }
             }
        }
        return true;

    }
    public static boolean findpath(ArrayList<Edge> graph[], int src, int dst, boolean vis[]) {
        // if condition for src and destination to check they are same
        if (src == dst) {
            return true;
        }
        // putting the first element in visited array as true;
        vis[src] = true;
        // iterating thorugh the neighbour
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[0].get(i);
            if (!(vis[e.dst]) && findpath(graph, e.dst, dst, vis)) {
                return true;
            }
        }
        return false;

    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsutil(graph, vis, i);
            }
        }
    }

    public static void bfsutil(ArrayList<Edge>[] graph, boolean vis[], int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i); // Start BFS from vertex 0
        vis[i] = true; // Mark the starting node as vis

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); // Print current vertex

            // Add all unvisited neighbors to the queue
            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);
                if (!vis[e.dst]) { // Check if the neighbor has been vis
                    q.add(e.dst);
                    vis[e.dst] = true; // Mark it as vis when adding to the queue
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println("Following is Breadth First Traversal (starting from vertex 0):");
        bfs(graph);
    }
}
