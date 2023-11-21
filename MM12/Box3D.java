/*
This class named Box3D
this program This class represents a three-dimensional box ,The box is represented by its lower-left-front point and three integers for the length (x axis), 
width (y axis) and height (z axis) of the box. the box dimensions must be equal or greater than 1.
*/
/**
* Write a description of class Box3D here.
* This class represents a three-dimensional box 
* The box is represented by its lower-left-front point 
* and three integers for the length (x axis), 
* width (y axis) and height (z axis) of the box. 
* the box dimensions must be equal or greater than 1.
* @author Natali lev
* @version 06/04/2019
*/    
public class Box3D
{ 
    private Point3D _base;
    private int _length; //x
    private int _width;  //y
    private int _height; //z
    final double DEFAULTBASE = 0;       //we were told to use finals if we need to use numbers
    final int Two = 2;
    final int DEFAULTDIMENSIONS = 1;
            
    /**
     * Constructs and initializes a box with a default base point and all dimensions to 1.
     */
    public Box3D()
    {
        this._base=new Point3D();
        this._length = DEFAULTDIMENSIONS;
        this._width =  DEFAULTDIMENSIONS;
        this._height = DEFAULTDIMENSIONS;
    }
    /**
     * Constructs and initializes a box object from a given 
     * base point and 3 integers as the dimentions of the Box
     * @param p the base point of the box
     * @param length the length of the box
     * @param width the width of the box
     * @param height the height of the box
     */
    public Box3D(Point3D p,int length,int width,int height)
    {   
        this._base=new Point3D(p);              // Prevent  aliasing
        if(length > 0)                          //making sure the number wont be negative number
            this._length = length;
        else                                    //if its negative - we were told to put the value 1 as a default 
            this._length = DEFAULTDIMENSIONS;
        if(width > 0)
            this._width =  width;
        else
            this._width = DEFAULTDIMENSIONS;
        if(height > 0)
            this._height = height;
        else
            this._height = DEFAULTDIMENSIONS; 
    }
    /**
     * Constructs and initializes a Box3D object from a given Box3D.
     * @param other the box to copy from. Contains the initialization of 
     * the base point and all dimentions.
     */
    public Box3D(Box3D other)
    {
        this._base=new Point3D(other._base);        // Prevent  aliasing
        this._length=other._length;
        this._width=other._width;
        this._height=other._height;
    }
    
    /**
     * returns the length dimension
     * @return the length of the box
     */
    public int getLength()
    {
        return this._length;
    }
    
    /**
     * returns the width dimension
     * @return the width of the box
     */
    public int getWidth()
    {
        return this._width;
    }
    
    /**
     * returns the height dimension
     * @return the height of the box
     */
    public int getHeight()
    {
        return this._height ;
    }
    
    /**
     * returns the lower-left-front (base) Point3D of the box
     * @return the base point of the box
     */
    public Point3D getBase()
    {
        return new Point3D(this._base); // Prevent  aliasing
    }
           
    
    /**
     * Sets the length of the box only if the given 
     * value is equal or greater than 1.
     * @param num the length to set
     */
    public void setLength(int num)
    {   
            if(num>0)
                this._length = num;
    }
            
    /**
     * Sets the width of the box only if the given 
     * value is equal or greater than 1.
     * @param num the width to set
     */
    public void setWidth(int num)
    {   
        if(num>0)
            this._width = num;
    }

    /**
     * Sets the height of the box only if the given 
     * value is equal or greater than 1.
     * @param num the height to set
     */
    public void setHeight(int num)
    {
        if(num>0)
            this._height = num;
    }
            
    /**
     * Sets the base point of the box
     * @param otherBase the Point3D to set
     */
    public void setBase(Point3D otherBase)
    {   
        _base = new Point3D(otherBase) ;            // Prevent  aliasing
        
    }
            
    /**
     * Returns a string representation of this Box3D object.
     */
    public String toString() 
    {       
        return "The base point is "+ _base.toString() +", length = "+this._length+", width = "+ this._width+", height = "+this._height;
    }                                                          
            
    /**
     * Determines whether or not the two boxes are equal.
     * @param other a Box3D object to be compared with this Box3D
     */
    public boolean equals(Box3D other)
    {
        boolean isEqual = true;
        if((this._base.equals(other._base))&&(this._length==other.getLength())&&(this._width==other.getWidth())&&(this._height==other.getHeight()))
            return isEqual;
        else   
            return isEqual=false;
                    
    }
            
    /**
     * Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) 
     * without changing the box dimensions
     * @return the new box in its new location
     */
    public Box3D move(double dx,double dy,double dz)
    {   
        Box3D other = new Box3D(this);          // Prevent  aliasing
        other._base.move(dx,dy,dz);             //using the "move" method on the Point3D class in order to move the box
        return other ;
    }
            
    /**
     * Calculates and returns the upper-right-back point of this box
     * @return the upper-right-back point of this box
     */
    public Point3D getUpRightBackPoint()
    {   
        Point3D upRightPoint = new Point3D();       // Prevent  aliasing
        upRightPoint.setX(_base.getX() - this._length);
        upRightPoint.setY(_base.getY() + this._width); 
        upRightPoint.setZ(_base.getZ() + this._height);                     
        return upRightPoint ;
    }
            
    /**
     * Calculates and returns the center point of the box
     * @return the center point of the box
     */
    public Point3D getCenter()
    {   
        //calculating the center point of the box
        return new Point3D ((_base.getX() - (double)this._length/Two),(_base.getY() + (double)this._width/Two),(_base.getZ() + (double)this._height/Two));
    }
            
    /**
     * Computes the distance between two boxes based on the 
     * distance of their center points.
     * @return the distance between two Box3D objects
     */
    public double distance(Box3D other)
    {   
        return getCenter().distance(other.getCenter());
    }
            
    /**
     * Computes the volume of the box.
     * @return volume of the Box3D object
     */
    public int getVolume()
    {   
        //calculating the volume
        int volume = this._length*this._width*this._height;
        return volume;
    }
            
    
    /**
     * Computes the surface area of a box.
     * @return the surface area of a Box3D object
     */
    public int getSurfaceArea()
    {   
        //calculating the surfacearea
        int SurfaceArea = Two*this._length*this._width + Two*this._length*this._height + Two*this._width*this._height;  
        return SurfaceArea;
    }
            
    
    /**
     * Determines whether this box has a greater volume in compare to other box.
     * @param other a Box3D object whose volume will be compared with the volume of this Box3D
     */
    public boolean isLargerCapacity(Box3D other)
    {
        if (this.getVolume() > other.getVolume())   //checking if this box has a greater volume in compare to the other box
        {
            return true;
        }
        else return false;
    }
            
    /**
     * Determines whether this box can contain the other box.
     * @param other a Box3D object to check if it can be contained within this box  
     */
    public boolean contains(Box3D other)
    {
        if ((this._length > other.getLength())&&(this._width > other.getWidth())&&(this._height > other.getHeight())&&(this.getSurfaceArea()>other.getSurfaceArea()))
            return true;
        else
            return false;
    }
    
    
    /**
     * Checks if this box is above the other box
     * @param other The box to check if this box is above it
     * @return true if this box is above the other box, false otherwise
     */
    public boolean isAbove(Box3D other)
    {
         if (this._base.isAbove(other.getUpRightBackPoint()))       //checking if this box is above ther other box
            return true;
         else 
            return false;
         
    }
}
//end of class Box3D