package uj.wmii.pwj.collections.BrainfuckDeps.Instructions;

import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

public class IncrementInstruction implements Instruction {

    @Override
    public boolean exec(Tape tape) {
        tape.increment();
        return true;
    }

}
