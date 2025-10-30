package uj.wmii.pwj.collections.BrainfuckDeps.Tape;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTape implements Tape {
    private final LinkedList<Integer> memory;
    private final ListIterator<Integer> head;
    private final int tapeSize;


    public LinkedListTape(int tapeSize) {
        memory = new LinkedList<Integer>();
        memory.add(0);
        head = memory.listIterator();
        this.tapeSize = tapeSize;
    }

    public boolean moveLeft() {
        if (!head.hasPrevious()) {
            if (memory.size() == tapeSize) return false;
            head.add(0);
        }
        head.previous();
        return true;
    }

    public boolean moveRight() {
        head.next();
        if (!head.hasNext()) {
            if (memory.size() == tapeSize) return false;
            head.add(0);
            head.previous();
        }
        return true;
    }

    public void increment() {
        Integer currentValue = head.next();
        head.previous();
        currentValue = currentValue + 1;
        head.set(currentValue);
    }

    public void decrement() {
        Integer currentValue = head.next();
        head.previous();
        currentValue = currentValue - 1;
        head.set(currentValue);
    }

    public void set(int toSet) {
        head.next();
        head.previous();
        head.set(toSet);
    }

    public int get() {
        Integer currentValue = head.next();
        head.previous();
        return currentValue;
    }

    public boolean isZero() {
        Integer currentValue = head.next();
        head.previous();
        return currentValue == 0;
    }

    public boolean isNonZero() {
        Integer currentValue = head.next();
        head.previous();
        return currentValue != 0;
    }

}
