
/**
 * This class represent a Matrix that contains int numbers between 0-255.
 *
 * @author Natali Lev
 * @version 20/04/2019
 */
public class Matrix {
    //building the attributes
    private int[][] _mat;
    private final int MAX_MATRIX_VALUE = 255;
    private final int FOUR = 4;
    private final int TWO = 2;
    private final int ZERO = 0; 

    /**
     * Constructs a Matrix from a two dimensional array,
     * the dimensions as well as the vallues of this matrix will be the same as teh dimensions and values of the two-dimensional array.
     * @param array the array[][] we will be using in order to construct a matrix.
     */
    public Matrix(int[][] array) {
        this._mat = new int[array.length][array[0].length];
        for (int row = 0; row < _mat.length; row++) {
            for (int col = 0; col < _mat[row].length; col++) {
                _mat[row][col] = array[row][col];
            }
        }
    }

    /**
     * Constructs a size1 by size2 matrix of zeroes.
     * @param size1 represents the rows of the new matrix.
     * @param size2 represents the columns of the new matrix.
     */
    public Matrix(int size1, int size2) {
        _mat = new int[size1][size2];
        for (int row = 0; row < _mat.length; row++) {
            for (int col = 0; col < _mat[row].length; col++) {
                _mat[row][col] = ZERO;
            }
        }
    }

    /**
     * Returns a string representation of the matrix object.
     */
    public String toString() {
        String mat = "";
        for (int row = 0; row < _mat.length; row++) {
            for (int col = 0; col < _mat[row].length; col++) {
                mat += _mat[row][col];
                if (col < _mat[0].length - 1)
                    mat += "\t";
            }
            mat += "\n";
        }
        return mat;
    }

    /**
     * A method that creates the "negative" matrix to the matrix of this class, every number changes to the number that will complete it to 255.
     * @return Matrix(arrayNegative) returns the object matrix which is negative.
     */
    public Matrix makeNegative() {
        int[][] arrayNegative = new int[_mat.length][_mat[0].length];
        for (int row = 0; row < arrayNegative.length; row++) {
            for (int col = 0; col < arrayNegative[row].length; col++) {
                arrayNegative[row][col] = MAX_MATRIX_VALUE - _mat[row][col];
            }
        }
        return new Matrix(arrayNegative);

    }

    /**
     * A method that gets a matrix, and 2 indexes that represent a location of a cell, and then calculates the average of it with its neighbors.
     * @param i represents the row of the cell.
     * @param j represents the col of the cell.
     * @return avg the final result , the average of the number in the cell and its neighbors.
     */
    private int avgNeighbors(int[][] mat, int i, int j) {
        int sum = ZERO;
        int numOfNeightbors = ZERO;
        int avg = ZERO;

        if (mat.length == 1) {
            if (j == 0) {
                sum += mat[i][j] + mat[i][j + 1];
                numOfNeightbors = 2;
            } else if (j == mat[i].length - 1) {
                sum += mat[i][j] + mat[i][j - 1];
                numOfNeightbors = TWO;
            } else {
                for (int col = j - 1; col < j + 2; col++) {
                    sum += mat[i][col];
                    numOfNeightbors++;
                }
            }
            return sum / numOfNeightbors;

        } else if (mat[i].length == 1) {
            if (i == 0) {
                sum += mat[i][j] + mat[i + 1][j];
                numOfNeightbors = TWO;
            } else if (i == mat.length - 1) {
                sum += mat[i][j] + mat[i - 1][j];
                numOfNeightbors = TWO;
            } else {
                for (int row = i - 1; row <= i + 1; row++) {
                    sum += mat[row][j];
                    numOfNeightbors++;
                }
            }
            return sum / numOfNeightbors;
        } else if ((i > 0) && (i < mat.length - 1) && (j > 0) && (j < mat[0].length - 1)) {
            for (int row = i - 1; row < i + 2; row++) {
                for (int col = j - 1; col < j + 2; col++) {
                    sum += mat[row][col];
                    numOfNeightbors++;
                }
            }
            avg = sum / numOfNeightbors;

        } else if ((i == 0) && (j == 0)) {
            avg = (mat[i][j] + mat[i][j + 1] + mat[i + 1][j] + mat[i + 1][j + 1]) / FOUR;
        } else if ((i == 0) && (j == mat[i].length - 1)) {
            avg = (mat[i][j] + mat[i][j - 1] + mat[i + 1][j - 1] + mat[i + 1][j]) / FOUR;
        } else if ((i == mat.length - 1) && (j == 0)) {
            avg = (_mat[i][j] + _mat[i - 1][j] + _mat[i - 1][j + 1] + _mat[i][j + 1]) / FOUR;
        } else if ((i == mat.length - 1) && (j == mat[i].length - 1)) {
            avg = (_mat[i][j] + _mat[i - 1][j] + _mat[i - 1][j - 1] + _mat[i][j - 1]) / FOUR;

        } else if ((i == 0) && (j > 0) && (j < mat[i].length - 1)) {
            for (int row = i; row < i + 2; row++) {
                for (int col = j - 1; col < j + 2; col++) {
                    sum += mat[row][col];
                    numOfNeightbors++;

                }
            }
            avg = sum / numOfNeightbors;

        } else if ((j == 0) && (i > 0) && (i < mat.length - 1)) {
            for (int row = i - 1; row < i + 2; row++) {
                for (int col = j; col < j + 2; col++) {
                    sum += mat[row][col];
                    numOfNeightbors++;
                }
            }
            avg = sum / numOfNeightbors;
        } else if ((j == mat[i].length - 1) && (i > 0) && (i < mat.length - 1)) {
            for (int row = i - 1; row < i + 2; row++) {
                for (int col = j - 1; col < j + 1; col++) {
                    sum += mat[row][col];
                    numOfNeightbors++;
                }
            }
            avg = sum / numOfNeightbors;

        } else if ((i == mat.length - 1) && (j > 0) && (j < mat[i].length - 1)) {
            for (int row = i - 1; row < i + 1; row++) {
                for (int col = j - 1; col < j + 2; col++) {
                    sum += mat[row][col];
                    numOfNeightbors++;
                }
            }
            avg = sum / numOfNeightbors;

        }
        return avg;
    }

    /**
     * A method that filters every cell in the matrix into the number that represents the average of itself along with its neighbors,
     * the method is using the method "avgNeighbors" in order to calculate the average .
     * @return Matrix(filteredMatrix) returns the object matrix which is now filtered with the average numbers of each cell and its neighbors.
     */
    public Matrix imageFilterAverage() {
        int[][] filteredMatrix = new int[_mat.length][_mat[0].length];
        for (int i = 0; i < _mat.length; i++) {
            for (int j = 0; j < _mat[i].length; j++) {
                filteredMatrix[i][j] = avgNeighbors(_mat, i, j);
            }
        }
        return new Matrix(filteredMatrix);
    }

    /**
     * A method that rotates a matrix by 90 degrees in clockwise (the sizes of the array might be changed because of the rotation).
     * @return Matrix(rotatedMatClockwise) returns the object matrix which is rotated clockwise by 90 degrees.
     */
    public Matrix rotateClockwise() {
        int[][] rotatedMatClockwise = new int[_mat[0].length][_mat.length];
        for (int i = 0; i < _mat[0].length; ++i) {
            for (int j = 0; j < _mat.length; ++j) {
                rotatedMatClockwise[i][j] = _mat[_mat.length - j - 1][i];
            }
        }
        return new Matrix(rotatedMatClockwise);
    }

    /**
     * A method that rotates a matrix by 90 degrees in counter direction to clockwise (the sizes of the array might be changed because of the rotation).
     * @return Matrix(rotatedMatClockwise) returns the object matrix which is rotated to counter clockwise direction by 90 degrees.
     */
    public Matrix rotateCounterClockwise() {
        int[][] rotatedMatClockwise = new int[_mat[0].length][_mat.length];

        for (int i = 0; i < _mat[0].length; ++i) {
            for (int j = 0; j < _mat.length; ++j) {

                rotatedMatClockwise[i][j] = _mat[j][_mat[0].length - i - 1];
            }
        }
        return new Matrix(rotatedMatClockwise);
    }
}
//end of class 