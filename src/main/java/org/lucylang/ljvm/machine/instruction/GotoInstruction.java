package org.lucylang.ljvm.machine.instruction;

import org.lucylang.ljvm.machine.Machine;
import org.lucylang.ljvm.machine.OverdefinedException;
import org.lucylang.ljvm.machine.UndefinedException;
import org.lucylang.ljvm.type.TypeUnmatchedException;
import org.lucylang.ljvm.value.NumberValue;
import org.lucylang.ljvm.value.Value;
import org.lucylang.ljvm.value.ValueUnavailableException;

import java.util.ArrayList;

public class GotoInstruction extends Instruction {
    public GotoInstruction(Operand<Value> ref) {
        this.type = Type.GOTO;
        this.operands = new ArrayList<Operand>();
        this.operands.add(ref);

        this.validSize = 1;
        this.validRefs = new int[]{};
    }

    @Override
    public void executeValid(Machine vm) throws InvalidInstruction, TypeUnmatchedException, ValueUnavailableException, UndefinedException, OverdefinedException {
        Value v = this.getValue(vm, 0);
        if (!(v instanceof NumberValue)) {
            throw new InvalidInstruction();
        }
        int next = v.intValue();
        vm.setNext(next);
    }
}