
/**
 * Class IntNodeTwo represent a variable in a two-ways linked list that contains integers 
 *
 * @author Natali Lev
 * @version 09/06/2019
 */
public class IntNodeTwo
{
    /**
     * Constructor for objects of class IntNodeTwo
     */
    
    //declaring objects of the class
    private int _num;
    private IntNodeTwo _next , _prev ;


    /**
     * Constructs and initializes the instance variable _num to a given variable , and IntNodeTwo to null.
     * @param n
     */
    public IntNodeTwo(int n)
    {
        _num = n;
        _next= null ;
        _prev= null ;
    }

    /**
     * Constructs and initializes the instance variables to given ones
     * @param num
     * @param n
     * @param p
     */

    public IntNodeTwo(int num , IntNodeTwo n ,IntNodeTwo p )
    {
        _num = num;
        _next= n ;
        _prev= p ;
    }

    /**
     * returns the _num value
     * @return _num the value of the _num
     */

    public int getNum(){
        return _num;
    }

    /**
     * returns the _next value
     * @return _next the value of the _next
     */

    public IntNodeTwo getNext(){
        return _next;
    }

    /**
     * returns the _prev value
     * @return _prev the value of the _prev
     */
    public IntNodeTwo getPrev(){
        return _prev;
    }

    /**
     * sets the _num to the given n
     */

    public void setNum(int n){
        _num = n ;
    }

    /**
     * sets the _next to the given IntNodeTwo node
     */
    public void setNext(IntNodeTwo node){
        _next = node ;
    }

    /**
     * sets the _prev to the given IntNodeTwo node
     */
    public void setPrev(IntNodeTwo node){
        _prev = node ;
    }
}
//end of class 