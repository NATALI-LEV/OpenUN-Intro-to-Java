/**
 * This class contains the answers to Maman 14 :)
 * @author Natali lev
 * @version 01/06/2019
 */
public class Ex14
{  
    /**
     *
     * Question 1 :
     *
     * Time complexity = o(n)
     * Space complexity = o(1) .
     *
     */

    /**
     *
     * The method recieves an array of heights that represents water volume in each day , then it sums up the total sum of rain.
     *
     * @param heights the array that contains the amount of rain in each day.
     * @return returns totalSumOfRain which is the sum of the rain that is symbolized by the array.
     */
    public static int waterVolume(int[] heights) {
        int left = 0, right = heights.length - 1;       //declaring the pointers that will help us sum up the amount of rain
        int maxLeft = 0, maxRight = 0;
        int totalSumOfRain = 0;                         //the final result will be summed up in that variable 
        while (left <= right) {             //checking that left side isnt bigger than right side of the array
            if (heights[left] < heights[right]) {       
                if (heights[left] >= maxLeft) maxLeft = heights[left];  //summing up rain after making sure that the condition allows water to be contained between
                else totalSumOfRain += maxLeft - heights[left];         //the left side and the right side and then,
                left++;                                                 //moving ahead with left++ .
            } else {
                if (heights[right] >= maxRight) maxRight = heights[right];      //doing the same just for the opposite direction 
                else totalSumOfRain += maxRight - heights[right];
                right--;
            }
        }
        return totalSumOfRain;          //returns the total sum of rain.
    }

    /**
     *
     * Question 2:
     *
     * A) The method returns the number of continuous cells that their sum is even.
     *
     * B) Time complexity = o(n^3)
     *    Space complexity = o(1) .
     *
     * C) Done.
     *
     * D) Time complexity = o(n)
     *    Space complexity = o(1) .
     *
     */

    /**
     * A method that recieves an array and returns the number of continuous cells that their sum is even.
     *
     * @param a the array that will be checked
     * @return returns the number of continuous cells that their sum is even.
     */
    public static int what(int [] a)
    {
        int sum = 0 ;
        
        //calculating the sum of the entire array
        for(int i = 0 ; i < a.length ; i++ )
        {
            sum += a[i];
        }
        
        //if the whole array is even return it's length 
        if(sum %2 == 0) 
            return a.length;
        else {
            int left = 0 ;              //initial to the first cell
            int right = a.length - 1 ;  //initial to the last cell

            while(left <= right) {              //will run until they meet in the middle 
                if(a[left] % 2!=0)              //check if the left cell is off number
                    return right ;              //if its odd number , odd-odd = even ,so return its place
                else if ( a[right] %2 != 0 )    //check if the right cell is off number 
                    return right;               //if its odd number , odd-odd = even ,so return its place 
                else {                          //if none is off number then move towards the center
                    right--;
                    left++;
                }
            }
        }
        return 0 ;
    }

    /**
     *
     * Question 3 :
     *
     */

    /**
     *
     * The method shows all the possible combinations for triplets that will sum the given number and prints all the possible equations.
     *
     * @param num  the given number.
     * @return all the possible combinations for triplets that will sum the given number.
     */
    public static int solutions(int num){

        if (( num>30 )||(num<3))
        {
            return 0 ;
        }

        else
        {
            return solutions(num , 1 ,1 ,1 , 0 );
        }

    }

    /**
     *
     * The method checks and shows all the possible combinations for triplets that will sum the given number
     *
     * @param num - the given number.
     * @param x1 - the variable x1.
     * @param x2 - the variable x2.
     * @param x3 - the variable x3.
     * @param counter - the counter that counts the number of results.
     * @return all the possible combinations for triplets that will sum the given number and prints the equations.
     */
    private static int solutions(int num , int x1, int x2, int x3 ,int counter)
    {

        if ( x1+ x2 + x3 == num )
        {
            System.out.println(x1 + " + " + x2 + " + " + x3) ;
            counter++;
        }
        if(x1==10)  //all the possible options until x1 will be 10
        {
            if(x2==10)  //all the possible options until x2 will be 10
            {
                if(x3==10)  //all the possible options until x3 will be 10
                {
                    return counter;
                }
                else
                {
                    x1=1;
                    x2=1;
                    return solutions(num,x1,x2,x3+1, counter);  //increase x3 by 1 
                }
            }
            else
            {
                x1=1;
                return solutions(num,x1,x2+1,x3,counter);       //increase x2 by 1 
            }
        }
        else
        {
            return solutions(num,x1+1,x2,x3,counter);           //increase x1 by 1 
        }
    }

    /**
     *
     * Question 4:
     *
     */
    /**
     * The function tries to create a path that will sum the given number parameter
     *
     * @param mat   The 2D array that will be searched
     * @param sum   The given sum number to reach
     * @param path  Will be marked as the path
     * @return a boolean that says if there is a possible path in the matrix that its sum is a given number, if so it will return true , otherwise - false.
     */
    public static boolean findSum(int mat[][], int sum, int path[][]) {
        return findSum(mat, path, sum, 0, 0);
    }

    private static boolean findSum(int[][] mat, int[][] path, int sum, int i, int j) {
        // Simulate nested loop, go through the rows and then columns
        if (i == mat.length - 1) {
            if (j == mat.length - 1) {
                return lookAround(mat, path, sum, i, j, 0); // last cell condition
            } else {
                // If it's not the last column
                i = 0;
                return lookAround(mat, path, sum, i, j, 0) ? true : findSum(mat, path, sum, i, j + 1);
            }
        } else {
            // If it's not the last row
            return lookAround(mat, path, sum, i, j, 0) ? true : findSum(mat, path, sum, i + 1, j);

        }
    }

    private static boolean lookAround(int[][] mat, int[][] path, int sum, int i, int j, int tempSum) {
        // If reached to the given sum, return true
        if (tempSum == sum)
            return true;
        // Checks array out of bounds
        if (j >= mat.length || i >= mat.length || i < 0 || j < 0)
            return false;

        // Checks if the cell has been marked before
        if (path[i][j] == 1)
            return false;

        tempSum += mat[i][j];   // Add to tempSum
        path[i][j] = 1;         // Mark the path

        boolean right = lookAround(mat, path, sum, i, j + 1, tempSum); // Recursive call with right neighbor
        boolean left = lookAround(mat, path, sum, i, j - 1, tempSum); // Recursive call with left neighbor
        boolean down = lookAround(mat, path, sum, i + 1, j, tempSum); // Recursive call with lower neighbor
        boolean up = lookAround(mat, path, sum, i - 1, j, tempSum); // Recursive call with upper neighbor

        boolean checkPath = right || left || up || down;
        if (!(checkPath)) {
            path[i][j] = 0;
        }
        return checkPath;
    }
} 
//end of class  