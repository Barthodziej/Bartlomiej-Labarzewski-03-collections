package uj.wmii.pwj.collections.BrainfuckDeps.Instructions;

import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

public class DecrementInstruction implements Instruction {

    @Override
    public boolean exec(Tape tape) {
        tape.decrement();
        return true;
    }
}
