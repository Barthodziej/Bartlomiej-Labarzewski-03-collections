package uj.wmii.pwj.collections.BrainfuckDeps.Parser;

import uj.wmii.pwj.collections.BrainfuckDeps.Instructions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Stack;

public class SimpleCodeParser implements CodeParser {
    private String clearComments(String code) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c != '+' && c != '-' && c != '<' && c != '>' && c != '[' && c != ']' && c != '.' && c != ',') continue;
            result.append(c);
        }
        return result.toString();
    }

    @Override
    public Instruction parse(String code, PrintStream out, InputStream in) {
        String rawCode = clearComments(code);
        Stack<BlockInstruction> stack = new Stack<>();
        BlockInstruction fullCode =  new BlockInstruction();
        stack.push(fullCode);
        for (int i = 0; i < rawCode.length(); i++) {
            char c = rawCode.charAt(i);
            switch (c) {
                case '+':
                    stack.peek().addInstruction(new IncrementInstruction());
                    break;
                case '-':
                    stack.peek().addInstruction(new DecrementInstruction());
                    break;
                case '<':
                    stack.peek().addInstruction(new LeftInstruction());
                    break;
                case '>':
                    stack.peek().addInstruction(new RightInstruction());
                    break;
                case '.':
                    stack.peek().addInstruction(new WriteInstruction(out));
                    break;
                case ',':
                    stack.peek().addInstruction(new ReadInstruction(in));
                    break;
                case '[':
                    BlockInstruction whileInstruction = new WhileInstruction();
                    stack.peek().addInstruction(whileInstruction);
                    stack.push(whileInstruction);
                    break;
                case ']':
                    stack.pop();
                    break;
            }
        }
        return fullCode;
    }
}
