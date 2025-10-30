package uj.wmii.pwj.collections;

import uj.wmii.pwj.collections.battleshipgeneratordeps.board.Board;
import uj.wmii.pwj.collections.battleshipgeneratordeps.board.TernaryMatrixBoard;
import uj.wmii.pwj.collections.battleshipgeneratordeps.matrix.BooleanMatrix;
import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.PolyominoGenerator;
import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.RecursivePolyominoGenerator;
import uj.wmii.pwj.collections.battleshipgeneratordeps.shipfactory.*;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.Ship;

import java.util.LinkedList;
import java.util.Random;

public class SimpleBattleshipGenerator implements BattleshipGenerator {

    @Override
    public String generateMap(int width, int height, int[][] shipsQuantities) {

        PolyominoGenerator polyoGen = RecursivePolyominoGenerator.getInstance();

        ShipFactory[] factories = new ShipFactory[shipsQuantities.length];
        Random random = new Random();

        for (int shipTypeIndex = 0; shipTypeIndex < shipsQuantities.length; shipTypeIndex++) {
            switch (shipsQuantities[shipTypeIndex][0]) {
                case 1:
                    factories[shipTypeIndex] = new OneMastedShipFactory(polyoGen);
                    break;
                case 2:
                    factories[shipTypeIndex] = new TwoMastedShipFactory(polyoGen);
                    break;
                case 3:
                    factories[shipTypeIndex] = new ThreeMastedShipFactory(polyoGen);
                    break;
                case 4:
                    factories[shipTypeIndex] = new FourMastedShipFactory(polyoGen);
                    break;
                default:
                    throw new IllegalArgumentException("Number of ship masts has to be in {1, ..., 4}, entered: " + shipsQuantities[shipTypeIndex][0]);
            }
        }

        LinkedList<Ship> ships = new LinkedList<Ship>();

        boolean shouldTryAgain = true;
        Board result = new TernaryMatrixBoard(width, height);
        while (shouldTryAgain) {
            shouldTryAgain = false;
            for (int shipTypeIndex = 0; shipTypeIndex < shipsQuantities.length && !shouldTryAgain; shipTypeIndex++) {
                for (int i = 0; i < shipsQuantities[shipTypeIndex][1] && !shouldTryAgain; i++) {
                    Ship ship = factories[shipTypeIndex].createShip();
                    int x = random.nextInt(width - ship.getWidth() + 1);
                    int y = random.nextInt(height - ship.getHeight() + 1);
                    if (result.canPlaceShip(ship, x, y)) {
                        result.placeShip(ship, x, y);
                    }
                    else {
                        shouldTryAgain = true;
                        result = new TernaryMatrixBoard(width, height);
                    }
                }
            }
        }
        return result.toString();
    }

    @Override
    public String generateMap() {
        int[][] shipsQuantities = {{4, 1}, {3, 2}, {2, 3}, {1, 4}};
        return generateMap(10, 10,  shipsQuantities);
    }
}
