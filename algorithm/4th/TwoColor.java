package Algorithm4th;

/**
 * @Time : 2020年3月16日14:12:07
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 一个无向图是否为二分图
 */
public class TwoColor {
    private boolean[] marked;
    private boolean isTwoColor;
    private boolean[] color; // 表示某个点的颜色，红色为true

    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        isTwoColor = true;
        for(int v = 0; v < G.V(); v++){
            if(!isTwoColor)
                break;
            if(!marked[v]){
                color[v] = true;
                dfs(G, v);
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                color[w] = !color[v]; // 将相邻的点涂成相反的颜色，继续搜索
                dfs(G, w);
            }
            else if(color[w] == color[v]){ // 相邻两个点的颜色相同，说明不是二分图，没必要继续搜索。
                isTwoColor = false;
                return;
            }
        }
    }

    public boolean isTwoColor(){
        return isTwoColor;
    }
}
