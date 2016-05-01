package jbb_alg_exam.recursion.recursionex;

public class BinaryTree {
     private String value;
     private BinaryTree left;
     private BinaryTree right;
     
     public BinaryTree(String nodeValue) {
         super();
        this.value = nodeValue;
     } 
 
    public BinaryTree(String nodeValue, 
         BinaryTree leftTree, BinaryTree rightTree) {
        this(nodeValue);
         this.left = leftTree;
         this.right = rightTree;
     } 
 
    public StringBuffer doRecursive() {
         StringBuffer sb = new StringBuffer(this.value);
         
         if (this.left != null)
             sb.append("," + this.left.doRecursive());

         if (this.right != null)
             sb.append("," + this.right.doRecursive());
 
         return sb;
     }
 
     public static void main(String [] args) {
         BinaryTree a = new BinaryTree("A");
         BinaryTree b = new BinaryTree("B");
         BinaryTree c = new BinaryTree("C", a, b);
         BinaryTree d = new BinaryTree("D", c, null);
         BinaryTree e = new BinaryTree("E", null, d);
         
         System.out.println(e.doRecursive());
     }
 }
