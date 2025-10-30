package uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino;

import uj.wmii.pwj.collections.battleshipgeneratordeps.matrix.BooleanMatrix;

import java.util.LinkedList;

public class BooleanMatrixPolyomino implements Polyomino {

    private final BooleanMatrix shape;
    private final int degree;

    public BooleanMatrixPolyomino() {
        shape = new BooleanMatrix();
        degree = 0;
    }

    public BooleanMatrixPolyomino(BooleanMatrix shape) {
        this.shape = new BooleanMatrix(shape);
        this.shape.trim();
        int tempDegree = 0;
        for (int row = 0; row < this.shape.getHeight(); row++) {
            for (int col = 0; col < this.shape.getWidth(); col++) {
                if (this.shape.getCell(row, col)) tempDegree++;
            }
        }
        this.degree = tempDegree;
    }

    @Override
    public int getWidth() {
        return shape.getWidth();
    }

    @Override
    public int getHeight() {
        return shape.getHeight();
    }

    @Override
    public int getDegree() {
        return degree;
    }

    @Override
    public BooleanMatrix toBooleanMatrix() {
        return new BooleanMatrix(shape);
    }

    private boolean canBeExtendedAt(int row, int col, BooleanMatrix extended) {

        if (row < 0) throw new IllegalArgumentException("Row must not be negative");
        if (col < 0) throw new IllegalArgumentException("Column must not be negative");
        if (row >= extended.getHeight()) throw new IllegalArgumentException("Row must not be greater or equal to rows number");
        if (col >= extended.getWidth()) throw new IllegalArgumentException("Column must not be greater or equal to columns number");

        if (extended.getCell(row, col)) return false;
        if (row - 1 >= 0 && extended.getCell(row - 1, col)) return true;
        if (row + 1 < extended.getHeight() && extended.getCell(row + 1, col)) return true;
        if (col - 1 >= 0 && extended.getCell(row, col - 1)) return true;
        if (col + 1 < extended.getWidth() && extended.getCell(row, col + 1)) return true;
        return extended.getHeight() == 2 && extended.getWidth() == 2;
    }

    @Override
    public Polyomino[] getExtensions() {
        if (shape.getHeight() == 0) {
            BooleanMatrix resultShape = new BooleanMatrix(new boolean[1][1]);
            resultShape.setCell(0, 0, true);
            return new Polyomino[] {new BooleanMatrixPolyomino(resultShape)};
        }
        BooleanMatrix extended = new BooleanMatrix(shape);
        extended.extend();
        LinkedList<Polyomino> result = new LinkedList<Polyomino>();
        for (int row = 0; row < extended.getHeight(); row++) {
            for (int col = 0; col < extended.getWidth(); col++) {
                if (canBeExtendedAt(row, col, extended)) {
                    extended.setCell(row, col, true);
                    BooleanMatrixPolyomino toAdd = new BooleanMatrixPolyomino(extended);
                    if (!result.contains(toAdd)) result.add(toAdd);
                    extended.setCell(row, col, false);
                }
            }
        }
        return result.toArray(new Polyomino[0]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("╔═");
        for (int col = 0; col < shape.getWidth() + 2; col++) {
            sb.append("══");
        }
        sb.append("═╗");
        sb.append('\n');

        sb.append("║ ");
        for (int col = 0; col < shape.getWidth() + 2; col++) {
            sb.append("  ");
        }
        sb.append(" ║");
        sb.append('\n');

        for (int row = 0; row < shape.getHeight(); row++) {

            sb.append("║ ");
            sb.append("  ");
            for (int col = 0; col < shape.getWidth(); col++) {
                if (shape.getCell(row, col)) sb.append("██");
                else sb.append("  ");
            }
            sb.append("  ");
            sb.append(" ║");
            sb.append('\n');
        }

        sb.append("║ ");
        for (int col = 0; col < shape.getWidth() + 2; col++) {
            sb.append("  ");
        }
        sb.append(" ║");
        sb.append('\n');

        sb.append("╚═");
        for (int col = 0; col < shape.getWidth() + 2; col++) {
            sb.append("══");
        }
        sb.append("═╝");
        sb.append('\n');

        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof BooleanMatrixPolyomino)) return false;
        BooleanMatrixPolyomino that = (BooleanMatrixPolyomino) other;
        return this.shape.equals(that.shape) && this.degree == that.degree;
    }
}
