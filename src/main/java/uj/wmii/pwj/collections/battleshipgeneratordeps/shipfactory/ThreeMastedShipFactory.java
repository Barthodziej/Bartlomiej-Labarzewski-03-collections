package uj.wmii.pwj.collections.battleshipgeneratordeps.shipfactory;

import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.Polyomino;
import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.PolyominoGenerator;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.ThreeMastedShip;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.Ship;

import java.util.Random;

public class ThreeMastedShipFactory implements ShipFactory {
    PolyominoGenerator polyoGen;

    public ThreeMastedShipFactory(PolyominoGenerator polyoGen) {
        this.polyoGen = polyoGen;
    }

    public Ship createShip() {
        Polyomino[] shipShapes = polyoGen.generate(3);
        Random randGen = new Random();
        int choice = randGen.nextInt(shipShapes.length);
        return new ThreeMastedShip(shipShapes[choice].toBooleanMatrix());
    }
}
