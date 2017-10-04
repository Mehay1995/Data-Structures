
public class BSTJr <K extends Comparable<?super K>> {
	BinNode<K> root;
	BinNode<K> curr;
	//for balance checking: if a node is unbalanced, the tree will be unbalanced
	BinNode<K> unbalanced = null;
	public BSTJr() {
		root = null;
		curr = null;
	}
	public void build(K[] ks) {
		for(int i = 0; i < ks.length; i ++) insert(ks[i]);
	}
	public void insert(K k) {
		BinNode<K> t = new BinNode<K>(k);
		if(root == null) {
			root = curr = t;
		}
		else {
			curr = search(root, k);
			if(k.compareTo(curr.getKey()) < 0) curr.setLeft(t);
			else curr.setRight(t);
		}
	}
	public BinNode<K> search(BinNode<K> entry, K k) {
		if(entry == null) return null;
		else { 
			entry.setSize(entry.getSize() + 1); //update the size of the subtree by one
			if(entry.isLeaf()) return entry;
			if(k.compareTo(curr.getKey()) < 0) {
				if(entry.getLeft() != null) return search(entry.getLeft(), k);
				else return entry;
			}
			else {
				if(entry.getRight() != null) return search(entry.getRight(), k);
				else return entry;
			}
		}
	}
	public void display() { 
		if(root == null) return;
		System.out.println("Preorder enumeration: key(size-of-the-subtree)");
		preorder(root); 
		System.out.println();
	}
	public void preorder(BinNode<K> entry) {
		System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
		if(entry.getLeft() != null) preorder(entry.getLeft());
		if(entry.getRight() != null) preorder(entry.getRight());
	}
	
	int nthsmallestval(BinNode<K> entry, int n ){
		if (entry.isLeaf()){
			return (int)entry.getKey();
		}
		if(entry.getLeft().getSize() == n -1 ){
			return (int) entry.getKey();
		}
		else if(entry.getLeft().getSize() > n-1){
			return nthsmallestval(entry.getLeft(),n);
		}
		else {
			return nthsmallestval(entry.getRight(), n-(entry.getLeft().getSize())-1);;
		}
	
		
		
	}
	public static void main(String[] argv) {
		BSTJr<Integer> tree = new BSTJr<Integer>();
		Integer[] ks = {37, 24, 42, 7, 2, 40, 120};
		tree.build(ks);
		tree.display();
		System.out.println("Largest to smallest: ");
		System.out.println( tree.nthsmallestval(tree.root, 7)); 
		System.out.println( tree.nthsmallestval(tree.root,6));
		System.out.println( tree.nthsmallestval(tree.root,5));
		System.out.println( tree.nthsmallestval(tree.root,4));
		System.out.println( tree.nthsmallestval(tree.root,3));
		System.out.println( tree.nthsmallestval(tree.root,2));
		System.out.println( tree.nthsmallestval(tree.root,1));
		System.out.println("Smallest to Largest: ");
		System.out.println( tree.nthsmallestval(tree.root, 1)); 
		System.out.println( tree.nthsmallestval(tree.root,2));
		System.out.println( tree.nthsmallestval(tree.root,3));
		System.out.println( tree.nthsmallestval(tree.root,4));
		System.out.println( tree.nthsmallestval(tree.root,5));
		System.out.println( tree.nthsmallestval(tree.root,6));
		System.out.println( tree.nthsmallestval(tree.root,7));
		
	}
}
