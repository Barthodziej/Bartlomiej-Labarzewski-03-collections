package uj.wmii.pwj.collections.BrainfuckDeps.Instructions;

import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

public interface Instruction {
    boolean exec(Tape tape);
}
