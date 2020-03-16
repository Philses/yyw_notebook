package Algorithm4th;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Time : 2020年3月16日13:16:52
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */
public class BreadFirstPaths {
    private boolean[] marked;
    private int[] pathTo;
    private int s;

    public BreadFirstPaths(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            int v = queue.remove();
            for(int w : G.adj(v))
                if(!marked[w]){
                    marked[w] = true;
                    pathTo[w] = v;
                    queue.add(w);
                }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> path(int v){
        if(!marked[v])
            return null;
        Stack<Integer> stack = new Stack<>();
        for(int x = v; x != s; x = pathTo[x])
            stack.push(x);
        stack.push(s);
        return stack;
    }
}
