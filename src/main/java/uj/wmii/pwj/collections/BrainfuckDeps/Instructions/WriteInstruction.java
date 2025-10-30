package uj.wmii.pwj.collections.BrainfuckDeps.Instructions;

import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

import java.io.PrintStream;

public class WriteInstruction implements Instruction {

    private final PrintStream out;

    public WriteInstruction(PrintStream out) {
        this.out = out;
    }

    @Override
    public boolean exec(Tape tape) {
        out.print((char) tape.get());
        return true;
    }
}
