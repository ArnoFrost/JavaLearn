package other;

import edu.princeton.cs.algs4.*;

/**
 * @Author: ArnoFrost
 * @Date: 2019/11/12 17:26
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        /Users/arno/Desktop/tinyEWD.txt
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        int s = Integer.parseInt(args[1]);

        // compute shortest paths
        DijkstraSP sp = new DijkstraSP(G, s);


        // print shortest path
        for (int t = 0; t < G.V(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            } else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }

    }
}
