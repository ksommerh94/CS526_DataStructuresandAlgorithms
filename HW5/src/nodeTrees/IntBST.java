package nodeTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// binary search tree storing integers
public class IntBST extends NodeBinaryTree<Integer> {

	private int size = 0;
	
	public IntBST() {	}

	public int size() {
		return size;
	}

	public void setSize(int s) { size = s; }
	
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Places element e at the root of an empty tree and returns its new Node.
	 *
	 * @param e the new element
	 * @return the Node of the new element
	 * @throws IllegalStateException if the tree is not empty
	 */

	public Node<Integer> addRoot(Integer e) throws IllegalStateException {
		if (size != 0)
			throw new IllegalStateException("Tree is not empty");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	/**
	 * Print a binary tree horizontally Modified version of
	 * https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
	 * Modified by Keith Gutfreund
	 * 
	 * @param n Node in tree to start printing from
	 */
	
	  public void print(Node<Integer> n){ print ("", n); }
	  
	  public void print(String prefix, Node<Integer> n){
		  if (n != null){
			  print(prefix + "       ", right(n));
			  System.out.println (prefix + ("|-- ") + n.getElement());
			  print(prefix + "       ", left(n));
		  }
	  }
	  
	  
	  public void inorderPrint(Node<Integer> n) {
		if (n == null)
			return;
//		Node<Integer> n = validate(p);
		inorderPrint(n.getLeft());
		System.out.print(n.getElement() + "  ");
		inorderPrint(n.getRight());
	}

	
	public Iterable<Node<Integer>> children(Node<Integer> n) {
		List<Node<Integer>> snapshot = new ArrayList<>(2); // max capacity of 2 
		if (left(n) != null) 
			snapshot.add(left(n)); 
		if (right(n) != null)
			snapshot.add(right(n)); return snapshot; 
	}
	
	public int height(Node<Integer> n) throws IllegalArgumentException { 
		if (isExternal(n)) { return 0; } 
		int h = 0; // base case if p is external
		for (Node<Integer> c : children(n)) h = Math.max(h, height(c)); return h + 1; 
	}


	
	public static IntBST makeBinaryTree(int[] a){
		//Method: calls the method creatBTree for creating and filling al the nodes
		//input: a --> array of integers that are the Nodes
		//output: the whole int tree

		IntBST tree = new IntBST();
		//assign the root
		tree.addRoot(a[(a.length/2)]);
		//call to a new method with the tree and the list
		IntBST.createBTree(a, tree);
		//take off 1 from size, because the addRoot adds 1 to the size.
		tree.setSize(tree.size()-1);
		return tree;
	}
	
		
	public static Node<Integer> createBTree(int[] a,IntBST tree){
		//Method: Fill tree  nodes with the integers of the array
		//input: a --> array of integers  tree --> tree where the nodes are going to be stored
		//output: Node
		
		if (a.length<=1) { // case base, when the array is only one element
			// creates a node
			Node<Integer> nnode = tree.createNode(a[0], null, null, null);
			// add to the size 1
			tree.setSize(tree.size()+1);
			//return the created node
			return nnode;
		}
		
		//slicing the array for the left part 
		int[] lt = Arrays.copyOfRange(a,0, (a.length/2));	
		// recursive call for with the left array 
		Node<Integer> val_lt = createBTree(lt, tree);
		//slicing the array for the right part 
		int[] rt = Arrays.copyOfRange(a,(a.length/2)+1,a.length );
		// recursive call for with the right array 
		Node<Integer> val_rt = createBTree(rt, tree);
	
		//creates the connection with the root by checking the element
		if (tree.root.getElement()==a[(a.length/2)]) {
			//increase size by 1
			tree.setSize(tree.size()+1);
			//assign the left and right node
			tree.root.setLeft( val_lt);
			tree.root.setRight(val_rt);
			//return the root
			return tree.root;
		}
		else {
		// creates node with the right and left node	
		Node<Integer> nnode = tree.createNode(a[(a.length/2)], null, val_lt, val_rt);
		//increase size by 1
		tree.setSize(tree.size()+1);
		//return node
		return nnode;

		}
	}
	
	
	
	
	

}
