package src.string;

public class LZW {

	private static final int R = 256;
	private static final int L = 4096;
	private static final int W = 12;

	public static void compress() {
        String input = BinaryStdIn.readString();
        TST<Integer> st = new TST<Integer>();
        for (int i = 0; i < R; i++)
            st.put("" + (char) i, i);
        int code = R + 1;  // R is codeword for EOF

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input);  // Find max prefix match s.
            BinaryStdOut.write(st.get(s), W);      // Print s's encoding.
            int t = s.length();
            if (t < input.length() && code < L)    // Add s to symbol table.
            {
                st.put(input.substring(0, t + 1), code++);
            }
            input = input.substring(t);            // Scan past s in input.
        }
        BinaryStdOut.write(R, W);
        BinaryStdOut.close();
    }
	
	private static void expand() {
		String[] st = new String[L];
		int i;
		// 用字符初始化编译表
		for (i = 0; i < R; i++) {
			st[i] = "" + (char) i;
		}
		st[i++] = " ";// 未使用的文件结束标记的前瞻字符

		int codeword = BinaryStdIn.readInt(W);
		String val = st[codeword];
		while (true) {
			BinaryStdOut.write(val);
			codeword = BinaryStdIn.readInt(W);
			if (codeword == R)
				break;
			String s = st[codeword];
			if (i == codeword)
				s = val + val.charAt(0);
			if (i < L)
				st[i++] = val + val.charAt(0);
			val = s;
		}
		BinaryStdOut.close();
	}
	
	public static void main(String[] args) {
        if (args[0].equals("-")) {
            compress();
        } else if (args[0].equals("+")) {
            expand();
        } else {
            throw new IllegalArgumentException("Illegal command line argument");
        }
    }

}
