package context;

public class FlowEdge {

	private final int v;// 边的起点
	private final int w;// 边的终点
	private final double capacity;// 容量
	private double flow;// 流量

	public FlowEdge(int v, int w, double capacity) {
		// TODO Auto-generated constructor stub
		this.flow = 0.0;
		this.capacity = capacity;
		this.v = v;
		this.w = w;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public double capacity() {
		return capacity;
	}

	public double flow() {
		return flow;
	}

	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new IllegalArgumentException("Illegal endpoint");
	}

	public double residualCapacityTo(int vertex) {
		if (vertex == v)
			return flow;
		else if (vertex == w)
			return capacity - flow;
		else
			throw new RuntimeException("Illegal edge");
	}

	// 将vertex的流量增加delta
	public double addResidualFlowTo(int vertex, double delta) {
		if (vertex == v)
			return flow -= delta;
		else if (vertex == w)
			return flow += delta;
		else
			throw new RuntimeException("Inconsistent edge");
	}

	public String toString() {
		return String.format("%d->% %.2f %.2f", v, w, capacity, flow);
	}
}
