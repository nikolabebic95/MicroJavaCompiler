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

    private boolean isUsed(IncrementDecrement incrementDecrement) {
        return !(incrementDecrement.getParent() instanceof Statement);
    }

    private void fixupLastRead() {
        int i = incDecWriteAddress;
        if (Code.buf[i] < 6) {
            Code.buf[i] += 5;
        } else if (Code.buf[i] == Code.getstatic) {
            Code.buf[i] = Code.putstatic;
        } else if (Code.buf[i] == Code.getfield) {
            Code.buf[i] = Code.putfield;
        } else if (Code.buf[i] == Code.aload) {
            Code.buf[i] = Code.astore;
        } else if (Code.buf[i] == Code.baload) {
            Code.buf[i] = Code.bastore;
        }
    }

    private boolean notUsedResult(FunctionCallDerived1 functionCall) {
        SyntaxNode syntaxNode = functionCall;
        while (syntaxNode != null) {
            if (syntaxNode instanceof Expression) {
                return true;
            } else if (syntaxNode instanceof RightValue) {
                return false;
            }

            syntaxNode = syntaxNode.getParent();
        }

        return true;
    }

    private void writeFromCurrentScope(Obj objectNode) {
        switch (objectNode.getKind()) {
            case Obj.Con:
                Code.loadConst(objectNode.getAdr());
                break;
            case Obj.Var:
                int adr = objectNode.getAdr();
                if (insideClass) adr++; // Because of "this" hidden pointer

                if (objectNode.getLevel() == 0) {
                    Code.put(Code.getstatic);
                    Code.put2(objectNode.getAdr());
                }
                else if (adr > 3) {
                    Code.put(Code.load);
                    Code.put(adr);
                } else {
                    Code.put(Code.load_n + adr);
                }
                break;
        }
    }

    private void writeField(Obj objectNode, ExtendedStruct currentClass) {
        int adr = objectNode.getAdr() + countBaseClassFields(currentClass);
        Code.put(Code.getfield);
        Code.put2(adr);
    }

    private boolean write(LeftValueStartDerived1 identifier) {
        String name = identifier.getI1();
        if (name.equals("this")) {
            Code.put(Code.load_n);
            return false;
        }

        Scope currentScope = ExtendedSymbolTable.getScope(identifier);
        Obj objectNode = currentScope.findSymbol(name);

        // Identifier exists in current scope
        if (objectNode != null) {
            writeFromCurrentScope(objectNode);
            return false;
        }

        objectNode = ExtendedSymbolTable.find(name, currentScope);

        if (objectNode != ExtendedSymbolTable.noObj) {
            // Treat fields with special care because of the base classes
            if (objectNode.getKind() != Obj.Fld) {
                writeFromCurrentScope(objectNode);
                return false;
            } else {
                Code.put(Code.load_n); // Load "this" pointer
                writeField(objectNode, classStruct);
                return true;
            }
        }

        objectNode = ExtendedSymbolTable.findInBaseClasses(name, classStruct);
        ExtendedStruct baseClass = ExtendedSymbolTable.findBaseClass(name, classStruct);
        Code.put(Code.load_n); // Load "this" pointer
        writeField(objectNode, baseClass);
        return true;
    }

    private int countBaseClassFields(ExtendedStruct currentClass) {
        int ret = 0;
        ExtendedStruct parent = currentClass.getParent();
        while (parent != null) {
            ret += parent.getNumberOfFields() - 1;
            parent = parent.getParent();
        }

        return ret;
    }

    private boolean isTrueLeftValue(SyntaxNode syntaxNode) {
        while (syntaxNode != null) {
            if (syntaxNode instanceof ExpressionDerived2 ||
                    syntaxNode instanceof BuiltInFunctionDerived1) {
                return true;
            }

            if (syntaxNode instanceof Indirection ||
                    syntaxNode instanceof OptionalIndirections ||
                    syntaxNode instanceof LeftValue ||
                    syntaxNode instanceof LeftValueStart) {
                syntaxNode = syntaxNode.getParent();
                continue;
            }

            return false;
        }

        return false;
    }

    private boolean isFunctionStartValue(LeftValueStartDerived1 leftValueStart) {
        LeftValueDerived1 leftValue = (LeftValueDerived1) leftValueStart.getParent();
        OptionalIndirections optionalIndirections = leftValue.getOptionalIndirections();
        if (optionalIndirections instanceof OptionalIndirectionsDerived2) {
            return false;
        }

        OptionalIndirectionsDerived1 real = (OptionalIndirectionsDerived1) optionalIndirections;
        if (real.getIndirection() instanceof IndirectionDerived2) {
            return true;
        }

        optionalIndirections = real.getOptionalIndirections();
        if (optionalIndirections instanceof OptionalIndirectionsDerived2) {
            return false;
        }

        real = (OptionalIndirectionsDerived1) optionalIndirections;
        return real.getIndirection() instanceof IndirectionDerived2;

    }

    private int getJumpOpCode(RelationalOperator operator) {
        if (operator instanceof RelationalOperatorDerived1) {
            return Code.eq;
        } else if (operator instanceof RelationalOperatorDerived2) {
            return Code.ne;
        } else if (operator instanceof RelationalOperatorDerived3) {
            return Code.gt;
        } else if (operator instanceof RelationalOperatorDerived4) {
            return Code.ge;
        } else if (operator instanceof RelationalOperatorDerived5) {
            return Code.lt;
        } else if (operator instanceof RelationalOperatorDerived6) {
            return Code.le;
        } else {
            throw new NotImplementedException();
        }
    }

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
        } else {
            throw new NotImplementedException();
        }
    }

    private void putCode() {
        for (int i = 0; i < leftValueBytesSize; i++) {
            Code.put(leftValueBytes[i]);
        }

        leftValueBytesSize = 0;
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
    public void visit(ProgramStartDerived1 program) {
        Obj programObj = ExtendedSymbolTable.get(program.getParent());
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
        int numOfFormalArguments = methodObj.getLevel() + (insideClass ? 1 : 0);
        Code.put(numOfFormalArguments);
        int numOfVars = getNumOfVariables(methodObj.getLocalSymbols()) + (insideClass ? 1 : 0);
        Code.put(numOfVars);

        if (methodStart.getI2().equals("main")) {
            VirtualMethodHelper.getMethodTable().forEach(Code::put);
        }
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

    private boolean insideClass = false;
    private ExtendedStruct classStruct;

    @Override
    public void visit(ClassStartDerived1 classStart) {
        constantDefinition = false;
        insideClass = true;
        classStruct = ExtendedSymbolTable.getClassStruct(classStart.getParent());
    }

    @Override
    public void visit(ClassDeclarationDerived1 classDeclaration) {
        constantDefinition = true;
        insideClass = false;

        classStruct.setVirtualTablePointer(Code.dataSize);
        VirtualMethodHelper.putClass(classStruct);

        classStruct = null;
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
    }

    @Override
    public void visit(FactorDerived1 factor) {
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
    }

    @Override
    public void visit(ReturnDerived1 returnValue) {
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    @Override
    public void visit(ReturnDerived2 returnVoid) {
        Code.put(Code.exit);
        Code.put(Code.return_);
    }

    // endregion

    // region Assignments

    private byte[] savedBytes = new byte[8192];
    private int savedBytesCounter = 0;

    @Override
    public void visit(AssignOperatorDerived1 assignOperator) {
        System.arraycopy(leftValueBytes, 0, savedBytes, 0, leftValueBytesSize);
        savedBytesCounter = leftValueBytesSize;
        leftValueBytesSize = 0;
    }

    @Override
    public void visit(ExpressionDerived2 expression) {
        fixup(savedBytes);
        for (int i = 0; i < savedBytesCounter; i++) {
            Code.put(savedBytes[i]);
        }
    }

    // endregion

    // region Left values

    private byte[] leftValueBytes = new byte[8192];
    private int leftValueBytesSize = 0;

    private int incDecStartPc;

    private int leftValueStartPc;

    @Override
    public void visit(LeftValueStartDerived1 identifier) {
        if (identifier.getParent().getParent() instanceof IncrementDecrement) {
            incDecStartPc = Code.pc;
            incDecWriteAddress = Code.pc;
        }

        int startPc = 0;

        if (isTrueLeftValue(identifier)) {
            startPc = Code.pc;
        }

        if (isFunctionStartValue(identifier)) {
            leftValueStartPc = Code.pc;
        }

        boolean wasField = write(identifier);

        if (wasField) {
            startPc++;
        }

        if (isTrueLeftValue(identifier)) {
            int endPc = Code.pc;
            System.arraycopy(Code.buf, startPc, leftValueBytes, 0, endPc - startPc);
            leftValueBytesSize = endPc - startPc;
            Code.pc = startPc;
        }
    }

    @Override
    public void visit(LeftValueStartDerived2 functionCall) {

    }

    @Override
    public void visit(ArrayIndirectionStartDerived1 arrayIndirectionStart) {
        if (isTrueLeftValue(arrayIndirectionStart.getParent())) {
            Struct type = ExtendedSymbolTable.getStruct(arrayIndirectionStart.getParent());

            int startPc = 0;

            if (isTrueLeftValue(arrayIndirectionStart.getParent())) {
                putCode();
                startPc = Code.pc;
            }

            incDecWriteAddress = Code.pc;

            if (type == ExtendedSymbolTable.charType) {
                Code.put(Code.baload);
            } else {
                Code.put(Code.aload);
            }

            if (isTrueLeftValue(arrayIndirectionStart.getParent())) {
                int endPc = Code.pc;
                System.arraycopy(Code.buf, startPc, leftValueBytes, 0, endPc - startPc);
                leftValueBytesSize = endPc - startPc;
                Code.pc = startPc;
            }
        }
    }

    @Override
    public void visit(IndirectionDerived1 fieldIndirection) {
        String fieldName = fieldIndirection.getI1();

        ExtendedStruct thisClass = ExtendedSymbolTable.getClassStruct(fieldIndirection);
        Obj field = ExtendedSymbolTable.findInBaseClasses(fieldName, thisClass);
        ExtendedStruct baseClass = ExtendedSymbolTable.findBaseClass(fieldName, thisClass);

        int startPc = 0;

        if (isTrueLeftValue(fieldIndirection)) {
            putCode();
            startPc = Code.pc;
        }

        incDecWriteAddress = startPc;

        writeField(field, baseClass);

        if (isTrueLeftValue(fieldIndirection)) {
            int endPc = Code.pc;
            System.arraycopy(Code.buf, startPc, leftValueBytes, 0, endPc - startPc);
            leftValueBytesSize = endPc - startPc;
            Code.pc = startPc;
        }
    }

    @Override
    public void visit(IndirectionDerived3 arrayIndirection) {
        if (!isTrueLeftValue(arrayIndirection)) {
            Struct type = ExtendedSymbolTable.getStruct(arrayIndirection);

            int startPc = 0;

            if (isTrueLeftValue(arrayIndirection)) {
                putCode();
                startPc = Code.pc;
            }

            incDecWriteAddress = Code.pc;

            if (type == ExtendedSymbolTable.charType) {
                Code.put(Code.baload);
            } else {
                Code.put(Code.aload);
            }

            if (isTrueLeftValue(arrayIndirection)) {
                int endPc = Code.pc;
                System.arraycopy(Code.buf, startPc, leftValueBytes, 0, endPc - startPc);
                leftValueBytesSize = endPc - startPc;
                Code.pc = startPc;
            }
        }
    }

    // endregion

    // region Function calls

    private int endLeftValuePc;

    @Override
    public void visit(FunctionCallStartDerived1 functionCallStart) {
        endLeftValuePc = Code.pc;

        if (functionCallStart.getParent().getParent() instanceof Indirection ) {
            putCode();
        } else {
            ExtendedStruct classType = ExtendedSymbolTable.getClassStruct(functionCallStart);

            if (classType != null) {
                Code.put(Code.load_n);
            }
        }
    }

    @Override
    public void visit(FunctionCallDerived1 functionCall) {
        if (functionCall.getParent() instanceof Indirection) {
            Obj functionObjectNode = ExtendedSymbolTable.get(functionCall.getFunctionCallStart());

            for (int i = leftValueStartPc; i < endLeftValuePc; i++) {
                Code.put(Code.buf[i]);
            }

            Code.put(Code.getfield);
            Code.put2(0);
            Code.put(Code.invokevirtual);
            FunctionCallStartDerived1 fCallStart = (FunctionCallStartDerived1)functionCall.getFunctionCallStart();
            String name = fCallStart.getI1();
            for (int i = 0; i < name.length(); i++) {
                Code.put4(name.charAt(i));
            }

            Code.put4(-1);

            if (functionObjectNode.getType() != ExtendedSymbolTable.noType && notUsedResult(functionCall)) {
                Code.put(Code.pop);
            } else {
                putCode();
            }
        } else {
            ExtendedStruct classType = ExtendedSymbolTable.getClassStruct(functionCall.getFunctionCallStart());
            Obj functionObjectNode = ExtendedSymbolTable.get(functionCall.getFunctionCallStart());

            if (classType == null) {
                int relativeAddress = functionObjectNode.getAdr() - Code.pc;
                Code.put(Code.call);
                Code.put2(relativeAddress);

                if (functionObjectNode.getType() != ExtendedSymbolTable.noType && notUsedResult(functionCall)) {
                    Code.put(Code.pop);
                }
            } else {
                Code.put(Code.load_n); // load "this" pointer
                Code.put(Code.getfield);
                Code.put2(0);
                Code.put(Code.invokevirtual);
                FunctionCallStartDerived1 fCallStart = (FunctionCallStartDerived1)functionCall.getFunctionCallStart();
                String name = fCallStart.getI1();
                for (int i = 0; i < name.length(); i++) {
                    Code.put4(name.charAt(i));
                }

                Code.put4(-1);

                if (functionObjectNode.getType() != ExtendedSymbolTable.noType && notUsedResult(functionCall)) {
                    Code.put(Code.pop);
                } else {
                    putCode();
                }
            }
        }
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
            ExtendedStruct type = (ExtendedStruct) ExtendedSymbolTable.getStruct(allocation);

           int numOfFields = 1;
            ExtendedStruct curr = type;
            while (curr != null) {
                numOfFields += (curr.getNumberOfFields() - 1);
                curr = curr.getParent();
            }

            Code.put(Code.new_);
            Code.put2(numOfFields * 4);
            Code.put(Code.dup);
            Code.loadConst(type.getVirtualTablePointer());
            Code.put(Code.putfield);
            Code.put2(0);
        }
    }

    // endregion

    // region Increment/decrement

    private int incDecWriteAddress;

    @Override
    public void visit(IncrementDecrementDerived1 increment) {
        int endAddr = Code.pc;
        if (isUsed(increment)) {
            for (int i = incDecStartPc; i < endAddr; i++) {
                Code.put(Code.buf[i]);
            }
        }

        Code.put(Code.const_1);
        Code.put(Code.add);
        for (int i = incDecStartPc; i < endAddr; i++) {
            Code.put(Code.buf[i]);
        }

        incDecWriteAddress += endAddr - incDecStartPc + 2;

        fixupLastRead();
    }

    @Override
    public void visit(IncrementDecrementDerived2 decrement) {
        int endAddr = Code.pc;
        if (isUsed(decrement)) {
            for (int i = incDecStartPc; i < endAddr; i++) {
                Code.put(Code.buf[i]);
            }
        }

        Code.put(Code.const_1);
        Code.put(Code.sub);
        for (int i = incDecStartPc; i < endAddr; i++) {
            Code.put(Code.buf[i]);
        }

        incDecWriteAddress += endAddr - incDecStartPc + 2;

        fixupLastRead();
    }

    // endregion

    // region Conditions

    private Stack<Integer> addresses = new Stack<>();
    private Stack<Integer> numsOfConditions = new Stack<>();
    private boolean isFirstCondition = true;

    // region Conditionals

    @Override
    public void visit(ConditionalStartDerived1 conditionalStart) {
    }

    @Override
    public void visit(ConditionalDerived1 conditional) {
        int num = numsOfConditions.pop();
        for (int i = 0; i < num; i++) {
            int address = addresses.pop();
            Code.fixup(address);
        }
    }

    @Override
    public void visit(ElseStartDerived1 elseStart) {
        int rememberedAddress = Code.pc + 1;
        Code.putJump(0);

        int num = numsOfConditions.pop();
        for (int i = 0; i < num; i++) {
            int address = addresses.pop();
            Code.fixup(address);
        }

        addresses.push(rememberedAddress);
        numsOfConditions.push(1);
    }

    // endregion

    // region Derived conditions

    @Override
    public void visit(ConditionDerived1 pureCondition) {
        isFirstCondition = true;
    }

    @Override
    public void visit(ConditionDerived2 identifierCondition) {
        Scope scope = ExtendedSymbolTable.getScope(identifierCondition);
        Obj objectNode = ExtendedSymbolTable.find(identifierCondition.getI1(), scope);
        Code.load(objectNode);
        Code.loadConst(1);
        addresses.push(Code.pc + 1);
        Code.putFalseJump(Code.eq, 0);

        numsOfConditions.push(1);
    }

    @Override
    public void visit(ConditionDerived3 boolCondition) {
        Code.put(Code.const_1);
        if (boolCondition.getB1()) {
            Code.put(Code.const_1);
        } else {
            Code.put(Code.const_2);
        }

        addresses.push(Code.pc + 1);
        Code.putFalseJump(Code.eq, 0);

        if (isFirstCondition) {
            numsOfConditions.push(1);
            isFirstCondition = false;
        } else {
            int nums = numsOfConditions.pop();
            numsOfConditions.push(nums + 1);
        }
    }

    @Override
    public void visit(ConditionFactorDerived1 conditionFactor) {
        addresses.push(Code.pc + 1);
        Code.putFalseJump(getJumpOpCode(conditionFactor.getRelationalOperator()), 0);
        if (isFirstCondition) {
            numsOfConditions.push(1);
            isFirstCondition = false;
        } else {
            int nums = numsOfConditions.pop();
            numsOfConditions.push(nums + 1);
        }
    }

    @Override
    public void visit(OptionalConditionTermsStartDerived1 optionalConditionTermsStart) {
        if (isLoop) {
            int loopAddress = loopAddresses.peek();
            Code.putJump(loopAddress);
        }

        int num = numsOfConditions.pop();
        for (int i = 0; i < num; i++) {
            int address = addresses.pop();
            Code.fixup(address);
        }

        isFirstCondition = true;
    }

    // endregion

    // endregion

    // region Loops

    private Stack<Integer> loopAddresses = new Stack<>();
    private boolean isLoop = false;

    private Stack<Integer> breakAddresses = new Stack<>();
    private Stack<Integer> breakNums = new Stack<>();
    private boolean isFirstBreak = true;

    private Stack<Integer> continueAddresses = new Stack<>();
    private Stack<Integer> continueNums = new Stack<>();
    private boolean isFirstContinue = true;

    @Override
    public void visit(LoopStartDerived1 loopStart) {
        loopAddresses.push(Code.pc);
    }

    @Override
    public void visit(LoopDerived1 loop) {
        int loopAddress = loopAddresses.pop();
        Code.putJump(loopAddress);

        int num = numsOfConditions.pop();
        for (int i = 0; i < num; i++) {
            int address = addresses.pop();
            Code.fixup(address);
        }

        if (!breakNums.empty()) {
            num = breakNums.pop();
            for (int i = 0; i < num; i++) {
                int address = breakAddresses.pop();
                Code.fixup(address);
            }
        }

        isFirstCondition = true;
        isFirstBreak = true;
        isLoop = false;
    }

    @Override
    public void visit(LoopConditionStartDerived1 loopConditionStart) {
        isLoop = true;

        if (!continueNums.empty()) {
            int num = continueNums.pop();
            for (int i = 0; i < num; i++) {
                int address = continueAddresses.pop();
                Code.fixup(address);
            }
        }

        isFirstContinue = true;
    }

    @Override
    public void visit(LoopExitDerived1 breakLoop) {
        breakAddresses.push(Code.pc + 1);
        Code.putJump(0);

        if (isFirstBreak) {
            breakNums.push(1);
            isFirstBreak = false;
        } else {
            int nums = breakNums.pop();
            breakNums.push(nums + 1);
        }
    }

    @Override
    public void visit(LoopExitDerived2 continueLoop) {
        continueAddresses.push(Code.pc + 1);
        Code.putJump(0);

        if (isFirstContinue) {
            continueNums.push(1);
            isFirstContinue = false;
        } else {
            int nums = continueNums.pop();
            continueNums.push(nums + 1);
        }
    }

    // endregion

    // endregion
}
