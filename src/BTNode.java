/**
 * Generic Class for Binary Tree Nodes
 * @author Edson Shivuri
 **/

public class BTNode<T>{
	private T data;
	private BTNode<T> left;
	private BTNode<T> right;

	/**
	 * Constructor for the node
	 * @param data data to be stored
	 * @param left left child of current node
	 * @param right right child of current node
	 **/
	public BTNode(T data, BTNode<T> left, BTNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}

	
	/**
	 *Retrieve the data stored in the node 
	 *@return the data object stored in the node
	 **/
	public T getData(){
		return this.data;
	}

	/**
	 * Retrieve the left child node
	 * @return the left child node
	 **/
	public BTNode<T> getLeft() {return left;}

	/**
         * Retrieve the right child node
         * @return the right child node
         **/
	public BTNode<T> getRight(){return right;}


}
