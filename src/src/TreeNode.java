package src;

public class TreeNode<S> {
	//data fields
	protected S data;
	protected TreeNode right;
	protected TreeNode left;

	@SuppressWarnings("unchecked")
	public TreeNode(S string) {
		data = string;
		right = null;
		left = null;
		
	}
	
	public TreeNode(TreeNode t)
	{
	   data = (S) t.data;
	   right = t.right;
	   left = t.left;
	}
	
	
 //methods
	/**
	 * gets data for current node
	 */
	public String getData()
	{
		return (String) data;
	}
	/**
	 * to set the right child for a tree node
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setRightChild(S rightData)
	
	{
		right =  new TreeNode(rightData);
	}
	
	/**
	 * to set the left child for a tree node
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setLeftChild(S leftData)
	{
		left =  new TreeNode(leftData);
	}
	
	/**
	 * checks if the current node has a left child
	 * @return
	 */
	public boolean hasLeftChild()
	{
		return left != null;
	}
	
	/**
	 * checks if the cuyrrent node has a right child
	 * @return
	 */
	public boolean hasRightChild()
	{
		return right != null;
	}
	
}
