package Algorithm4th;

import java.util.Stack;

/**
 * @Time : 2020年3月16日12:46:15
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 无向图中的单点路径问题
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] pathTo; // pathTo[v] = w 的意义是 v这个点是由w到达的
    private int s;
    public DepthFirstPaths(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int s){
        marked[s] = true;
        for(int v : G.adj(s)){
            if(!marked[v]){
                pathTo[v] = s;
                dfs(G, v);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!marked[v])
            return null;
        Stack<Integer> path = new Stack<>();
        while(v != s){
            path.push(v);
            v = pathTo[v];
        }
        path.push(s);
        return path;
    }
}
