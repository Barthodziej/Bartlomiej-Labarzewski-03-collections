package uj.wmii.pwj.collections.BrainfuckDeps.Instructions;

import uj.wmii.pwj.collections.BrainfuckDeps.Tape.Tape;

public class WhileInstruction extends BlockInstruction {

    @Override
    public boolean exec(Tape tape) {
        while (tape.isNonZero()) {
            for (Instruction instruction : instructions) {
                boolean toContinue = instruction.exec(tape);
                if (!toContinue) return false;
            }
        }
        return true;
    }
}
