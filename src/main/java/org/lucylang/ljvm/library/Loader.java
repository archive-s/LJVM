package org.lucylang.ljvm.library;

import org.lucylang.ljvm.machine.module.Module;
import org.lucylang.ljvm.scope.Scope;
import org.lucylang.ljvm.scope.UndefinedException;

import java.util.ArrayList;

public class Loader {
    private static Loader loader;
    private static Scope<String, Module> systemModule;

    private Loader() {
    }

    public static Loader getLoader() {
        if (loader == null) {
            loader = new Loader();
            systemModule = new Scope<String, Module>();
            try {
                systemModule.set("std", new Std());
                systemModule.set("math", new Math());
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

        }
        return loader;
    }

    public Module getModule(String moduleName, ArrayList<Module> modules) throws UndefinedException {
        for (int i = 0; i < modules.size(); i++) {
            if (moduleName.equals(modules.get(i).getName())) {
                return modules.get(i);
            }
        }
        return systemModule.safeGet(moduleName);
    }
}
