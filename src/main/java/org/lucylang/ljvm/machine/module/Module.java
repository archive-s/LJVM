package org.lucylang.ljvm.machine.module;

import org.lucylang.ljvm.machine.instruction.Instruction;
import org.lucylang.ljvm.scope.OverdefinedException;
import org.lucylang.ljvm.scope.Scope;
import org.lucylang.ljvm.scope.UndefinedException;

import java.io.Serializable;

public class Module implements Serializable {
    protected Scope<String, Routine> routines;
    protected String name;
    protected static int counter = 0;

    public Module() {
        this("anonymous" + counter);
        counter++;
    }

    public Module(String name) {
        this.name = "module$" + name;
        this.routines = new Scope<String, Routine>(this.name);
    }

    public boolean hasMain() {
        return this.routines.get("main") != null;
    }

    public Module defineRoutine(String name, Routine routine) throws OverdefinedException {
        this.routines.safeSet(name, routine);
        return this;
    }

    public Routine getRoutine(String name) throws UndefinedException {
        return this.routines.safeGet(name);
    }

    @Override
    public String toString() {
        try {
            String string = new String();
            for (String key : this.routines.keySet()) {
                Routine routine = this.routines.get(key);
                String instruction = new String();
                for (Instruction i : routine.getInstructions()) {
                    instruction += "\t" + i + "\n";
                }
                string += "\n" + key + " {\n" + instruction + "}\n";
            }
            return string;
        } catch (Exception e) {
            return new String();
        }
    }
}
