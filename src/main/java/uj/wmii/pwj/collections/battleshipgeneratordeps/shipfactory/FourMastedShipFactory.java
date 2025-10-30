package uj.wmii.pwj.collections.battleshipgeneratordeps.shipfactory;

import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.Polyomino;
import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.PolyominoGenerator;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.FourMastedShip;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.Ship;

import java.util.Random;

public class FourMastedShipFactory implements ShipFactory {

    PolyominoGenerator polyoGen;

    public FourMastedShipFactory(PolyominoGenerator polyoGen) {
        this.polyoGen = polyoGen;
    }

    public Ship createShip() {
        Polyomino[] shipShapes = polyoGen.generate(4);
        Random randGen = new Random();
        int choice = randGen.nextInt(shipShapes.length);
        return new FourMastedShip(shipShapes[choice].toBooleanMatrix());
    }
}
