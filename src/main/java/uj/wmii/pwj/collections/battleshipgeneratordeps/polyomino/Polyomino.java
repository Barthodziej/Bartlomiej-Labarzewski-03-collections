package uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino;

import uj.wmii.pwj.collections.battleshipgeneratordeps.matrix.BooleanMatrix;

public interface Polyomino {
    int getWidth();
    int getHeight();
    int getDegree();
    BooleanMatrix toBooleanMatrix();
    Polyomino[] getExtensions();
}
