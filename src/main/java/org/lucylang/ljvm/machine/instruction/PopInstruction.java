package org.lucylang.ljvm.machine.instruction;

import org.lucylang.ljvm.machine.Machine;
import org.lucylang.ljvm.machine.Register;
import org.lucylang.ljvm.machine.module.Module;
import org.lucylang.ljvm.scope.UndefinedException;

import java.util.ArrayList;

public class PopInstruction extends Instruction {
    public PopInstruction(Operand<String> ref) {
        this.type = Type.POP;
        this.operands = new ArrayList<Operand>();
        this.operands.add(ref);

        this.validSize = 1;
        this.validRefs = new int[]{0};
    }

    @Override
    public boolean executeValid(Machine vm, Module module) throws InvalidInstruction, UndefinedException {
        Register r = this.getRegister(vm, 0);
        r.assignValue(vm.peekValue());
        vm.popValue();
        return false;
    }
}
