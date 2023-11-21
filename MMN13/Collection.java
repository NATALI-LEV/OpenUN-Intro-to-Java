/**
 * This class represent a collection (an array) of boxes that are created by the classes "Point3D" and Box3D.
 *
 * @author Natali lev
 * @version 20/04/2019
 */
public class Collection {
    //building the attributes
    private Box3D[] _boxes;
    private int _noOfBoxes;
    private final int MAX_NUM_BOXES = 100;
    private final int ZERO = 0;

    /**
     * Constructs the class' attributes so the boxes array will be sorted and the length of the array will be max.
     */
    public Collection() {
        _boxes = new Box3D[MAX_NUM_BOXES];
        _noOfBoxes = ZERO;
    }

    //A method that moves the array so there wont be "empty spots" in it after we add a box.
    private void moveArray(int index) {
        for (int i = _noOfBoxes; i > index; i--) {
            _boxes[i] = new Box3D(_boxes[i - 1]);
        }
    }

    /**
     * Adds a new box to the array
     * @param _base   the base point of the box
     * @param _length the length of the box
     * @param _width  the width of the box
     * @param _height the height of the box
     * @return true if its possible to add the box to the array , otherwise , returns false if its full.
     */
    public boolean addBox(Point3D _base, int _length, int _width, int _height) {
        Box3D newBox = new Box3D(_base, _length, _width, _height);
        if (_noOfBoxes == MAX_NUM_BOXES)
            return false;
        else {
            int suitableIndex = ZERO;
            int i = 0;
            boolean run = false;
            while (i < _noOfBoxes && run == false) {
                if (_boxes[i].getVolume() >= newBox.getVolume()) {
                    suitableIndex = i;
                    run = true;
                }
                i++;
            }

            if(suitableIndex == 0){
                if(_noOfBoxes > 0 && _boxes[0].getVolume() >= newBox.getVolume())
                    suitableIndex = ZERO;
                else
                    suitableIndex = _noOfBoxes;
            }

            moveArray(suitableIndex);
            _boxes[suitableIndex] = new Box3D(newBox);
            _noOfBoxes++;
            return true;
        }
    }

    /**
     * Checks which box in the array as the most upper base corner.
     * @return mostUpperBaseCorner the box that has the highest base corner.
     */
    public Box3D mostUpperBaseCorner() {
        Box3D maxBaseCornerIndex = new Box3D();
        if (_noOfBoxes == ZERO)
            return null;
        else {
            for (int i = 0; i < _noOfBoxes; i++) {
                if (_boxes[i].getBase().isAbove(maxBaseCornerIndex.getBase()))
                    maxBaseCornerIndex = new Box3D(_boxes[i]);
            }
            return maxBaseCornerIndex;
        }
    }

    /**
     * A method that sums up all the results of surface-areas of all boxes in the array
     * @return sumOfSurfaceAreas the result of the total surface area.
     */
    public double totalSurfaceArea() {
        double sumOfSurfaceAreas = ZERO;
        for (int i = 0; i < _noOfBoxes; i++) {
            sumOfSurfaceAreas += (double) _boxes[i].getSurfaceArea();
        }
        return sumOfSurfaceAreas;
    }

    /**
     * Checks which 2 boxes in the array has the longest distance between them and calculates the distance.
     * @return LongestDistance thats the longest distance that we found.
     */
    public double longestDistance() {

        double LongestDistance = ZERO;
        if (_noOfBoxes < 2)
            return 0;
        else {
            for (int i = 0; i < _noOfBoxes; i++) {
                for (int j = 0; j < _noOfBoxes; j++) {
                    if (_boxes[i].distance(_boxes[j]) > LongestDistance)
                        LongestDistance = _boxes[i].distance(_boxes[j]);
                }
            }
            return LongestDistance;
        }
    }

    /**
     * Counts how many boxes in the array can contain the given box.
     * @param box we will check how many boxes in the array can contain that box.
     * @return counter that counts the number of boxes in the array that contain the given box.
     */
    public int howManyContains(Box3D box) {
        int counter = ZERO;
        for (int i = 0; i < _noOfBoxes; i++) {
            if (_boxes[i].contains(box) == true)
                counter++;
        }
        return counter;
    }

    /**
     * A method that checks which box outside the range of i-j indexes ,has the smallest volume and can contain all the boxes within the range of i -> j in the array.
     * @param i the index that shows the beginning of the range.
     * @param j the index that shows the end of the range.
     * @return the value of the volume of the box that can contain all boxes within i -> j range.
     */
    public int volumeOfSmallestBox(int i, int j) {
        if ((i < 0) || (j < 0) || (i >= MAX_NUM_BOXES) || (j >= MAX_NUM_BOXES) || (i >= _noOfBoxes) || (j >= _noOfBoxes))
            return 0;

        int min, max;
        if (i <= j) {
            min = i;
            max = j;
        } else {
            min = j;
            max = i;
        }

        int maxHeight = ZERO, maxLength = ZERO, maxWidth = ZERO;
        for (int k = min; k <= max; k++) {
            if (_boxes[k].getHeight() >= maxHeight)
                maxHeight = _boxes[k].getHeight();
            if (_boxes[k].getWidth() >= maxWidth)
                maxWidth = _boxes[k].getWidth();
            if (_boxes[k].getLength() >= maxLength)
                maxLength = _boxes[k].getLength();
        }
        return ((maxHeight + 1) * (maxLength + 1) * (maxWidth + 1));
    }

    /**
     * Makes a new array that is a copy of the "this" array.
     * @return newBoxes a new copy of the array.
     */
    public Box3D[] getBoxes() {
        Box3D[] newBoxes = new Box3D[_noOfBoxes];
        for (int i = 0; i < _noOfBoxes; i++) {
            newBoxes[i] = new Box3D(this._boxes[i]);
        }
        return newBoxes;
    }

    /**
     * Returns the number of boxes that are in the array of boxes.
     * @return the number of boxes in the array.
     */
    public int getNumOfBoxes() {
        return _noOfBoxes;
    }

    /**
     * Returns a string representation of this Box3D object.
     */
    public String toString() {
        String boxes = "";
        for (int i = 0; i < _noOfBoxes; i++) {
            boxes += "Box no. " + (i + 1) + ":" + " " + _boxes[i].toString() + "\n";
        }
        return boxes;
    }

}
//end of class Collection 