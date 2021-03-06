Lucy X Assembly Language and It’s Virtual Machine
===
[![Build Status](https://travis-ci.org/lucy-lang/LJVM.svg?branch=master)](https://travis-ci.org/lucy-lang/LJVM)

Lucy Programming Language(or Lucy) is a dynamic language which runs the code over Lucy Virtual Machine. The goal of the Lucy Virtual Machine is to provide a generic platform so that the source codes of Lucy can be interpreted over it. Lucy Virtual Machine is a single thread virtual machine and driven by a small set of instructions. Moreover, the Lucy Virtual Machine provides unlimited registers, routine scope isolation and dynamic type checking. The Lucy X IR is to create a minimum instructions for a generic language, so that it will be more friendly for those beginners and learners who are interested in compiler techniques and design.

## Introduction

Lucy Virtual Machine(LVM) is driven Lucy X assembly language. LVM provides unlimited registers, routine scope isolation and dynamic type checking. LVM also provides a memory stack to store values in the register and the return address when doing a subroutine call. A special register named program counter is also provided to support jump instruction by the LVM. As a virtual and logic system, the LVM does not and there is no necessary to support cache and memory inheritance. All instructions will be perform directly to the virtual machine and the registers provide by LVM.
To reduce the complexity of the design of the virtual system, only static linking is supported by LVM.  Subroutines will be compiled and lined into one module by the front-end compiler and the Lucy X IR transform passes. The virtual machine will start interpreting the instructions of the main subroutines of the given module. The library modules must be linked with a main module by the linker other wise any library modules who has no main subroutine would not be interpret-able.
Finally, the Lucy X instruction set and LVM are open protocols and they can be implemented by any programming languages.
