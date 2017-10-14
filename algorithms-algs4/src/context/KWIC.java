package src.context;

public class KWIC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		In in = new In(args[0]);
		int context = Integer.parseInt(args[1]);

		String text = in.readAll().replaceAll("\\s+", " ");
		int N = text.length();
		SuffixArray sa = new SuffixArray(text);

		while (StdIn.hasNextLine()) {
			String query = StdIn.readLine();
			for (int i = sa.rank(query); i < N; i++) {
				int from1 = sa.index(i);
				int to1 = Math.min(N, from1 + query.length());
				if (!query.equals(text.substring(from1, to1)))
					break;
				int from2 = Math.max(0, sa.index(i) - context);
				int to2 = Math.min(N, sa.index(i) + context + query.length());
				StdOut.println(text.substring(from2, to2));
			}
			StdOut.println();
		}

	}
}
