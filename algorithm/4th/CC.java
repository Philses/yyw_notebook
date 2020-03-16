package Algorithm4th;

import java.util.Arrays;

/**
 * @Time : 2020年3月16日13:36:17
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */
public class CC {
    private int[] id;
    private int count;

    public CC(Graph G){
        id = new int[G.V()];
        count = 0;
        Arrays.fill(id, -1);
        for(int i = 0; i < G.V(); i++){
            if(id[i] == -1){
                dfs(G, i);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v){
        id[v] = count;
        for(int w : G.adj(v)){
            if(id[w] == -1)
                dfs(G, w);
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }
}
