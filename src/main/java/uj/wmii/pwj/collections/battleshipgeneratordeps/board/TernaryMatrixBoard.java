package uj.wmii.pwj.collections.battleshipgeneratordeps.board;

import uj.wmii.pwj.collections.battleshipgeneratordeps.matrix.BooleanMatrix;
import uj.wmii.pwj.collections.battleshipgeneratordeps.matrix.TernaryMatrix;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.Ship;

import java.awt.*;

public class TernaryMatrixBoard implements Board {

    TernaryMatrix data;

    public TernaryMatrixBoard(int width, int height) {
        data = new TernaryMatrix(width, height);
    }

    public int getWidth() {
        return data.getWidth();
    }

    public int getHeight() {
        return data.getHeight();
    }

    public boolean canPlaceShip(Ship ship, int left, int top) {
        Point[] shipMasts = ship.getMastsPositions();
        for (Point mast : shipMasts) {
            if (data.getCell(top + mast.y, left + mast.x) != 0) return false;
        }
        return true;
    }

    public void placeShip(Ship ship, int left, int top) {
        Point[] shipMasts = ship.getMastsPositions();
        for (Point mast : shipMasts) {
            data.setCell(top + mast.y, left + mast.x, 2);
        }
        Point[] shipNeighbours = ship.getNeighbouringPositions();
        for (Point neighbour : shipNeighbours) {
            int row = top + neighbour.y;
            int col = left + neighbour.x;
            if (0 <= row && row < data.getHeight() && 0 <= col && col < data.getWidth()) {
                data.setCell(row, col, 1);
            }
        }
    }

    public BooleanMatrix toBooleanMatrix() {
        BooleanMatrix result = new BooleanMatrix(data.getWidth(), data.getHeight());
        for (int row = 0; row < data.getHeight(); row++) {
            for (int col = 0; col < data.getWidth(); col++) {
                if (data.getCell(row, col) != 0) {
                    result.setCell(row, col, true);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < data.getHeight(); row++) {
            for (int col = 0; col < data.getWidth(); col++) {
                if (data.getCell(row, col) == 1) sb.append('.');
                else if (data.getCell(row, col) == 2) sb.append('#');
                else sb.append('.');
            }
        }
        return sb.toString();
    }
}
