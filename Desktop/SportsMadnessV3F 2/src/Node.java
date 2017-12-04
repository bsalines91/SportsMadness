// ********************** Node.java ******************************

public class Node {
    private Athlete element;
    private Node next;
    
    public Node (Athlete someData) {
        this.element = someData;
        this.next = null;
    }
    
    public Athlete getElement() {
        return this.element;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public void setNext (Node someNode) {
        this.next = someNode;
    }
}

