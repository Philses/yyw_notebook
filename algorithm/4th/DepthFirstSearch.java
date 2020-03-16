package Algorithm4th;

/**
 * @Time : 2020年3月16日12:16:20
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 无向图的深度优先搜索
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s){
        count = 0;
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int s){
        count++;
        marked[s] = true;
        for(int v : G.adj(s)){
            if(!marked[v]){
                dfs(G, v);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public int count(){
        return count;
    }
}
