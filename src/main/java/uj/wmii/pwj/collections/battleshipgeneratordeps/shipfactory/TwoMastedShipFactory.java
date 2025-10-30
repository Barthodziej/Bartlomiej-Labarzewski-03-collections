package uj.wmii.pwj.collections.battleshipgeneratordeps.shipfactory;

import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.Polyomino;
import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.PolyominoGenerator;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.TwoMastedShip;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.Ship;

import java.util.Random;

public class TwoMastedShipFactory implements ShipFactory {

    PolyominoGenerator polyoGen;

    public TwoMastedShipFactory(PolyominoGenerator polyoGen) {
        this.polyoGen = polyoGen;
    }

    public Ship createShip() {
        Polyomino[] shipShapes = polyoGen.generate(2);
        Random randGen = new Random();
        int choice = randGen.nextInt(shipShapes.length);
        return new TwoMastedShip(shipShapes[choice].toBooleanMatrix());
    }
}
