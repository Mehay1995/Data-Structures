
// KD tree with insert and exact match functions
// getNeighbors(Key[] key, int r) is going to be implemented by the students

public class KDtree<Key extends Comparable<?super Key>, E> {
	private BinNode<Key, E> root;
	private int totalNode;
	private BinNode<Key, E> curr;   //works with find()
	private String enumStr;         //for enumeration
	private int dim;   //dimension of the key
	private int level; //which level; important for insertion & search
	private BinNode right;
	public KDtree(int d) {
		root = curr = null;
		totalNode = 0;
		dim = d;
		level = 0;
	}
	public BinNode<Key, E> find(Key[] k) {
		if(root == null) return null;
		else {
			return find(root, 0, k);
		}
	}
	public BinNode<Key, E> find(BinNode<Key, E> entry, int thislevel, Key[] k) {
		if(entry == null) return null;
		curr = entry;
		level = thislevel; //update level
		if(entry.getKey() == k) {
			return curr;
		}
		else {
			if(entry.isLeaf()) return null;
			Key[] key2 = entry.getKey();
			if (k[level % dim].compareTo(key2[level % dim]) >= 0) { //make sure the "right" key is used
				return find(entry.getRight(), thislevel + 1, k); //note thislevel + 1
			}
			else {
				return find(entry.getLeft(), thislevel + 1, k);
			}
		}
	}
	public void insert(Key[] k, E v) {
		BinNode<Key, E> node = new BinNode <Key, E>(k, v);
		insert(node);
		//insert(root, node);
	}
	public void insert(BinNode<Key, E> node) {
		find(node.getKey());
		if(curr == null) {
			root = node;
		}
		else {
			Key[] key1 = node.getKey();
			Key[] key2 = curr.getKey();
			if (key1[level % dim].compareTo(key2[level % dim]) >= 0) {
				if(curr.getRight() != null) node.setRight(curr.getRight());
				curr.setRight(node);
			}
			else {
				if(curr.getLeft() != null) node.setLeft(curr.getLeft());
				curr.setLeft(node);
			}
		}
		totalNode ++;
	}
	public void preorder() {
		enumStr = "";
		System.out.println("Total node = " + totalNode);
		if(root != null) preorder(root);
		System.out.println("Preorder enumeration: " + enumStr);
	}
	private void preorder(BinNode<Key, E> node) {	
		if(node != null) System.out.println("root " + node.toString());
		if(node.getLeft() != null) System.out.println("   left " + node.getLeft().toString());
		if(node.getRight() != null) System.out.println("   right " + node.getRight().toString());
		
		if(node != null) {
			enumStr += node.toString();
		}
 		if(node.getLeft() != null) preorder(node.getLeft());
		if(node.getRight() != null) preorder(node.getRight());
	}
	
	public double findDistance(Key[] a, Key[] b){
		return Math.sqrt((Math.pow(((int)a[0] - (int)b[0]), 2)) + (Math.pow((int)a[1]- (int)b[1], 2)));
	}
	//to be implemented 
	public void getNeighbors(Key[] key, int r) {  //Prints the values of all neighbors within distance r of Key[] key
		Key[] k2 = curr.getKey();
		if (findDistance(k2, key) < r) {
			System.out.print(find(k2).getValue());
		}
		if (level%2 == 0) {
			if (((int)(key[0]) - (int)k2[0]) > r) {
				if ((int)key[0] < (int)k2[0]) {
					if (curr.getRight() != null) {
						level++;
						right = curr.getRight();
						curr = right;
						Key[] key3 = (Key[]) right.getKey();
						Key[] key2 = key3;
						getNeighbors(key2, r);
					}
					else {System.out.println("");}
				}
				else {
					if (curr.getLeft() != null) {
						level++;
						BinNode<Key, E> left = curr.getLeft();
						curr = left;
						getNeighbors((Key[]) left.getKey(), r);
						}
					else {System.out.println("");}
					
				}
			}
			else {
				BinNode<Key, E> a = new BinNode<Key, E>(curr.getKey(), curr.getValue());
				curr = curr.getLeft();
				getNeighbors((Key[])curr.getKey(), r);
				curr = find(a.getKey()).getRight();
				getNeighbors((Key[])curr.getKey(), r);
			}
		}
		else {
			if (((int)key[1] - (int)k2[1]) < r) {
				if ((int)key[1] < (int)k2[1]) {
					if (curr.getRight() != null) {
						level++;
						BinNode right = curr.getLeft();
						curr = right;
						getNeighbors((Key[]) right.getKey(), r);
					}
					else {System.out.println("");}
				}
				else {
					if (curr.getLeft() != null) {
						level++;
						BinNode left = curr.getLeft();
						curr = left;
						getNeighbors((Key[]) left.getKey(), r);
					}
					else {System.out.println("");}
				}
			}
			else {
				BinNode<Key, E> a = new BinNode<Key, E>(curr.getKey(), curr.getValue());
				curr = curr.getLeft();
				getNeighbors((Key[])curr.getKey(), r);
				curr = find(a.getKey()).getRight();
				getNeighbors((Key[])curr.getKey(), r);
			}
		}
		
		}


	public static void main(String[] args) {
		
		// Couldn't get it to work with 3 Dimensional KD tree
		
		KDtree <Integer, String> kdt = new KDtree<Integer, String>(2);
		Integer[] dataA = {40, 45};
		kdt.insert(dataA, "A");
		Integer[] dataB = {15, 70};
		kdt.insert(dataB, "B");
		Integer[] dataC = {70, 10};
		kdt.insert(dataC, "C");
		Integer[] dataD = {69, 50};
		kdt.insert(dataD, "D");
		Integer[] dataE = {66, 85};
		kdt.insert(dataE, "E");
		Integer[] dataF = {85, 95};
		kdt.insert(dataF, "F");
		
		kdt.preorder();
		
		Integer[] dataG = {85, 93}; //G, close to F
		System.out.println("Query location: " + dataG[0] + " " + dataG[1]);
		BinNode<Integer, String> node = kdt.find(dataG); //exact match
		if(node == null) {
			System.out.println("point not found");
		}
		else {
			System.out.println("point found: " + node.toString());
		}
		
		int r = 3;
		kdt.getNeighbors(dataG, r); //get close neighbors
	}
}
