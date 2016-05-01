package jbb_alg_exam.linkedlist;

public class Node {
         private Integer entry;
         private Node next;
         public Node(Integer n) {
             entry = n;
        }
         public void setNext(Node n) {
            next = n;
         }
         public Node getNext() {
            return next;
         }
         public Integer getEntry() {
             return entry;
         }
         public boolean equals(Node o) {
             return o.getEntry().equals(entry);
        }
    }

