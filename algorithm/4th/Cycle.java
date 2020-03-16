package Algorithm4th;

/**
 * @Time : 2020年3月16日13:58:04
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 检查无向图中是否成环
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++){
            if(hasCycle)
                break;
            if(!marked[v])
                dfs(G, v, -1);
        }
    }

    private void dfs(Graph G, int v, int pre){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(marked[w]){
                if(w != pre){ // 相邻点中有已经访问过的，且不是到达v的上一个点，说明出现了环。
                    hasCycle = true;
                    return;
                }
            } else {
                dfs(G, w, v);
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }
}
