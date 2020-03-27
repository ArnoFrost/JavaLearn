package other;

import edu.princeton.cs.algs4.*;

/**
 * @Author: ArnoFrost
 * @Date: 2019/11/12 18:10
 * @Version 1.0
 */
public class DijkstraTester {
    public static void main(String[] args) {
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(new In(args[0]));  //接受一个输入流和一个起点作为命令行参数
        int s = Integer.parseInt(args[1]);
        DijkstraSP sp = new DijkstraSP(digraph, s);  //从输入流中读取有向图，根据起点计算有向图的最短路径树
        for (int t = 0; t < digraph.V(); t++) {  //打印从指定起点到所有结点的最短路径
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", sp.distTo(t));
            if (sp.hasPathTo(t)) {
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + " ");
                }
            }
            StdOut.println();
        }
    }
}
