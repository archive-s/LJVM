package org.lucylang.ljvm.generator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.lucylang.ljvm.machine.instruction.Instruction;
import org.lucylang.ljvm.node.*;

import java.util.ArrayList;

public class StmtCodeGeneratorTest extends TestCase {
    public StmtCodeGeneratorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(StmtCodeGeneratorTest.class);
    }

    public void testExpr() {
        NumberLiteral n1 = new NumberLiteral(10);
        NumberLiteral n2 = new NumberLiteral(20);
        NumberLiteral n3 = new NumberLiteral(30);
        AddExpr expr = new AddExpr(new AddExpr(n1, n2), new AddExpr(n1, n3));
        StmtCodeGenerator gen = new StmtCodeGenerator();
        Assignment assignment = new Assignment(new VarName("testThrow"), expr);
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        gen.visitAssignment(assignment, instructions);
        for (int i = 0; i < instructions.size(); i++) {
            System.out.println(instructions.get(i));
        }
    }

    public void testIfElse() {
        BooleanLiteral booleanLiteral = new BooleanLiteral(true);
        IfElse ifElse = new IfElse(booleanLiteral);
        NumberLiteral n1 = new NumberLiteral(10);
        NumberLiteral n2 = new NumberLiteral(20);
        NumberLiteral n3 = new NumberLiteral(30);
        AddExpr expr = new AddExpr(new AddExpr(n1, n2), new AddExpr(n1, n3));
        Assignment assignment = new Assignment(new VarName("test_a"), expr);
        ifElse.addStmtIf(assignment);
        expr = new AddExpr(new AddExpr(n1, n2), n3);
        assignment = new Assignment(new VarName("test_b"), expr);
        ifElse.addStmtElse(assignment);
        IfElse innerIf = new IfElse(new BooleanLiteral(false));
        innerIf.addStmtIf(assignment);
        ifElse.addStmtIf(innerIf);

        StmtCodeGenerator gen = new StmtCodeGenerator();
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        gen.visitIfElse(ifElse, instructions);
        for (int i = 0; i < instructions.size(); i++) {
            System.out.printf("%4d ", i);
            System.out.println(instructions.get(i));
        }
    }

    public void testWhile() {
        BooleanLiteral booleanLiteral = new BooleanLiteral(true);
        While whileStmt = new While(booleanLiteral);
        NumberLiteral n1 = new NumberLiteral(10);
        NumberLiteral n2 = new NumberLiteral(20);
        NumberLiteral n3 = new NumberLiteral(30);
        AddExpr expr = new AddExpr(new AddExpr(n1, n2), new AddExpr(n1, n3));
        Assignment assignment = new Assignment(new VarName("test_a"), expr);
        whileStmt.addStmt(assignment);

        StmtCodeGenerator gen = new StmtCodeGenerator();
        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        gen.visitWhile(whileStmt, instructions);
        for (int i = 0; i < instructions.size(); i++) {
            System.out.printf("%4d ", i);
            System.out.println(instructions.get(i));
        }
    }
}
