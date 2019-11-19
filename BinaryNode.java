/**
 * File: BinaryNode.java
 * Goal: To Define a Node object that will be used in the BinarySearchTree Data Structure 
 * Going to Use package protection 
 * */


public class BinaryNode<T extends Comparable<? super T>>
{
   /**Public Data Fields (NO Getters/Helpers)*/

   public T data; //The Actual Data The BinaryNode contains 
   public BinaryNode<T> leftChild; //Pointer that points to the BinaryNodes LeftChild 
   public BinaryNode<T> rightChild; //Pointer that points to the BinaryNodes RightChild 

   //Default Constructor 
   public BinaryNode()
   {
      //Using the Initilizor Constructor 
      this(null,null,null); 
   }

   //Initilizor Constructors 
   public BinaryNode(T data)
   {
      //Using the Initilizor Constructor 
      this(data, null,null); 
   }

   public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild)
   {
      this.data = data; 
      this.leftChild = leftChild; 
      this.rightChild = rightChild; 
   }

   /**Methods that Will Help the BinarySearchTree Implementation*/
   
   public boolean hasLeftChild()
   {
      return this.leftChild != null; 
   }

   public boolean hasRightChild()
   {
      return this.rightChild != null; 
   }

}
