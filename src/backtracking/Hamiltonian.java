package backtracking;

public class Hamiltonian {

    /**
     * Q1 - Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
     * Q2 - Hamiltonian cycle - Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in the graph) from the last vertex to the first vertex of the Hamiltonian Path. 
     */

    private static int V;
    private static int[] path;
    private static int[] visited;
    public static void main(String[] args) {
        // graph contains the adjacent link between vertex. eg. between 0 and 1 vertex link is present if graph[0][1]=1;
        int graph1[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
        };
        hamCycle(graph1);
    }

    static void hamCycle(int graph[][]) {
        //number of vertex are depends on size of graph.
        V = graph.length;
        // we are going to create path which have hamilotonial cycle.
        path = new int[V];
        //keeping visted vertex because in cycle each vetex should be visited once.
        visited = new int[V];
        //making path values -1 default why? to maintain backtrack.
        for(int i=0;i<V;i++) {
            path[i]=-1;
        }
        //start cycle from 0 vertex.
        path[0]=0;
        //mark vertex 0 as 1 means visted.
        visited[0] = 1;
        // call the recursive function.
        if(!hamCycleUtil(graph,path,1)) {
            System.out.println("Cycle does not exists");
            return;
        }
        for (int i = 0; i < V; i++)
            System.out.print(" " + path[i] + " ");
        System.out.println(path[0]);
    }

    static boolean hamCycleUtil(int[][] graph, int[] path, int position) {
        //check if we are done with all vertex now base condition is if there is a cycle between last vertex 
        // to first vertex then only it is cycle;
        if(position == V) {
            if(graph[path[position-1]][path[0]]==1) {
                return true;
            }
            else 
                return false;
        }
        //start forming path from vertex 1;
        for(int i=1;i<V;i++) {
            //checking link is safe between last vertex in path with current vertex.
            if(isSafe(i,graph,path,position)) {
                //if safe then add to path
                path[position]=i;
                // it is a recursive fucntion where we build the path hence looking for next vertex in path.
                if(hamCycleUtil(graph, path, position+1)) {
                    return true;
                }
                //above if call the fucntion recursive hence
                // if next position is not safe then backtracking happen here.
                path[position]=-1;
            }
        }
        return false;
    }

    static boolean isSafe(int index, int[][] graph, int[] path, int position) {
        // check the vertex has link.
        if(graph[path[position-1]][index] == 0) {
            return false;
        }
        //check if already part of path.
        if(visited[index]==1) {
            return false;
        }
        return true;
    }

    
}
