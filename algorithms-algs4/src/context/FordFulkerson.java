package src.context;

public class FordFulkerson {
	private boolean[] marked;// 在剩余网络中是否存在从S到V的路径？
	private FlowEdge[] edgeTo;// s到v的最短路径上的最后一条边
	private double value;// 当前的最大流量

	private boolean hasAugmentPath(FlowNetwork G, int s, int t) {
		marked = new boolean[G.V()];// 标记路径已知的顶点
		edgeTo = new FlowEdge[G.V()];// 路径上的最后一条边
		Queue<Integer> queue = new Queue<Integer>();
		
		marked[s] = true;// 标记起点
		queue.enqueue(s);// 将该起点入列
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for (FlowEdge e : G.adj(v)) {
				int w = e.other(v);
				if (e.residualCapacityTo(w) > 0 && !marked[w]) {
					edgeTo[w] = e;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
		return marked[t];
	}

	public FordFulkerson(FlowNetwork G, int s, int t) {
		// 找出从s到t的流量网络中的最大流量配置
		while (hasAugmentPath(G, s, t)) {
			double bottle = Double.POSITIVE_INFINITY;
			for (int v = t; v != s; v = edgeTo[v].other(v))
				bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
			for (int v = t; v != s; v = edgeTo[v].other(v))
				edgeTo[v].addResidualFlowTo(v, bottle);
			value += bottle;
		}
	}

	public double value() {
		return value;
	}

	public boolean inCut(int v) {
		return marked[v];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowNetwork G = new FlowNetwork(new In(args[0]));
		int s = 0, t = G.V() - 1;
		FordFulkerson maxflow = new FordFulkerson(G, s, t);
		System.out.println("Max flow from " + s + " to " + t);
		for (int v = 0; v < G.V(); v++) {
			for (FlowEdge e : G.adj(v))
				if ((v == e.from()) && e.flow() > 0)
					System.out.println("  " + e);
		}
		System.out.println("Max flow value" + maxflow);
	}

}
