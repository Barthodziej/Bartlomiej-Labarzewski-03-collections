package uj.wmii.pwj.collections;

public interface BattleshipGenerator {

    String generateMap(int width, int height, int[][] shipsQuantities);

    String generateMap();

    static BattleshipGenerator defaultInstance() {
        return new SimpleBattleshipGenerator();
    }

}
