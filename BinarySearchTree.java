/**
 * File: BinarySearchTree.java
 * Goal: To Define a BinarySearchTree Data Structure 
 * That utilizes the BinarySearchTreeInterface
 * */

public class BinarySearchTree<T extends Comparable<? super T>> implements BinarySearchTreeInterface<T>
{

   /**Private Data Fields In BinarySearchTree */
   BinaryNode<T> root; //Points to the root of the BinarySearchTree 

   //Default Constructor 
   public BinarySearchTree()
   {
      this.root = null; 
   }

   /**Methods Defined In BinarySearchTreeInterface */
      /**Adds a entry to the BinarySearchTree If it already 
    * exists it returns the oldEntry else it returns null
    * @param entry to be added
    * @return T*/
   public T add(T entry)
   {
      ReturnedObject entryToReturn = new ReturnedObject(null); //This is the Entry to return 
      //Checking If the BinarySearchTree is Empty 
      if(this.isEmpty())
      {
         this.root = new BinaryNode<>(entry); //Updating the this.root Node 
      }
      else
      {
         //Its Not Empty Recursively Check the Tree to Put the Entry in its correct Location 
         this.root = this.addEntry(this.root, entry, entryToReturn); //Calling a Recurisve Helper Method 
      }
      return entryToReturn.getEntryToReturn(); //Returning the EntryToReturn 
   }
   
   /**Helper Method Adds An Entry to the BinarySearchTree Assuming its Not Empty 
    * If the entry trying to add exists the update the entryToReturn Object 
    * @param rootNode where to start 
    * @param entry to Add 
    * @param entryToReturn Entry that determines if the item was already in the BinarySearchTree 
    * @return BinaryNode<T> Subtree of rootNode*/
   public BinaryNode<T> addEntry(BinaryNode<T> rootNode, T entry, ReturnedObject entryToReturn)
   {
      //Using Implict Recursion 
      if(rootNode != null)
      {
         //First Case it Equals the rootNode.data Update it  
         if(entry.equals(rootNode.data))
         {
            //Updating the EntryToReturn Object with the Old Entry 
            entryToReturn.setEntryToReturn(rootNode.data); 
            //Updating the data in the BinarySearchTree
            rootNode.data = entry; 
         }
         //Second Case The entry needs to be stored in the LeftChild
         else if(entry.compareTo(rootNode.data) < 0)
         {
            //If the rootNode has a LeftChild Recursively Call the Method 
            if(rootNode.hasLeftChild())
               rootNode.leftChild = addEntry(rootNode.leftChild, entry, entryToReturn); //Recurisvely Call Left Subtree 
            //rootNode does Not have a left Child so store it there 
            else
               rootNode.leftChild = new BinaryNode<>(entry); 
         }
         //Third Case Store the Entry in the Right Child 
         else
         {
            //If it already has a rightChild recursively Call the method 
            if(rootNode.hasRightChild())
               rootNode.rightChild = addEntry(rootNode.rightChild, entry, entryToReturn); //Recurisvelt Call Right Subtree
            else
               rootNode.rightChild = new BinaryNode<T>(entry); //Creating a new Node to store it at 
         }
      }
      return rootNode; //Return the rootNode 
   }


   /**Removes an entry from the BinarySearchTree If Found 
    * Else it returns null
    * @param entry to remove 
    * @return T returns the entry removed */
   public T remove(T entry)
   {
      return null; 
   }

   /**Checks Whether the BinarySearchTree is Empty oR Not
    * @return boolean If Empty it returns true else false*/
   public boolean isEmpty()
   {
      return this.root == null; //If root == null then its empty else its not empty 
   }

   /**Clears the BinarySearchTree
    * @return void */
   
   public void clear()
   {
      this.root = null; 
   }

   /**Searches for a entry in the BinarySearchTree 
    * if Found it returns said Entry 
    * else it returns null
    * @param entry to look for 
    * @return T*/
   public T getEntry(T entry)
   {
      //Using a Private Recursive Method 
      T answer = this.findEntry(this.root, entry); 

      return answer; 
   }
   //Private Helper Method For getEntry 
   private T findEntry(BinaryNode<T> rootNode, T entry)
   {
      T result = null; 

      //Using Implicit Recursion 
      if(rootNode != null)
      {
         //Case 1 Its Equal to the rootNode.data
         if(entry.equals(rootNode.data))   
            result = rootNode.data; 
         
         //Case 2 its Less then the rootNode.data
         else if(entry.compareTo(rootNode.data) < 0)
            result = findEntry(rootNode.leftChild, entry); //Eliminates the RightSubtree
         //Case 3 Its Greater then the rootNode.data
         else
            result = findEntry(rootNode.rightChild, entry); //Eliminates the LeftSubtree 
      }

      //Else
      return result; 
   }


   /**Determines if the BinarySearchTree Contains a Entry
    * @param entry to look for
    * @return boolean if found true else false*/
   public boolean contains(T entry)
   {
      return this.getEntry(entry) != null; 
   }

   /**Prints the BinarySearchTree in inOrder 
    * @return void */
   public void printInOrder()
   {
      String answer = "[ ";
      answer += this.inOrder(this.root); //Using recurisve Helper Method
      
      if(!this.isEmpty())
         answer = answer.substring(0, answer.length() -2); 

      answer += "]";
   
      System.out.println(answer); 
   }

   //Private Helper Method 
   private String inOrder(BinaryNode<T> rootNode)
   {
      //Base Case
      if(rootNode == null)
         return ""; //STOP
      //Else 
      String answer = ""; 

      //Go Left First 
      answer += this.inOrder(rootNode.leftChild);

      //Save the Data Once you have gone as far left as possible 
      answer += rootNode.data + " , "; 

      //Go Right Next
      answer += this.inOrder(rootNode.rightChild); 

      return answer; //Returning the Answer 
   }

   //Private Class Should Never See the Light Of Day 
   private class ReturnedObject
   {
      private T entryToReturn; //Entry to return 
   
      //Default Constructor 
      public ReturnedObject()
      {
         this(null);
      }
      public ReturnedObject(T entryToReturn)
      {
         this.entryToReturn = entryToReturn; 
      }
     
      //Getter
      public T getEntryToReturn()
      {
         return this.entryToReturn; 
      }

      //Setter
      public void setEntryToReturn(T newEntry)
      {
         this.entryToReturn = newEntry; 
      }
   }
}
