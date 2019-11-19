/**
 * File: Main.java
 * Developer: Jose Ceballos 
 * Goal: To implement a binary search tree 
 * */


public class Main
{
   public static void main(String[] args)
   {
      BinarySearchTreeInterface<Integer> tree = new BinarySearchTree<>(); //Creating a Binary SearchTree Data Structure 

      
      tree.add(5); 
      tree.add(4);
      tree.add(6); 
      tree.add(2); 
      tree.add(3); 
      tree.add(7); 
      tree.add(15); 
      tree.printInOrder(); 

      Integer target = 77; 
      log("Does BinarySearchTree Contain " + target + " : " + tree.contains(target)); 
   }

   public static void log(String msg)
   {
      System.out.println(msg); 
   }
}

