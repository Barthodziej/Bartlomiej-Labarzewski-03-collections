package uj.wmii.pwj.collections.BrainfuckDeps.Parser;

import uj.wmii.pwj.collections.BrainfuckDeps.Instructions.Instruction;

import java.io.InputStream;
import java.io.PrintStream;

public interface CodeParser {
    Instruction parse(String code, PrintStream out, InputStream in);
}
