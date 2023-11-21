/*
This class named Point3D
In this program we will represent a dot in the 3D space that is defined by 3 coordinates , (x,y,z) .
*/
/**
 * This class represents a three-dimensional point the x,y and z coordinate values can get either negative, positive or zero double values.
 * @author Natali lev
 * @version 25-03-2019
 */
public class Point3D
{
    private double _x;
    private double _y;
    private double _z;
    final int Two = 2;
    
    /**
    * Constructs and initializes a Point3D to (0,0,0).
    */
    public Point3D()
    {
        this._x = 0;
        this._y = 0;
        this._z = 0;
    }
    
    /**
    * Constructs and initializes a Point3D from the specified xyz coordinates.
    * @param x  the x coordinate
    * @param y  the y coordinate
    * @param z  the z coordinate
    */
    
    public Point3D(double x, double y, double z)
    {   
        this._x = x;
        this._y = y;
        this._z = z;   
    }
    
    /**
    * Constructs and initializes a Point3D from the specified Point3D.
    * @param other  the Point3D which the new instance initialization will be based on
    */
    
    public Point3D(Point3D other)
    {
       this._x=other._x;
       this._y=other._y;
       this._z=other._z;
    }
    
    /**
     * returns the x coordinate
     * @return the value of the x coordinate
     */
    
    public double getX()
    {
        return this._x;
    }
    
    /**
    * returns the y coordinate
    * @return the value of the y coordinate
    */
    
    public double getY()
    {
        return this._y;
    }
    
    /**
    * returns the z coordinate
    * @return the value of the z coordinate
    */
    
    public double getZ()
    {
        return this._z;
    }
    
    /**
     * sets the x coordinate to the given x
     * @param the  x value to set
     */
    
    public void setX(double num)
    {
        this._x = num;
    }
    
    /**
     * sets the y coordinate to the given y
     *  @param the  y value to set
     */
    
    public void setY(double num)
    {
        this._y = num;
    }
    /**
     * sets the z coordinate to the given z
     * @param the  z value to set
     */
    
    public void setZ(double num)
    {
        this._z = num;
    }
    /**
     * Returns a string representation of this Point3D.
     */
    
    public String toString() 
    {
        return "("+this._x+","+this._y+","+this._z+")";
    }
    
    /**
     * Determines whether or not two points are equal.
     * @param other  a Point3D object to be compared with this Point3D
     */
    public boolean equals(Point3D other) 
    {
        if ((this._x == other._x)&&(this._y == other._y)&&(this._z == other._z))
            return true;
        return false;
    }
    
    /**
     * Checks if this point is above the other point.
     * @param other The point to check whether this point is above it
     * @return true if this point is above the other point, false otherwise
     */
    public boolean isAbove(Point3D other)
    {
        if(this._z > other._z)
            return true;
        return false;
    }
    
    /**
     * Checks if this point is under the other point.
     * @param other - The point to check whether this point is under i
     * @return true if this point is under the other point, false otherwise
     */
    public boolean isUnder(Point3D other)
    {
        return other.isAbove(this);
    }
    
    /**
     * Checks if this point is to the left of the other point.
     * @param other  The point to check whether this point is left of it
     * @return true if this point is to the left of the other point, false otherwise
     */
    public boolean isLeft(Point3D other)
    {
        if(this._y<other._y)
            return true;
        return false;
    }
    
    /**
     * Checks if this point is to the right of the other point.
     * @param other  The point to check whether this point is right of it
     * @return true if this point is to the right of the other point, false otherwise
     */
    public boolean isRight(Point3D other)
    {
        return other.isLeft(this);
    }
    
    /**
     * Checks if this point is behind the other point.
     * @param other  The point to check whether this point behind it
     * @return true if this point is behind the other point, false otherwise
     */
    public boolean isBehind(Point3D other)
    {
        if(this._x<other._x)
            return true;
        return false;
    }
    
    /**
     * Checks if this point is in front of the other point.
     * @param other - The point to check if this point is in front of it
     * @return true if this point is in front of the other point, false otherwise
     */
    public boolean isInFrontOf(Point3D other)
    {
        return other.isBehind(this);
    }
    
    /**
     * Moves the Point3D in location (x,y,z), by dx along the x axis, by dy along the y axis and dz along the z axis so that it now represents the Point3D in the following 3D coordintes (x+dx,y+dy,z+dz).
     * @param dx  the addtion for coordinate x value
     * @param dy  the addtion for coordinate y vlaue
     * @param dz  the addtion for coordinate z value
     */
    public void move(double dx,double dy,double dz)
    {
        this._x+=dx;
        this._y+=dy;
        this._z+=dz;
    }
    
    /**
    * Returns the distance between this point and other point p.
    * @param p  the other point
    */
    public double distance(Point3D p)
    {
        double totalX = Math.pow((this._x-p._x), Two );      //calculating the distance
        double totalY = Math.pow((this._y-p._y), Two );
        double totalZ = Math.pow((this._z-p._z), Two );
        double distanceP = Math.sqrt(totalX+totalY+totalZ) ;            
        return distanceP ;
    }
}
//end of class Point3D