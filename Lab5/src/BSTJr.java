
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
	
	public  boolean checkBinaryTreeIsBalanced(BinNode<K> entry){


	     if(entry == null)
	          return true;

	   
	    int heightDifference = computeHeight(entry.getLeft()) - computeHeight(entry.getRight());

	    if(Math.abs(heightDifference)  <= 1)
	          return checkBinaryTreeIsBalanced(entry.getLeft())  && 
	                 checkBinaryTreeIsBalanced(entry.getRight());
	    else
	          return false;
	    
	 }

	public int computeHeight(BinNode<K> entry){

	    
	      if(entry == null)
	           return 0;
	 
	      return Math.max(computeHeight(entry.getLeft()), computeHeight(entry.getRight())) + 1;
	 }
	
	
	
	
	
		
	
	
	
		
		
		
	
		
		
	
		

		
		
		
	
	public static void main(String[] argv) {
		BSTJr<Integer> tree = new BSTJr<Integer>();
		//Integer[] ks = {37, 24, 42, 7, 2, 40, 120};
		Integer[] ks = {4,2,1,3,6,5,7};
		tree.build(ks);
		tree.display();
		System.out.println(tree.checkBinaryTreeIsBalanced(tree.root));
		
		
	}
}