package org.lucylang.ljvm.machine.instruction;

public enum Type {
    NULL, DEF, MOV, ADD, SUB, MUL, DIV, AND, OR, NOT, EQU, LES, GRE, LEQ, GEQ,
    PUSH, POP, PEEK, CALL, RET,
    GOTO, BEQ, BNE, REM,
    NUM, STR, BOOL, INT, LEN, VALUEAT, SET,
    PUT, GET
}
