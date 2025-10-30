package uj.wmii.pwj.collections.battleshipgeneratordeps.ships;

import java.awt.Point;

public interface Ship {
    int getWidth();
    int getHeight();
    Point[] getMastsPositions();
    Point[] getNeighbouringPositions();
}
