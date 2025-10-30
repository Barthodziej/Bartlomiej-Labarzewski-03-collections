package uj.wmii.pwj.collections.BrainfuckDeps.Instructions;

import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

import java.io.IOException;
import java.io.InputStream;

public class ReadInstruction implements Instruction {

    private final InputStream in;

    public ReadInstruction(InputStream in) {
        this.in = in;
    }

    @Override
    public boolean exec(Tape tape) {
        int toSet;
        try {
            toSet = in.read();
        }
        catch (IOException ioe) {
            toSet = 0;
        }
        tape.set(toSet);
        return true;
    }
}
