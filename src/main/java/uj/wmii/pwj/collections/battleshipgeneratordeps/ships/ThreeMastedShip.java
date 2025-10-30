package uj.wmii.pwj.collections.battleshipgeneratordeps.ships;

import uj.wmii.pwj.collections.battleshipgeneratordeps.matrix.BooleanMatrix;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeMastedShip implements Ship {
    BooleanMatrix shape;
    public ThreeMastedShip(BooleanMatrix matrix) {
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
        LinkedList<Point> neighbours = new LinkedList<Point>();
        for (int row = -1; row <= shape.getHeight(); row++) {
            for (int col = -1; col <= shape.getWidth(); col++) {
                if (0 <= row && row < shape.getHeight() && 0 <= col && col < shape.getWidth() && shape.getCell(row, col)) continue;
                boolean neighbourFound = false;
                for (int dx = -1; dx <= 1 && !neighbourFound; dx++) {
                    for (int dy = -1; dy <= 1 && !neighbourFound; dy++) {
                        if ((dx != 0 || dy != 0) && 0 <= row + dy && row + dy < shape.getHeight() && 0 <= col + dx && col + dx < shape.getWidth() && shape.getCell(row + dy, col + dx)) {
                            neighbours.add(new Point(col, row));
                            neighbourFound = true;
                        }
                    }
                }
            }
        }
        return neighbours.toArray(new Point[0]);
    }
}
