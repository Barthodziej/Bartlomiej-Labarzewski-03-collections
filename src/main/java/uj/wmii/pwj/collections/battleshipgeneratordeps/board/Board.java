package uj.wmii.pwj.collections.battleshipgeneratordeps.board;

import uj.wmii.pwj.collections.battleshipgeneratordeps.matrix.BooleanMatrix;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.Ship;

public interface Board {
    int getWidth();
    int getHeight();
    boolean canPlaceShip(Ship ship, int left, int top);
    void placeShip(Ship ship, int left, int top);
    BooleanMatrix toBooleanMatrix();
    String toString();
}
