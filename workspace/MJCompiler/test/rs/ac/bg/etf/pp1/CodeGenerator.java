package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.extensions.*;
import rs.etf.pp1.mj.runtime.*;
import rs.etf.pp1.symboltable.concepts.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Stack;

public class CodeGenerator extends VisitorAdaptor {

    // region Helpers

    private void fixup(byte[] buffer) {
        if (buffer[0] < 11) {
            buffer[0] += 5;
        } else if (buffer[0] == 11) {
            buffer[0] = 12;
        } else if (buffer[0] == 13) {
            buffer[0] = 14;
        } else if (buffer[0] == 34) {
            buffer[0] = 35;
        } else if (buffer[0] == 36) {
            buffer[0] = 37;
        }
    }

    private void putCode() {
        for (int i = 0; i < leftValueBytesSize; i++) {
            Code.put(leftValueBytes[i]);
        }

        leftValueBytesSize = 0;
    }

    private void putHelper() {
        for (int i = 0; i < helperIncDecSize; i++) {
            Code.put(helperIncDecArray[i]);
        }

        helperIncDecSize = 0;
    }

    private int getNumOfVariables(Collection<Obj> symbols) {
        int ret = 0;

        for (Obj symbol : symbols) {
            if (symbol.getKind() == Obj.Var) {
                ret++;
            }
        }

        return ret;
    }

    private void loadConstant(int constant) {
        if (!constantDefinition) {
            Code.loadConst(constant);
        }
    }

    // endregion

    // region Program

    @Override
    public void visit(ProgramDerived1 program) {
        Obj programObj = ExtendedSymbolTable.get(program);
        Code.dataSize = getNumOfVariables(programObj.getLocalSymbols());
    }

    // endregion

    // region Methods

    @Override
    public void visit(MethodStartDerived1 methodStart) {
        constantDefinition = false;

        if (methodStart.getI2().equals("main")) {
            Code.mainPc = Code.pc;
        }

        Obj methodObj = ExtendedSymbolTable.get(methodStart.getParent());
        methodObj.setAdr(Code.pc);
        Code.put(Code.enter);
        Code.put(methodObj.getLevel());
        Code.put(getNumOfVariables(methodObj.getLocalSymbols()));
    }

    @Override
    public void visit(MethodDerived1 method) {
        Obj methodObj = ExtendedSymbolTable.get(method);
        Struct returnType = methodObj.getType();
        if (returnType == ExtendedSymbolTable.noType) {
            Code.put(Code.exit);
            Code.put(Code.return_);
        } else {
            Code.put(Code.trap);
            Code.put(1);
        }
    }

    // endregion

    // region Constants

    private boolean constantDefinition = true;

    @Override
    public void visit(ConstantDerived1 intConstant) {
        loadConstant(intConstant.getI1());
    }

    @Override
    public void visit(ConstantDerived2 charConstant) {
        loadConstant(charConstant.getC1());
    }

    @Override
    public void visit(ConstantDerived3 boolConstant) {
        loadConstant(boolConstant.getB1() ? 1 : 0);
    }

    @Override
    public void visit(ConstantDerived4 nullConstant) {
        loadConstant(0);
    }

    // endregion

    // region Classes

    @Override
    public void visit(ClassStartDerived1 classStart) {
        // TODO: Finish
        constantDefinition = false;
    }

    @Override
    public void visit(ClassDeclarationDerived1 classDeclaration) {
        // TODO: Finish
        constantDefinition = true;
    }

    // endregion

    // region Instructions

    // region Built in functions

    @Override
    public void visit(BuiltInFunctionDerived1 read) {
        Code.put(Code.read);

        fixup(leftValueBytes);
        putCode();
    }

    @Override
    public void visit(BuiltInFunctionDerived2 print) {
        isRightValue--;
        Struct type = ExtendedSymbolTable.getStruct(print);
        if (type == ExtendedSymbolTable.charType) {
            Code.put(Code.bprint);
        } else {
            Code.put(Code.print);
        }
    }

    @Override
    public void visit(OptionalPrintParameterDerived2 noParam) {
        Code.put(Code.const_1);
    }

    @Override
    public void visit(PrintStartDerived1 printStart) {
        isRightValue++;
    }

    @Override
    public void visit(PredefinedFunctionDerived3 lenFunction) {
        Code.put(Code.arraylength);
    }

    // endregion

    // region Binary operations

    @Override
    public void visit(OptionalTermsDerived1 addSub) {
        if (addSub.getAddOperator() instanceof AddOperatorDerived1) {
            Code.put(Code.add);
        } else if (addSub.getAddOperator() instanceof AddOperatorDerived2) {
            Code.put(Code.sub);
        } else {
            throw new NotImplementedException();
        }
    }

    @Override
    public void visit(OptionalFactorsDerived1 mulDivMod) {
        if (mulDivMod.getMultiplyOperator() instanceof MultiplyOperatorDerived1) {
            Code.put(Code.mul);
        } else if (mulDivMod.getMultiplyOperator() instanceof MultiplyOperatorDerived2) {
            Code.put(Code.div);
        } else if (mulDivMod.getMultiplyOperator() instanceof MultiplyOperatorDerived3) {
            Code.put(Code.rem);
        } else {
            throw new NotImplementedException();
        }
    }

    @Override
    public void visit(DummyFactorStartDerived1 dummyFactorStart) {
        isRightValue++;
    }

    @Override
    public void visit(FactorDerived1 factor) {
        isRightValue--;
    }

    // endregion

    // region Unary minus

    @Override
    public void visit(ArithmeticExpressionDerived2 unaryMinus) {
        Code.put(Code.neg);
    }

    // endregion

    // region Return from method

    @Override
    public void visit(ReturnStartDerived1 returnStart) {
        isRightValue++;
    }

    @Override
    public void visit(ReturnDerived1 returnValue) {
        isRightValue--;
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    @Override
    public void visit(ReturnDerived2 returnVoid) {
        isRightValue--;
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    // endregion

    // region Assignments

    private int isRightValue = 0;

    @Override
    public void visit(AssignOperatorDerived1 assignOperator) {
        isRightValue++;
    }

    @Override
    public void visit(ExpressionDerived2 expression) {
        isRightValue--;
        fixup(leftValueBytes);
        putCode();
    }

    // endregion

    // region Left values

    private byte[] leftValueBytes = new byte[8192];
    private int leftValueBytesSize = 0;

    @Override
    public void visit(LeftValueStartDerived1 identifier) {
        Scope scope = ExtendedSymbolTable.getScope(identifier);
        Obj objectNode = ExtendedSymbolTable.find(identifier.getI1(), scope);

        if (identifier.getParent().getParent() instanceof IncrementDecrement) {
            isIncDec = true;
            int pcBefore = Code.pc;
            Code.load(objectNode);
            int pcAfter = Code.pc;
            System.arraycopy(Code.buf, pcBefore, helperIncDecArray, helperIncDecSize, pcAfter - pcBefore);
            helperIncDecSize += pcAfter - pcBefore;
            if (isRightValue == 0) {
                return;
            }
        }

        if (isRightValue > 0) {
            Code.load(objectNode);
        } else {
            int pcBefore = Code.pc;
            Code.load(objectNode);
            int pcAfter = Code.pc;
            Code.pc = pcBefore;
            System.arraycopy(Code.buf, pcBefore, leftValueBytes, leftValueBytesSize, pcAfter - pcBefore);
            leftValueBytesSize += pcAfter - pcBefore;
        }
    }

    @Override
    public void visit(LeftValueStartDerived2 functionCall) {
        FunctionCallDerived1 fCall = (FunctionCallDerived1) functionCall.getFunctionCall();
        Obj function = ExtendedSymbolTable.get(fCall.getFunctionCallStart());
        if (isRightValue == 0 && function.getType() != ExtendedSymbolTable.noType) {
            Code.put(Code.pop);
        }
    }

    @Override
    public void visit(ArrayIndirectionStartDerived1 arrayIndirectionStart) {
        if (isRightValue == 0) {
            Struct type = ExtendedSymbolTable.getStruct(arrayIndirectionStart.getParent());

            putCode();

            if (type == ExtendedSymbolTable.charType) {
                leftValueBytes[0] = Code.baload;
            } else {
                leftValueBytes[0] = Code.aload; // assume int
            }

            leftValueBytesSize = 1;
        }

        isRightValue++;
    }

    @Override
    public void visit(IndirectionDerived3 arrayIndirection) {
        isRightValue--;

        Struct type = ExtendedSymbolTable.getStruct(arrayIndirection);

        if (isRightValue > 0) {
            if (type == ExtendedSymbolTable.charType) {
                Code.put(Code.baload);
            } else {
                Code.put(Code.aload);
            }
        }
    }

    // endregion

    // region Function calls

    private Obj calledFunction;

    @Override
    public void visit(FunctionCallStartDerived1 functionCallStart) {
        isRightValue++;
        calledFunction = ExtendedSymbolTable.get(functionCallStart);
    }

    @Override
    public void visit(FunctionCallDerived1 functionCall) {
        isRightValue--;
        int relativeAddress = calledFunction.getAdr() - Code.pc;
        Code.put(Code.call);
        Code.put2(relativeAddress);
    }

    // endregion

    // region Allocation

    @Override
    public void visit(AllocationDerived1 allocation) {
        if (allocation.getOptionalArrayDefinition() instanceof OptionalArrayDefinitionDerived1) {
            Struct type = ExtendedSymbolTable.getStruct(allocation);
            Code.put(Code.newarray);
            if (type == ExtendedSymbolTable.charType) {
                Code.put(0);
            } else {
                Code.put(1);
            }
        } else {
            // TODO: Allocate classes
            Code.put(Code.new_);
            Code.put(4); // assume 4 bytes
        }
    }

    // endregion

    // region Increment/decrement

    private byte[] helperIncDecArray = new byte[8192];
    private int helperIncDecSize = 0;
    private boolean isIncDec = false;

    @Override
    public void visit(IncrementDecrementDerived1 increment) {
        Code.put(Code.const_1);
        Code.put(Code.add);
        fixup(helperIncDecArray);
        putHelper();

        isIncDec = false;
    }

    @Override
    public void visit(IncrementDecrementDerived2 decrement) {
        Code.put(Code.const_1);
        Code.put(Code.sub);
        fixup(helperIncDecArray);
        putHelper();

        isIncDec = false;
    }

    // endregion

    // region Conditions

    private Stack<Integer> addresses = new Stack<>();

    // region Conditionals

    @Override
    public void visit(ConditionalStartDerived1 conditionalStart) {

    }

    @Override
    public void visit(ConditionalDerived1 conditional) {
        int address = addresses.pop();
        Code.fixup(address);
    }

    @Override
    public void visit(OptionalElseDerived1 optionalElse) {

    }

    @Override
    public void visit(ElseStartDerived1 elseStart) {

    }

    // endregion

    @Override
    public void visit(ConditionDerived2 identifierCondition) {
        Scope scope = ExtendedSymbolTable.getScope(identifierCondition);
        Obj objectNode = ExtendedSymbolTable.find(identifierCondition.getI1(), scope);
        Code.load(objectNode);
        Code.loadConst(1);
        addresses.push(Code.pc + 1);
        Code.putFalseJump(Code.eq, 0);
    }

    // endregion

    // endregion
}
