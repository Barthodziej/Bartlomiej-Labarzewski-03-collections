package uj.wmii.pwj.collections;

import uj.wmii.pwj.collections.BrainfuckDeps.Instructions.Instruction;
import uj.wmii.pwj.collections.BrainfuckDeps.Parser.CodeParser;
import uj.wmii.pwj.collections.BrainfuckDeps.Parser.SimpleCodeParser;
import uj.wmii.pwj.collections.BrainfuckDeps.Tape.LinkedListTape;
import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

import java.io.InputStream;
import java.io.PrintStream;

public class SimpleBrainfuck implements Brainfuck {

    private final Tape tape;
    private final Instruction code;

    public SimpleBrainfuck(Tape tape, Instruction code) {
        this.tape = tape;
        this.code = code;
    }

    @Override
    public void execute() {
        code.exec(tape);
    }

}
