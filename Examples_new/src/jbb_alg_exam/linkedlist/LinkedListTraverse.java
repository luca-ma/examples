package jbb_alg_exam.linkedlist;

public class LinkedListTraverse {

	private Node first;
	
	    public Node getFirst() {
	         return first;
	    }
	    public LinkedListTraverse oddMethod(LinkedListTraverse l) {
	         Node testNode = first;
	         Node otherTestNode = l.getFirst();
	         while(otherTestNode != null) {
	             if(testNode.equals(otherTestNode)) {
	                otherTestNode = otherTestNode.getNext();
	             }
	             if(testNode.getNext() == null) {
	                return null;
	             }
	             testNode = testNode.getNext();
	         }
	         return new LinkedListTraverse(testNode);
	    }
	    public LinkedListTraverse(Node n) {
	    	first = n;
	    }
	    //adders and removers as necessary

}
