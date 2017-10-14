package src.string;


public class Huffman {

	private static int R = 256;
	
	private static class Node implements Comparable<Node> {
		private char ch;
		private int freq;
		private final Node left, right;

		public Node(char ch, int freq, Node left, Node right) {
			// TODO Auto-generated constructor stub
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		public int compareTo(Node that) {
			return this.freq - that.freq;
		}
	}
	
	public static void expand() {
		Node root = readTrie();
		int N = BinaryStdIn.readInt();
		for(int i=0;i<N;i++){
			Node x = root;
			while (!x.isLeaf()) {
				if(BinaryStdIn.readBoolean())
					x = x.right;
				else 
					x = x.left;
			}
			BinaryStdOut.write(x.ch);
		}
		BinaryStdOut.close();
	}

	//通过前缀码字典查找树构建编译表
	private static String[] buildCode(Node root) {
		String[] st = new String[R];
		buildCode(st,root,"");
		return st;
	}
	
	private static void buildCode(String[] st, Node x, String s) {
		// TODO Auto-generated method stub
		if(x.isLeaf()){
			st[x.ch]=s;
			return;
		}
		buildCode(st,x.left,s+'0');
		buildCode(st,x.right,s+'1');
	}

	
	//构造huffman单词查找树
	private static Node buildTrie(int[] freq) {
		// initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0) {
                pq.insert(new Node(i, freq[i], null, null));
            }

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) {
                pq.insert(new Node('\0', 0, null, null));
            } else {
                pq.insert(new Node('\1', 0, null, null));
            }
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
	}
	
	private static Node readTrie() {
		// TODO Auto-generated method stub
		if(BinaryStdIn.readBoolean())
			return new Node(BinaryStdIn.readChar(), 0, null, null);
		return new Node('\0', 0, readTrie(), readTrie());
	}

	private static void writeTrie(Node x) {
		while (x.isLeaf()) {
			BinaryStdOut.write(true);
			BinaryStdOut.write(x.ch);
			return;
		}
		BinaryStdOut.write(false);
		writeTrie(x.left);
		writeTrie(x.right);
	}
	
	//Huffman压缩
	private static void compress() {
		String s = BinaryStdIn.readString();
		char[] input = s.toCharArray();
		int[] freq = new int[R];
		for(int i=0;i<input.length;i++){
			freq[input[i]]++;
		}
		Node root = buildTrie(freq);
		String[] st = new String[R];
		buildCode(st,root,"");
		writeTrie(root);
		BinaryStdOut.write(input.length);
		for(int i=0;i<input.length;i++){
			String code = st[input[i]];
			for(int j=0;j<code.length();j++){
				if(code.charAt(j)==1){
					BinaryStdOut.write(true);
				}else {
					BinaryStdOut.write(false);
				}
			}
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
