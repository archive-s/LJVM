package org.lucylang.ljvm.type;

public class NumberType extends Type {
    @Override
    public boolean equals(Object type) {
        if (type instanceof NumberType) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "NumberType";
    }
}
