package org.lucylang.ljvm.machine;

import org.lucylang.ljvm.machine.instruction.Instruction;
import org.lucylang.ljvm.machine.instruction.InvalidInstruction;
import org.lucylang.ljvm.machine.module.Module;
import org.lucylang.ljvm.machine.module.Routine;
import org.lucylang.ljvm.scope.OverdefinedException;
import org.lucylang.ljvm.scope.Scope;
import org.lucylang.ljvm.scope.UndefinedException;
import org.lucylang.ljvm.type.TypeUnmatchedException;
import org.lucylang.ljvm.value.NoneValue;
import org.lucylang.ljvm.value.Value;
import org.lucylang.ljvm.value.ValueUnavailableException;

import java.util.Stack;

public class Machine {
    private int next;
    private Scope<String, Register> registers;
    private Stack<Value> memoryStack;

    public Machine() {
        this.reset();
    }

    public Machine reset() {
        this.next = 0;
        this.registers = new Scope<String, Register>("global");
        this.memoryStack = new Stack<Value>();
        return this;
    }

    public Machine setNext(int next) {
        this.next = next;
        return this;
    }

    public int getNext() {
        return this.next;
    }

    public Register getRegister(String ref) {
        try {
            Register r = this.registers.safeGet(ref);
            return r;
        } catch (UndefinedException udf) {
            Register r = new Register(new NoneValue());
            this.registers.set(ref, r);
            return r;
        }
    }

    public Value getValue(String ref) throws UndefinedException {
        return this.getRegister(ref).getValue();
    }

    public Machine pushValue(Value value) {
        this.memoryStack.push(value);
        return this;
    }

    public Machine popValue() {
        this.memoryStack.pop();
        return this;
    }

    public Value peekValue() {
        return this.memoryStack.peek();
    }

    public Machine execute(Instruction[] instructions, int pos, Module module) throws InvalidInstruction, TypeUnmatchedException, ValueUnavailableException, UndefinedException, OverdefinedException {
        if (instructions == null) {
            return this;
        }
        this.next = pos;
        while (this.next < instructions.length) {
            Instruction i = instructions[this.next];
            if (!i.execute(this, module)) {
                this.next++;
            } else {
                break;
            }
        }
        return this;
    }

    public Machine call(Module module, String routineName) throws InvalidInstruction, TypeUnmatchedException, ValueUnavailableException, UndefinedException, OverdefinedException {
        Routine routine = module.getRoutine(routineName);
        Scope<String, Register> currentScope = this.registers;
        int next = this.next;
        this.registers = new Scope<String, Register>(routineName);
        this.execute(routine.getInstructions(), 0, module);
        this.next = next;
        this.registers = currentScope;
        return this;
    }

    public Machine execute(Module module) throws InvalidInstruction, TypeUnmatchedException, ValueUnavailableException, UndefinedException, OverdefinedException {
        this.call(module, "main");
        return this;
    }
}
