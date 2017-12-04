
public interface ListADT {
    /**
     * Adds a new element to the list.  
     */
    public void insert (Athlete item);

    /** 
     * Deletes the first occurrence of the given item in the list. 
     */
    public boolean remove(Athlete toRemove);

    /**
     * Returns the position of the first occurrence of the
     * specified element in the list, or -1 if the list doesn't contain the element.
     */
    public Athlete find (Athlete toFind);

    /**
     * Returns the element at the given position.
     */
    public Athlete getValue (int pos);

    /**
     * Returns true if the list is empty, else false.
     */
    public boolean isEmpty();
    
    /**
     * Returns a String representation of the whole list (in order).
     */
    public String toString();
    
    /**
     * Returns the size of the list.
     */
    public int size();
}
