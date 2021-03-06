package org.lucylang.ljvm.type;

import org.lucylang.ljvm.exception.RuntimeException;

public class TypeUnmatchedException extends RuntimeException {
    protected Type leftTy;
    protected Type rightTy;

    public TypeUnmatchedException(Type leftTy, Type rightTy) {
        super("Type Unmatched Exception: <" + leftTy + "> and <" + rightTy + ">");
        assert leftTy != null;
        assert rightTy != null;
        this.leftTy = leftTy;
        this.rightTy = rightTy;
    }

    public Type getLeftType() {
        return this.leftTy;
    }

    public Type getRightType() {
        return this.rightTy;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TypeUnmatchedException) {
            return this.getLeftType().equals(((TypeUnmatchedException) other).getLeftType()) &&
                    this.getRightType().equals(((TypeUnmatchedException) other).getRightType());
        }
        return false;
    }
}
