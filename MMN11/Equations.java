import java.util.Scanner;   
/*
The program receive 6 numbers as an input , then builds an equation and solve it, if there is a single solution it will print the solution, if there is no solution
or there are many solutions it will print a massage according to it */
public class Equations
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);                           
        System.out.println ("This program solves a system of 2 linear equations"); //Asking the user to put an input of 6 numbers
        System.out.println ("Enter the coefficients a11 a12 a21 a22 b1 b2 : ");
        double xResult1 , xResult2;                                             //Declaring the variables we will use
        int a11 = scan.nextInt();                                  
        int a12 = scan.nextInt();
        int a21 = scan.nextInt();                                  
        int a22 = scan.nextInt();
        int b1 = scan.nextInt();                                  
        int b2 = scan.nextInt();
        System.out.println ("Eq1: "+ a11+"*x1+"+a12+"*x2=" + b1 );              //Prints the equations
        System.out.println ("Eq2: "+ a21+"*x1+"+a22+"*x2=" + b2 );
        if (((a11*a22)-(a12*a21))!=0)   //Checking if its a single solution
        {
            xResult1 = ((double)((b1*a22)-(b2*a12))/((a11*a22)-(a12*a21)));     //Solving the equations and rounding it to 3 decimales after the dot
            xResult2 = ((double)((b2*a11)-(b1*a21))/((a11*a22)-(a12*a21))); 
            xResult1 = (double) Math.round (xResult1 * 1000) / 1000 ;
            xResult2 = (double) Math.round (xResult2 * 1000) / 1000 ;
            System.out.println ("Single solution: (" + xResult1 + "," + xResult2 + ")"  ); //Printing the single solution
        }
        else if ((((b2*a11) - (b1*a21))==0) && (((b1*a22)-(b2*a12))==0) && !((b1 != 0) && (a11 == 0) && (a12 == 0))&& !((b2 != 0)&& (a21 == 0) &&(a22 == 0)))
        {                               //Checking if its a situation where there are many solutions 
            System.out.println("Many solutions");
        }
        else
        {                               //Checking if its a situation where there is no solution
            System.out.println("No solutions");
        }
         
    }            //end of method main                                                 
}                //end of class Circle