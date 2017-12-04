
public class AList implements ListADT{
    private Athlete[] data;
    private int currSize;
    private final int MAX_SIZE = 100;

    @SuppressWarnings("unchecked")
    public AList(){
        this.data = new Athlete[MAX_SIZE];
        this.currSize = 0;
    }

    /**
     * Adds a new element to the list. 
     */
    public void insert (Athlete item){
        assert this.currSize < MAX_SIZE : "List overflow.";
        this.data[currSize] = item; // add the item
        this.currSize++; // remember that list is bigger now
    }

    /** 
     * Deletes the first occurrence of the given item in the list.
     * Returns true if item was found, otherwise false. 
     */
    public boolean remove(Athlete toRemove){
        boolean result = false;
        int pos = this.removeHelp(toRemove);
        // shift items over to fill in space of deleted item
        if (pos >= 0) { // found it!
            for (int i = pos; i < this.currSize-1; i++){
                this.data[i] = this.data[i+1];
            }
            this.currSize--; // remember that list is smaller now
            result = true;
        }
        return result;
    }

    private int removeHelp (Athlete toFind){
        int pos = -1; // haven't found it yet
        for (int i = 0; i < this.currSize && pos < 0; i++){
            if (this.data[i].equals(toFind))
                pos = i;
        }
        return pos;
    }

    /**
     * Returns the position of the first occurrence of the
     * specified element in the list, or -1 if the list doesn't contain the element.
     */
    public Athlete find (Athlete toFind){
        Athlete result = null; // haven't found it yet
        for (int i = 0; i < this.currSize; i++){
            if (this.data[i].equals(toFind))
                result = data[i];
        }
        return result;
    }

    /**
     * Returns the element at the given position.
     */
    public Athlete getValue (int pos) { 
        assert pos >= 0 && pos < this.currSize : "Error: out of bounds.";
        return this.data[pos];
    }

    /**
     * Returns true if the list is empty, else false.
     */
    public boolean isEmpty(){
        return this.currSize == 0;
    }
    /** 
     * Returns the size of the list.
     */
    public int size(){
        return this.currSize;
    }
    /**
     * Returns a String representation of the whole list (in
     * order). 
     */
    public String toString(){
        String result; 
        if (this.isEmpty()) {
            result = "";
        } else { // Need to convert Athlete object to a String
            result = this.data[0].toString();
        }
        for (int pos = 1; pos < this.currSize; pos++) {
            result += " " + this.data[pos].toString();
        }
        return result;
    }     
}

