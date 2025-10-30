package uj.wmii.pwj.collections;

import uj.wmii.pwj.collections.BrainfuckDeps.Instructions.Instruction;
import uj.wmii.pwj.collections.BrainfuckDeps.Parser.CodeParser;
import uj.wmii.pwj.collections.BrainfuckDeps.Parser.SimpleCodeParser;
import uj.wmii.pwj.collections.BrainfuckDeps.Tape.LinkedListTape;

import java.io.InputStream;
import java.io.PrintStream;

public interface Brainfuck {
    /**
     * Executes uploaded program.
     */
    void execute();

    /**
     * Creates a new instance of Brainfuck interpreter with given program, using standard IO and stack of 1024 size.
     * @param program brainfuck program to interpret
     * @return new instance of the interpreter
     * @throws IllegalArgumentException if program is null or empty
     */
    static Brainfuck createInstance(String program) {
        if (program == null) {
            throw new IllegalArgumentException("Program is null");
        }
        if (program.isEmpty()) {
            throw new IllegalArgumentException("Program is empty");
        }
        return createInstance(program, System.out, System.in, 1024);
    }

    /**
     * Creates a new instance of Brainfuck interpreter with given parameters.
     * @param program brainfuck program to interpret
     * @param out output stream to be used by interpreter implementation
     * @param in input stream to be used by interpreter implementation
     * @param stackSize maximum stack size, that is allowed for this interpreter
     * @return new instance of the interpreter
     * @throws IllegalArgumentException if: program is null or empty, OR out is null, OR in is null, OR stackSize is below 1.
     */
    static Brainfuck createInstance(String program, PrintStream out, InputStream in, int stackSize) {
        if (program == null) {
            throw new IllegalArgumentException("Program is null");
        }
        if (program.isEmpty()) {
            throw new IllegalArgumentException("Program is empty");
        }
        if (out == null) {
            throw new IllegalArgumentException("Output stream is null");
        }
        if (in == null) {
            throw new IllegalArgumentException("Input stream is null");
        }
        if (stackSize <= 0) {
            throw new IllegalArgumentException("Stack size is below 1");
        }
        CodeParser parser = new SimpleCodeParser();
        Instruction code = parser.parse(program, out, in);
        return new SimpleBrainfuck(new LinkedListTape(stackSize), code);
    }

}
