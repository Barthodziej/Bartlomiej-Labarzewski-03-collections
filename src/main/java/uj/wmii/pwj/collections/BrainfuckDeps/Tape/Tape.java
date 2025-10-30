package uj.wmii.pwj.collections.BrainfuckDeps.Tape;

public interface Tape {
    boolean moveLeft();
    boolean moveRight();
    void increment();
    void decrement();
    void set(int toSet);
    int get();
    boolean isZero();
    boolean isNonZero();
}
