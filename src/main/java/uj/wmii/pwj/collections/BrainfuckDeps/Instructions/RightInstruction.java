package uj.wmii.pwj.collections.BrainfuckDeps.Instructions;

import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

public class RightInstruction implements Instruction {

    @Override
    public boolean exec(Tape tape) {
        return tape.moveRight();
    }
}
