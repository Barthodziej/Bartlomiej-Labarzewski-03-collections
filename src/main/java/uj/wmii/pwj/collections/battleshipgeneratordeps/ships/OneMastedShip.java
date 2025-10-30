package uj.wmii.pwj.collections.battleshipgeneratordeps.ships;

import uj.wmii.pwj.collections.battleshipgeneratordeps.matrix.BooleanMatrix;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OneMastedShip implements Ship {
    BooleanMatrix shape;
    public OneMastedShip(BooleanMatrix matrix) {
        shape = new BooleanMatrix(matrix);
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
    public Point[] getMastsPositions() {
        LinkedList<Point> points = new LinkedList<Point>();
        for (int row = 0; row < shape.getHeight(); row++) {
            for (int col = 0; col < shape.getWidth(); col++) {
                if (shape.getCell(row, col)) points.add(new Point(col, row));
            }
        }
        return points.toArray(new Point[0]);
    }

    @Override
    public Point[] getNeighbouringPositions() {
        LinkedList<Point> points = new LinkedList<>();
        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                if (row != 0 || col != 0) points.add(new Point(col, row));
            }
        }
        return points.toArray(new Point[0]);
    }
}
