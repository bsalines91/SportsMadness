
public class LList implements ListADT{
    private Node first;
    private int currSize;

    public LList(){
        this.first = null; 
        this.currSize = 0;
    }

    /**
     * Adds a new element to the list. 
     */
    public void insert (Athlete toAdd) {
        Node newNode = new Node(toAdd);
        newNode.setNext(this.first);
        this.first = newNode;      
        this.currSize++; // remember that list is bigger now
    }

    /** 
    * Deletes the first occurrence of the given item in the list. 
    */
    public boolean remove (Athlete toDelete) {
        boolean result = false; // not found yet
        int pos = this.removeHelp(toDelete);
        if (pos < 0) {
            // do nothing, item not found
        } else if (pos == 0) { // deleting first item
            result = true; // found it!
            this.first = this.first.getNext();
            this.currSize--; // remember that list is smaller now
        } else { // deleting some item after the first one
            result = true; // found it!
            // first find the node *before* the one to be deleted
            Node thingBefore = null;
            Node current = this.first;
            while (current != null && !current.getElement().equals(toDelete)){
                thingBefore = current;
                current = current.getNext();
            }
            // then connect the node before to the one after, bypassing toDelete
            thingBefore.setNext(current.getNext()); 
            this.currSize--; // remember that list is smaller now
        }
        return result;
    }

    private int removeHelp (Athlete toFind) {
        int pos = 0;
        boolean found = false;
        for (Node current = this.first; 
        current != null && !found;
        current = current.getNext()) {
            if (current.getElement().equals(toFind)){
                found = true;
            } else {
                pos++; 
            }
        } 
        if (!found) pos = -1; // signal that we didn't find it
        return pos;
    }

    /**
    * Returns the position of the first occurrence of the
    * specified element in the list, or -1 if the list doesn't contain the element.
    */
    public Athlete find (Athlete toFind) {
        Athlete result = null;
        boolean found = false;
        for (Node current = this.first; 
        current != null && !found;
        current = current.getNext()) {
            if (current.getElement().equals(toFind)){
                found = true;
                result = current.getElement();
            }
        }
        return result;
    }

    /**
    * Returns the element contained in the node at the given position.
    */
    @SuppressWarnings("unchecked")
    public Athlete getValue (int pos) {
        assert 0 <= pos && pos < this.currSize : "Error: out of bounds.";
        Node current = this.first;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();  
        } 
        return current.getElement();
    }

    /**
     * Returns true if the list is empty, else false.
     */
    public boolean isEmpty() {
        return this.currSize == 0;
    }
    
    /**
     * Returns the size of the list.
     */
    public int size(){
        return this.currSize;
    }

    /**
    * Returns a String representation of the elements of the list (in order).
    */
    @SuppressWarnings("unchecked")
    public String toString() {
        String result;
        Node current = null;
        if (this.isEmpty()) 
            result = "";
        else {
            result = this.first.getElement().toString(); // do this first so we can add spaces
            current = this.first.getNext(); // current is now the second element (or null)
        }
        while (current != null) {
            result += " " + current.getElement().toString();
            current = current.getNext();
        }
        return result;
    }     
}
