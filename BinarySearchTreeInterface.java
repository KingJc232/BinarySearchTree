/**
 * File: BinarySearchTreeInterface.java
 * Goal: To define all the methods that create a BinarySearchTree Data Structure 
 * */


/**
 * Making it generic and that generic type is going to extend the Comparable interface to be able to use 
 * the .compareTo(other)
 * */
public interface BinarySearchTreeInterface<T extends Comparable <? super T>>
{
   /**Adds a entry to the BinarySearchTree If it already 
    * exists it returns the oldEntry else it returns null
    * @param entry to be added
    * @return T*/
   public T add(T entry);

   /**Removes an entry from the BinarySearchTree If Found 
    * Else it returns null
    * @param entry to remove 
    * @return T returns the entry removed */
   public T remove(T entry);

   /**Checks Whether the BinarySearchTree is Empty oR Not
    * @return boolean If Empty it returns true else false*/
   public boolean isEmpty();

   /**Clears the BinarySearchTree
    * @return void */
   public void clear(); 

   /**Searches for a entry in the BinarySearchTree 
    * if Found it returns said Entry 
    * else it returns null
    * @param entry to look for 
    * @return T*/
   public T getEntry(T entry);

   /**Determines if the BinarySearchTree Contains a Entry
    * @param entry to look for
    * @return boolean if found true else false*/
   public boolean contains(T entry);

   /**Prints the BinarySearchTree in inOrder 
    * @return void */
   public void printInOrder(); 
}
