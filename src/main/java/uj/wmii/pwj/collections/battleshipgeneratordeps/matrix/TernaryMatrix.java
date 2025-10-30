package uj.wmii.pwj.collections.battleshipgeneratordeps.matrix;

public class TernaryMatrix {

    private int[][] data;

    public TernaryMatrix() {
        data = new int[0][0];
    }

    public TernaryMatrix(int width, int height) {
        data = new int[height][width];
    }

    public TernaryMatrix(TernaryMatrix toCopy) {
        data = new int[toCopy.getHeight()][toCopy.getWidth()];
        for (int row = 0; row < toCopy.getHeight(); row++) {
            for (int col = 0; col < toCopy.getWidth(); col++) {
                data[row][col] = toCopy.getCell(row, col);
            }
        }
    }

    public int getWidth() {
        if (data.length == 0) return 0;
        return data[0].length;
    }

    public int getHeight() {
        return data.length;
    }

    public void validateCoordinates(int row, int col) {
        if (row < 0) throw new ArrayIndexOutOfBoundsException("Row index (" + row + ") is negative");
        if (col < 0) throw new ArrayIndexOutOfBoundsException("Column index (" + col + ") is negative");
        if (row >= getHeight()) throw new ArrayIndexOutOfBoundsException("Row index (" + row + ") is greater or equal to matrix height (" + getHeight() + ")");
        if (col >= getWidth())  throw new ArrayIndexOutOfBoundsException("Column index (" + col + ") is greater or equal to matrix width (" + getWidth() + ")");
    }

    public int getCell(int row, int col) {
        validateCoordinates(row, col);
        return data[row][col];
    }

    public void setCell(int row, int col, int value) {
        validateCoordinates(row, col);
        data[row][col] = value;
    }

    public void trim() {
        int minRow = getHeight();
        int minCol = getWidth();
        int maxRow = -1;
        int maxCol = -1;
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                if (data[row][col] != 0) {
                    if (row < minRow) minRow = row;
                    if (col < minCol) minCol = col;
                    if (row > maxRow) maxRow = row;
                    if (col > maxCol) maxCol = col;
                }
            }
        }
        if (minRow > maxRow) {
            data = new int[0][0];
        }
        else {
            int[][] tempData = new int[maxRow - minRow + 1][maxCol - minCol + 1];
            for (int row = minRow; row <= maxRow; row++) {
                System.arraycopy(data[row], minCol, tempData[row - minRow], 0, maxCol + 1 - minCol);
            }
            data = tempData;
        }
    }

    public void extend() {
        int[][] tempData =  new int[getHeight() + 2][getWidth() + 2];
        for (int row = 0; row < getHeight(); row++) {
            System.arraycopy(data[row], 0, tempData[row + 1], 1, getWidth());
        }
        data = tempData;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof TernaryMatrix otherMatrix)) return false;
        if (getHeight() != otherMatrix.getHeight()) return false;
        if (getWidth() != otherMatrix.getWidth()) return false;
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                if (data[row][col] != otherMatrix.data[row][col]) return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (getHeight() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < getHeight(); row++) {
            sb.append("[ ");
            for (int col = 0; col < getWidth(); col++) {
                sb.append(data[row][col]);
                sb.append(", ");
            }
            sb.append("]\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
