import java.util.Scanner;

/**
 * Class IntListTwo represent a two-ways linked list , every variable in the list is an object from the class IntNodeTwo
 *
 * @author Natali Lev
 * @version 09/06/2019
 */
public class IntListTwo
{
    /**
     * Constructor for objects of class IntListTwo
     */
    //declaring the object of the class
    private IntNodeTwo _head , _tail ;

    /**
     * Constructor for objects of class IntListTwo to be null
     */
    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    /**
     * Constructor for objects of class IntListTwo to given variables
     */
    public IntListTwo(IntNodeTwo h ,IntNodeTwo t )
    {
        _head= h ;
        _tail= t ;
    }

    /**
     * The method recieves a number and adds it to the list on its right place .
     *
     * Time complexity = o(n)
     * Space complexity = o(1)
     * 
     * @param  num  the number we add to the list
     */

    public void addNumber(int num) {
        IntNodeTwo node = new IntNodeTwo(num);
        if (_head == null) {    //in case its an empty list - we get a new head
            _head = node;
            _tail = _head;
            return;
        }

        IntNodeTwo current = _head;
        while ((current.getNext() != null) && (current.getNum() <= num))
            current = current.getNext();
        if (current.getNext() == null)  // end of the list
            if (current.getNum() <= num) {// adding it to the end of the list
                current.setNext(node);
                _tail = node; // adding a new tail
                node.setPrev(current);
                return;
            }
        if (current != _head) // no prev - inserting a num at 1st place
            current.getPrev().setNext(node);
        else
            _head = node;
        node.setNext(current);
        node.setPrev(current.getPrev());
        current.setPrev(node);
    }

    /**
     * The method recieves a number and removes it from the list.
     *
     * Time complexity = o(n)
     * Space complexity = o(1)
     * 
     * @param  num  the number we remove from the list
     */

    public void removeNumber(int num){
        //declaring the variables we will use in this method
        IntNodeTwo p , prev;
        p = _head;
        prev = null;
        
        while((p != null )&& (p.getNum() != num))   //looking for the number we want to remove
        {
            prev = p;                               
            p = p.getNext();
        }
        if(p != null)
        {
            if(prev == null)                    //if the number we want to remove is the head,we need to remove the head and then get the next value for it 
                _head = _head.getNext();
            else
                prev.setNext(p.getNext());      //if the number we want to remove is the tail,we need to remove the tail and get the prev number for it 
        }

    }

    /**
     * the method reads an input of numbers into a list and sorts it until the number -9999 is typed in the input
     * 
     * Time complexity = o(n^2)
     * Space complexity = o(1)
     * 
     */

    public void readToList(){
        Scanner scan = new Scanner(System.in);
        int number  = 0 ;

        while(number != -9999){         //as long as the user doesnt type the number -9999 the loop will keep going 
            number = scan.nextInt();    //scanning for the next number
            if ( number != -9999){      //making sure the number isnt -9999

                addNumber(number);      //adding it to the list and and sorting it 
            }
        }
    }

    /**
     * Returns a string representation of the list
     * 
     * Time complexity = o(n)
     * Space complexity = o(n)
     * 
     * @return listString returns representation of the list 
     */

    public String toString(){
        IntNodeTwo p ;
        String listString = "{";
        for (p = _head;  p!= null ; p = p.getNext())        //going over all the list 
            listString += p.getNum() + (p.getNext() != null?", ":"" );      
        listString += "}";

        return listString;                                  //return the final string
    }

    /**
     * The method checks the length of the list
     *
     * Time complexity = o(n)
     * Space complexity = o(1)
     * 
     * @return count returns the length of the list
     */

    public int length(){
        IntNodeTwo p ;
        int count = 0 ;
        for (p = _head;  p!= null ; p = p.getNext())        //going over all the list 
            count++;

        return count;                                       //return the final result 
    }

    /**
     * The method checks the sum of the list
     *
     * Time complexity = o(n)
     * Space complexity = o(1)
     * 
     * @return sum returns the sum of the list
     */

    public int sum(){
        IntNodeTwo p ;
        int sum = 0 ;
        for (p = _head;  p!= null ; p = p.getNext())        //going over all the list
            sum += p.getNum();

        return sum;                                         //return the final result
    }

    /**
     * the method returns the longest list inside the list that has the biggest streak of even sum of numbers 
     * 
     * Time complexity = o(n)
     * Space complexity = o(1)
     * 
     * @return result the result and the variable we return is different in any case, we return length of the whole list has even sum 
     */

    public  int maxLength(){
        int sum = sum() ;       //getting the sum of the list   
        int length = length();  //getting the length of the list

        //if the whole list is even return it's length 
        if(sum %2 == 0) 
            return length;

        else {
            int left = 0 ;              //initial to the first cell
            IntNodeTwo leftNode = _head ; 
            int right = length - 1 ;    //initial to the last cell
            IntNodeTwo rightNode = _tail ; 

            while (leftNode != rightNode) {      // Will run until they meet in the middle
                if(leftNode.getNum() % 2!=0)              //check if the left cell is off number
                    return right ;              //if its odd number , odd-odd = even ,so return its place
                else if ( rightNode.getNum() %2 != 0 )    //check if the right cell is off number 
                    return right;               //if its odd number , odd-odd = even ,so return its place 
                else {                          //if none is off number then move towards the center
                    right--;                            //moving the right side backwards
                    rightNode = rightNode.getPrev(); 
                    left++;                             //moving the left side forward
                    leftNode = leftNode.getNext();
                }
            }
        }
        return 0 ; //if there is no answer it returns 0
    }

    /**
     * The method checks if there is a sublist in the list that as the average that equals the given number  
     *
     * Time complexity = o(n)
     * Space complexity = o(1)
     * 
     * @param  num  the average that we need to find in the list
     * @return boolean if there is a sublist in the list that as the average that equals the given number  
     */

    public boolean isAverage(double num){
        if(_head == null)                           //checking if the list is empty
            return false;                           //returns false if its empty
        IntNodeTwo lowNode = _head;
        IntNodeTwo highNode = _tail;
        int sum = sum();                            //sum of all numbers in the list 
        int length = length();                      //counter of the amount of numbers in the list 
        double average = ((double)sum)/length;      //the calculation for average
        while(lowNode != highNode)                  //we will have to start looking for a sublist inside the list: 
        {
            if(average == num)                      //if the avg == num it returns true because we found it
                return true;
            if(average < num)                       //if the average is smaller than the given num,we will have to start removing numbers from the left side
            {                                       //in order to make the average bigger
                length -= 1;                        //we remove numbers slowly from the left side because it will make the sum bigger and the length smaller
                sum -= lowNode.getNum();            //and that means -> bigger average that might be equal to the given num
                lowNode = lowNode.getNext();
            }    
            if(average > num)                       //if the average is bigger than the given num,we will have to start removing numbers from the right side
            {                                       //in order to make the average smaller
                length -= 1;                        //we remover numbers slowly from the right side because it will make the sum smaller and the length bigger
                sum -= highNode.getNum();           //and that means -> smaller average that might be equal to the given num
                highNode = highNode.getPrev();
            }      
            // calculating average and moving on
            average = ((double)sum)/length;
        }
        return false;       //returns false if there is no average that found to be equal to the given num
    }
}
//end of class 