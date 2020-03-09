package Algorithm4th;

import java.util.Iterator;

/**
 * @Time : 2020年3月9日17:29:20
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 复习无向图:无向图的实现 链接表数组
 */
public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] graph;
    public Graph(int V){
        this.V = V;
        graph = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i++)
            graph[i] = new Bag<>();
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v, int w){
        E++;
        graph[v].add(w);
        graph[w].add(v);
    }

    Iterable<Integer> adj(int v){
        return graph[v];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(V + " vertices, " + E + " edges\n");
        for(int v = 0; v < V; v++){
            sb.append(v + ": ");
            for(int w : adj(v))
                sb.append(w + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public int degree(int v){
        int count = 0;
        for(int w : adj(v))
            count++;
        return count;
    }

    public int maxDegree(){
        int res = 0;
        for(int v = 0; v < V; v++)
            res = Math.max(res, degree(v));
        return res;
    }

    public double aveDegree(){
        return 2.0 * E() / V();
    }

    public int numberOfSelfLoop(){
        int count = 0;
        for(int v = 0; v < V; v++){
            for(int w : adj(v))
                if(w == v)
                    count++;
        }
        return count / 2;
    }
}
