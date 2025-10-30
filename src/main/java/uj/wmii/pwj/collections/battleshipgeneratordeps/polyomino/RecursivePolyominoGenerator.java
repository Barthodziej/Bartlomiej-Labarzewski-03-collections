package uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino;

import java.util.LinkedList;

public class RecursivePolyominoGenerator implements PolyominoGenerator {

    LinkedList<Polyomino[]> nthDegreePolyominos;
    private int maxCalculatedDegree;

    private static PolyominoGenerator instance;

    private RecursivePolyominoGenerator() {
        nthDegreePolyominos = new LinkedList<>();
        nthDegreePolyominos.add(new Polyomino[1]);
        nthDegreePolyominos.getFirst()[0] = new BooleanMatrixPolyomino();
        maxCalculatedDegree = 0;
    }
    public static PolyominoGenerator getInstance() {
        if (instance == null) {
            instance = new RecursivePolyominoGenerator();
        }
        return instance;
    }

    private void calculateDegree(int degree) {
        if (degree <= 0) throw new IllegalArgumentException("Degree (" + degree + ") has to be positive");
        if (degree <= maxCalculatedDegree) throw new IllegalArgumentException("Degree (" + degree + ") has already been calculated.");
        if (degree > maxCalculatedDegree + 1) throw new IllegalArgumentException("Degree (" + degree + ") cannot be calculated, max degree calculated now is " + maxCalculatedDegree);
        LinkedList<Polyomino> currentDegree = new LinkedList<>();
        for (Polyomino prevPolyomino : nthDegreePolyominos.get(maxCalculatedDegree)) {
            Polyomino[] newPolyominos = prevPolyomino.getExtensions();
            for (Polyomino newPolyomino : newPolyominos) {
                if (!currentDegree.contains(newPolyomino)) {
                    currentDegree.add(newPolyomino);
                }
            }
        }
        nthDegreePolyominos.addLast(currentDegree.toArray(new Polyomino[0]));
        maxCalculatedDegree++;
    }

    @Override
    public Polyomino[] generate(int degree) {
        for (int i = maxCalculatedDegree + 1; i <= degree; i++) {
            calculateDegree(i);
        }
        return nthDegreePolyominos.get(degree);
    }
}
