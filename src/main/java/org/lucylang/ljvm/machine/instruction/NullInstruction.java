package org.lucylang.ljvm.machine.instruction;

import org.lucylang.ljvm.machine.Machine;
import org.lucylang.ljvm.machine.module.Module;

import java.util.ArrayList;

public class NullInstruction extends Instruction {
    public NullInstruction() {
        this.type = Type.NULL;
        this.operands = new ArrayList<Operand>();

        this.validSize = 0;
        this.validRefs = new int[]{};
    }

    @Override
    public boolean executeValid(Machine vm, Module module) {
        return false;
    }
}
