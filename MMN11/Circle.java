import java.util.Scanner;   
/*This class named circle will calculate the areas and the perimeters of the excircle and the incircle of a given rectangle, the rectangle coardinates will be given 
in an input from the user.
*/
public class Circle
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);                           
        System.out.println ("this program calculates the areas" +        
                            " and the perimeters of the excircle and the incircle" +
                            " of a given rectangle" );
        System.out.print("Please enter the two coordinates of the" +   
                         " left-upper point of the rectangle");
        int leftUpX = scan.nextInt();                                  
        int leftUpY = scan.nextInt();
        System.out.print("Please enter the two coordinates of the" +   
                         " right-lower point of the rectangle");
        int rightDownX = scan.nextInt();                               
        int rightDownY = scan.nextInt();
        final double Pi = 3.141;                 //in math, in order to make calculations with the shape of the circle we need to use the variable pi
        double inRadius ,inArea , inPerimeter;     //declaration of the variables we will use in order to calculate the radius,area and perimeter inside the circle       
        inRadius =(leftUpY-rightDownY)/2;          //math calculation for the radius of the incircle
        inArea = Pi *(Math.pow(inRadius , 2 ));    //math calculation for the area of the incircle
        inPerimeter = 2 * Pi * inRadius ;          //math calculation for the perimeter of the incircle
        double exRadius , exArea , exPerimeter , distance ,totalX , totalY ; 
        totalX = Math.pow((leftUpX-rightDownX), 2 );      //in order to find the distance of the excircle, we will have to calculate it using the distance formula
        totalY = Math.pow((leftUpY-rightDownY), 2 );      
        distance = Math.sqrt(totalX+totalY) ;             //using the distance formula
        exRadius = distance/2 ;                           
        exArea = Pi *(Math.pow(exRadius , 2 ));     
        exPerimeter = 2 * Pi * exRadius ;           
        System.out.println("Incircle: radius =" +  inRadius + ", area = " + inArea + ", perimeter = " + inPerimeter);
        System.out.println("Excircle: radius =" +  exRadius + ", area = " + exArea + ", perimeter = " + exPerimeter);
        
    }            //end of method main                                                 
}                //end of class Circle