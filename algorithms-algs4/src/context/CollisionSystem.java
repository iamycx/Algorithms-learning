package src.context;

public class CollisionSystem {

	public class Event implements Comparable<Event> {
		private final double time;
		private final Particle a, b;
		private final int countA, countB;

		public Event(double t, Particle a, Particle b) {
			// TODO Auto-generated constructor stub
			this.time = t;
			this.a = a;
			this.b = b;
			if (a != null)
				countA = a.count();
			else {
				countA = -1;
			}
			if (b != null)
				countB = b.count();
			else {
				countB = -1;
			}
		}

		public int compareTo(Event that) {
			if (this.time < that.time)
				return -1;
			else if (this.time > that.time)
				return +1;
			else
				return 0;
		}

		public boolean isValid() {
			if (a != null && a.count() != countA)
				return false;
			if (b != null && b.count() != countB)
				return false;
			return true;
		}
	}

	private MinPQ<Event> pq;
	private double t = 0.0;
	private Particle[] particles;

	public CollisionSystem(Particle[] particles) {
		// TODO Auto-generated constructor stub
		this.particles = particles;
	}

	private void predictCollisions(Particle a, double limit) {
		if (a == null)
			return;
		for (int i = 0; i < particles.length; i++) {
			double dt = a.timeToHit(particles[i]);
			if (t + dt <= limit) {
				pq.insert(new Event(t + dt, a, particles[i]));
			}
			double dtX = a.timeToHitVerticalWall();
			if (t + dtX <= limit) {
				pq.insert(new Event(t + dtX, a, null));
			}
			double dtY = a.timeToHitHorizontalWall();
			if (t + dtY <= limit) {
				pq.insert(new Event(t + dtY, null, a));
			}
		}

	}

	public void redraw(double limit, double Hz) {
		StdDraw.clear();
		for (int i = 0; i < particles.length; i++)
			particles[i].draw();
		StdDraw.show(20);
		if (t < limit)
			pq.insert(new Event(t + 1.0 / Hz, null, null));
	}

	public void simulate(double limit, double Hz) {
		// initialize PQ with collision events and redraw event
		pq = new MinPQ<Event>();
		for (int i = 0; i < particles.length; i++) {
			predictCollisions(particles[i], limit);
		}
		pq.insert(new Event(0, null, null)); // redraw event

		// the main event-driven simulation loop
		while (!pq.isEmpty()) {

			// get impending event, discard if invalidated
			Event e = pq.delMin();
			if (!e.isValid())
				continue;
			Particle a = e.a;
			Particle b = e.b;

			// physical collision, so update positions, and then simulation
			// clock
			for (int i = 0; i < particles.length; i++)
				particles[i].move(e.time - t);
			t = e.time;

			// process event
			if (a != null && b != null)
				a.bounceOff(b); // particle-particle collision
			else if (a != null && b == null)
				a.bounceOffVerticalWall(); // particle-wall collision
			else if (a == null && b != null)
				b.bounceOffHorizontalWall(); // particle-wall collision
			else if (a == null && b == null)
				redraw(limit, Hz); // redraw event

			// update the priority queue with new collisions involving a or b
			predictCollisions(a, limit);
			predictCollisions(b, limit);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdDraw.show(0);
		int N = Integer.parseInt(args[0]);
		Particle[] particles = new Particle[N];
		
		for(int i=0;i<N;i++){
			particles[i] = new Particle();
		}
		CollisionSystem system = new CollisionSystem(particles);
		system.simulate(10000, 0.5);
	}

}
