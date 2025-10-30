package uj.wmii.pwj.collections.BrainfuckDeps.Instructions;

import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

import java.util.LinkedList;

public class BlockInstruction implements Instruction {
    LinkedList<Instruction> instructions = new LinkedList<Instruction>();

    public void addInstruction(Instruction instruction) {
        instructions.addLast(instruction);
    }

    @Override
    public boolean exec(Tape tape) {
        for (Instruction instruction : instructions) {
            boolean toContinue = instruction.exec(tape);
            if (!toContinue) return false;
        }
        return true;
    }
}
