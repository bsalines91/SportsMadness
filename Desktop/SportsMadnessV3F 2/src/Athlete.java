
/**
 * Athlete -- the superclass for a hierardchy of athletes.
 * @author K. Sanders for CS 212 
 * @version 21 September 2015
 */
public abstract class Athlete {
    // declare instance variables first
    private String lastName;
    private String firstName;

    // then the constructor
    public Athlete(String last, String first)
    {
        this.lastName = last;
        this.firstName = first;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public abstract void printStatistics();
    
    public abstract String getType();
    
    public boolean equals (Athlete other){
        if (this.lastName.equalsIgnoreCase(other.getLastName())
        && this.firstName.equalsIgnoreCase(other.getFirstName())){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return this.firstName + " " + this.lastName;
    }
    
}
