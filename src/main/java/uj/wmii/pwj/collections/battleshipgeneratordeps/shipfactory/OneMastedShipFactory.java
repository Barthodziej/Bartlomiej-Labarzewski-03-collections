package uj.wmii.pwj.collections.battleshipgeneratordeps.shipfactory;

import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.Polyomino;
import uj.wmii.pwj.collections.battleshipgeneratordeps.polyomino.PolyominoGenerator;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.OneMastedShip;
import uj.wmii.pwj.collections.battleshipgeneratordeps.ships.Ship;

import java.util.Random;

public class OneMastedShipFactory implements ShipFactory {
    PolyominoGenerator polyoGen;

    public OneMastedShipFactory(PolyominoGenerator polyoGen) {
        this.polyoGen = polyoGen;
    }

    public Ship createShip() {
        Polyomino[] shipShapes = polyoGen.generate(1);
        Random randGen = new Random();
        int choice = randGen.nextInt(shipShapes.length);
        return new OneMastedShip(shipShapes[choice].toBooleanMatrix());
    }
}