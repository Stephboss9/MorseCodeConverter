package src;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	TreeNode root;

	public MorseCodeTree() {
		root = null;
		buildTree();
		
	}
	
	public MorseCodeTree(TreeNode root)
	{
		this.root = new TreeNode(root);
	}
	/**
	 * returns a deep copy of the root
	 */
	@Override
	public TreeNode getRoot() {
		
		return new TreeNode(root);
	}
	
	/**
	 * sets the root node with parameter
	 */

	@SuppressWarnings("unchecked")
	@Override
	public void setRoot(TreeNode newNode) {
		root = new TreeNode(newNode);
		
	}

	@Override
	public MorseCodeTree insert(String code, String result) {
		
		
		if(root == null)
		{
			setRoot(new TreeNode<String>(result));
		}
		else
		{
			addNode(root, code, result);
		}
		return this; // return a new morseCode tree with a deep copym of the root
		
	}

	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addNode(TreeNode root, String code, String letter) {
		
		
		if(code.length()!=1)// if were not on the last character to process
		{
		
			//check if the next part of the code is a dot and if root node has a left child 
			if(code.charAt(0) == '.' && root.hasLeftChild()) {
				addNode(root.left, code.substring(1), letter); // Goto left child
				
			}
			else if(code.charAt(0) == '-' && root.hasRightChild()) { // check if next part of the code is a -
				addNode(root.right, code.substring(1), letter); //goto right child
			}
			
		}
		else
		{
			if(code.charAt(0) == '.') // if were on the last character to process and the character is a dot, set the current root's left child to letter
			{
				root.setLeftChild(letter);
			}
			else
			{
				root.setRightChild(letter); //else set the current root's right child to letter
			}
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
		}

	@Override	
	public String fetchNode(TreeNode<String> root, String code) {

		if(code.length()!=1)// if were not on the last character to process
		{
		
			//check if the next part of the code is a dot and if root node has a left child 
			if(code.charAt(0) == '.') {
				return fetchNode(root.left, code.substring(1)); // look for the node in the left subtree of root
				
			}
			else  { // check if next part of the code is a -
				return fetchNode(root.right, code.substring(1)); // look for the node in right subtree of root
			}
			
		}
		else
		{
			if(code.charAt(0) == '.') // if were on the last character to process and the character is a dot, get data of left child of current node
			{
				return (String) root.left.getData();
			}
			else
			{
				return (String)root.right.getData(); // if were on the last character to process and the character is a dash, get data of right child of current node
			}
			
		}
	}

	@Override
	public LinkedConverterTreeInterface delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		setRoot(new TreeNode<String>(""));
		insert(".", "e");
		insert("-", "t");
		insert( "..", "i");
		insert("-.", "n");
		insert(".-", "a");
		insert("--","m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList toArrayList() {
		ArrayList listOfData = new ArrayList <>(26); //declare arraylist of size 26
		LNRoutputTraversal(root, listOfData); //call recursive method to store contetns of tree in arraylist
		return listOfData; //return the arraylist
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		
		if(root!=null)
		{
		LNRoutputTraversal(root.left, list);
		list.add(root.getData());
		LNRoutputTraversal(root.right, list);
		}
		
	}


	
	

	

}
