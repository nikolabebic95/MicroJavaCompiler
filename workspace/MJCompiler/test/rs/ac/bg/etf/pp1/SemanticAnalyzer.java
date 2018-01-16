package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.extensions.ExtendedStruct;
import rs.ac.bg.etf.pp1.extensions.ExtendedSymbolTable;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Stack;

public class SemanticAnalyzer extends VisitorAdaptor {

    // region Helpers

    private void visitBinaryOperation(SyntaxNode syntaxNode) {
        Struct right = types.pop();
        Struct left = types.peek();

        if (!right.equals(left)) {
            throw new CompilerException(syntaxNode, "Binary peration not possible");
        }
    }

    private Struct getType(Type type) {
        if (type instanceof TypeDerived1) {
            return ExtendedSymbolTable.intType;
        } else if (type instanceof TypeDerived2) {
            return ExtendedSymbolTable.boolType;
        } else if (type instanceof TypeDerived3) {
            return  ExtendedSymbolTable.charType;
        } else if (type instanceof TypeDerived4) {

            TypeDerived4 classType = (TypeDerived4)type;
            ClassNameDerived1 classNameNonTerminal = (ClassNameDerived1)classType.getClassName();
            String className = classNameNonTerminal.getI1();
            Obj objectNode = ExtendedSymbolTable.find(className);

            if (objectNode.getKind() != Obj.Type) {
                throw new CompilerException(type, className + " is not a type name");
            }

            return objectNode.getType();
        } else {
            throw new NotImplementedException();
        }
    }

    private boolean checkIfIsArray(OptionalArrayDeclaration optionalArrayDeclaration) {
        return optionalArrayDeclaration instanceof OptionalArrayDeclarationDerived1;
    }

    private boolean checkIfIsArray(OptionalArrayDefinition optionalArrayDefinition) {
        return optionalArrayDefinition instanceof OptionalArrayDefinitionDerived1;
    }

    private Struct getReturnType(ReturnType returnType) {
        if (returnType instanceof ReturnTypeDerived1) {
            return ExtendedSymbolTable.noType;
        } else if (returnType instanceof ReturnTypeDerived2) {
            ReturnTypeDerived2 type = (ReturnTypeDerived2)returnType;
            return getType(type.getType());
        } else {
            throw new NotImplementedException();
        }
    }

    private boolean checkIfNameExistsInCurrentScope(String name) {
        Obj objectNode = ExtendedSymbolTable.findInCurrentScope(name);
        return objectNode != ExtendedSymbolTable.noObj;
    }

    private int getConstantValue(Constant constant) {
        if (constant instanceof ConstantDerived1) {
            ConstantDerived1 intConstant = (ConstantDerived1)constant;
            return intConstant.getI1();
        } else if (constant instanceof ConstantDerived2) {
            ConstantDerived2 charConstant = (ConstantDerived2)constant;
            return charConstant.getC1();
        } else if (constant instanceof ConstantDerived3) {
            ConstantDerived3 boolConstant = (ConstantDerived3)constant;
            return boolConstant.getB1() ? 1 : 0;
        } else if (constant instanceof ConstantDerived4) {
            return 0;
        } else {
            throw new NotImplementedException();
        }
    }

    private Struct getIdentifierType(String identifier) {
        Obj objectNode = ExtendedSymbolTable.find(identifier);
        if (objectNode == ExtendedSymbolTable.noObj) {
            if (classStruct != null) {
                objectNode = ExtendedSymbolTable.findInBaseClasses(identifier, classStruct);
            }
        }

        return objectNode.getType();
    }

    private ExtendedStruct getBaseClass(BaseClassDeclaration baseClassDeclaration) {
        if (baseClassDeclaration instanceof BaseClassDeclarationDerived2) {
            return null;
        }

        ClassNameDerived1 name = (ClassNameDerived1)((BaseClassDeclarationDerived1)baseClassDeclaration).getClassName();
        String className = name.getI1();


        Obj objectNode = ExtendedSymbolTable.find(className);
        Struct ret = objectNode.getType();
        if (ret.getKind() != Struct.Class || !(ret instanceof ExtendedStruct)) {
            throw new CompilerException(baseClassDeclaration, className + " is not a class");
        }

        return (ExtendedStruct)ret;
    }

    // endregion

    // region Program

    private Obj programObj;

    @Override
    public void visit(ProgramStartDerived1 programStart) {
        programObj = ExtendedSymbolTable.insert(Obj.Prog, programStart.getI1(), ExtendedSymbolTable.noType);
        ExtendedSymbolTable.openScope();
    }

    @Override
    public void visit(ProgramDerived1 program) {
        ExtendedSymbolTable.chainLocalSymbols(programObj);
        ExtendedSymbolTable.closeScope();
        ExtendedSymbolTable.insert(program, programObj);
    }

    // endregion

    // region Constant declarations

    private static class ConstantStruct {
        private String name;
        private int value;

        public ConstantStruct(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

    private ArrayList<ConstantStruct> constants = new ArrayList<>();

    @Override
    public void visit(ConstantDeclarationDerived1 constantDeclaration) {
        Struct constantType = getType(constantDeclaration.getType());
        constants.forEach(constant -> ExtendedSymbolTable.insert(Obj.Con, constant.getName(), constantType, constant.value));
        constants.clear();
        types.clear();
    }

    @Override
    public void visit(ConstantDefinitionDerived1 constantDefinition) {
        String constantName = constantDefinition.getI1();
        int constantValue = getConstantValue(constantDefinition.getConstant());

        if (checkIfNameExistsInCurrentScope(constantName)) {
            throw new CompilerException(constantDefinition, constantName + " already exists in the current scope");
        }

        constants.add(new ConstantStruct(constantName, constantValue));
    }

    // endregion

    // region Variable declarations

    private static class VariableStruct {
        String name;
        boolean array;

        public VariableStruct(String name, boolean array) {
            this.name = name;
            this.array = array;
        }

        public String getName() {
            return name;
        }

        public boolean isArray() {
            return array;
        }
    }
    private ArrayList<VariableStruct> variables = new ArrayList<>();

    private boolean classField = false;

    @Override
    public void visit(VariableDeclarationDerived1 variableDeclaration) {
        Struct variableType = getType(variableDeclaration.getType());
        Struct arrayType = new Struct(Struct.Array, variableType);
        variables.forEach(variable -> {
            if (checkIfNameExistsInCurrentScope(variable.getName())) {
                throw new CompilerException(variableDeclaration, variable.getName() + "already exists in the current scope");
            }

            ExtendedSymbolTable.insert(classField ? Obj.Fld : Obj.Var, variable.getName(), variable.isArray() ? arrayType : variableType);
        });
        variables.clear();
    }

    @Override
    public void visit(VariableDefinitionDerived1 variableDefinition) {
        String variableName = variableDefinition.getI1();
        boolean isArray = checkIfIsArray(variableDefinition.getOptionalArrayDeclaration());
        variables.add(new VariableStruct(variableName, isArray));
    }

    // endregion

    // region Method declarations

    private Obj outerScope;
    private int numberOfFormalParameters = 0;
    private boolean wasReturned = false;

    @Override
    public void visit(FormalParameterDerived1 formalParameter) {
        Struct variableType = getType(formalParameter.getType());
        Struct arrayType = new Struct(Struct.Array, variableType);
        String name = formalParameter.getI2();
        boolean isArray = checkIfIsArray(formalParameter.getOptionalArrayDeclaration());
        ExtendedSymbolTable.insert(Obj.Var, name, isArray ? arrayType : variableType);
        numberOfFormalParameters++;
    }

    @Override
    public void visit(MethodDerived1 method) {
        if (outerScope.getType() != ExtendedSymbolTable.noType && !wasReturned) {
            throw new CompilerException(method, "Method " + outerScope.getName() + " never returns");
        }

        outerScope.setLevel(numberOfFormalParameters);
        ExtendedSymbolTable.chainLocalSymbols(outerScope);
        ExtendedSymbolTable.closeScope();

        ExtendedSymbolTable.insert(method, outerScope);
    }

    @Override
    public void visit(MethodStartDerived1 methodStart) {
        String methodName = methodStart.getI2();

        if (checkIfNameExistsInCurrentScope(methodName)) {
            throw new CompilerException(methodStart, methodName + " exists in the current scope");
        }

        Struct returnType = getReturnType(methodStart.getReturnType());

        outerScope = ExtendedSymbolTable.insert(Obj.Meth, methodName, returnType);
        numberOfFormalParameters = 0;
        wasReturned = false;

        ExtendedSymbolTable.openScope();
    }

    // endregion

    // region Class declarations

    private ExtendedStruct classStruct;

    @Override
    public void visit(ClassStartDerived1 classStart) {
        String className = classStart.getI1();

        if (checkIfNameExistsInCurrentScope(className)) {
            throw new CompilerException(classStart, className + " exists in the current scope");
        }

        ExtendedStruct baseClass = getBaseClass(classStart.getBaseClassDeclaration());

        classStruct = new ExtendedStruct(Struct.Class);
        classStruct.setParent(baseClass);
        ExtendedSymbolTable.insert(Obj.Type, className, classStruct);
        ExtendedSymbolTable.openScope();
        ExtendedSymbolTable.insert(Obj.Fld, "this", classStruct);
        classField = true;
    }

    @Override
    public void visit(DummyClassSeparatorDerived1 dummyClassSeparator) {
        ExtendedSymbolTable.chainLocalSymbols(classStruct);
        classField = false;
    }

    @Override
    public void visit(ClassDeclarationDerived1 classDeclaration) {
        ExtendedSymbolTable.closeScope();
        classStruct = null;
    }

    // endregion

    // region Return statement

    @Override
    public void visit(ReturnDerived1 valueReturn) {
        wasReturned = true;
        if (outerScope.getType() == ExtendedSymbolTable.noType) {
            throw new CompilerException(valueReturn, "Return not possible in void method");
        }

        Struct returnType = types.pop();
        if (!returnType.assignableTo(outerScope.getType())) {
            throw new CompilerException(valueReturn, returnType.toString() + " not assignible to " + outerScope.getType().toString());
        }
    }

    @Override
    public void visit(ReturnDerived2 voidReturn) {
        if (outerScope.getType() != ExtendedSymbolTable.noType) {
            throw new CompilerException(voidReturn, "A value must be returned");
        }
    }

    // endregion

    // region Statements

    private Stack<Struct> types = new Stack<>();

    // region Constants

    @Override
    public void visit(ConstantDerived1 intConstant) {
        types.push(ExtendedSymbolTable.intType);
    }

    @Override
    public void visit(ConstantDerived2 charConstant) {
        types.push(ExtendedSymbolTable.charType);
    }

    @Override
    public void visit(ConstantDerived3 boolConstant) {
        types.push(ExtendedSymbolTable.boolType);
    }

    @Override
    public void visit(ConstantDerived4 nullConstant) {
        types.push(ExtendedSymbolTable.nullType);
    }

    // endregion

    // region Left values

    @Override
    public void visit(LeftValueStartDerived1 identifier) {
        Struct type = getIdentifierType(identifier.getI1());
        if (type == null) {
            throw new CompilerException(identifier, identifier.getI1() + " - undeclared identifier");
        }

        types.push(type);

        ExtendedSymbolTable.insert(identifier, ExtendedSymbolTable.currentScope());
    }

    @Override
    public void visit(IndirectionDerived1 classFieldIndirection) {
        ExtendedStruct classType = (ExtendedStruct)types.pop();
        String fieldName = classFieldIndirection.getI1();
        Obj field = ExtendedSymbolTable.findInBaseClasses(fieldName, classType);

        if (field == ExtendedSymbolTable.noObj) {
            throw new CompilerException(classFieldIndirection,
                    "Class " + classType.toString() + " does not have member " + fieldName);
        }

        types.push(field.getType());
    }

    @Override
    public void visit(IndirectionDerived3 arrayIndirection) {
        // Remove the number from the stack
        Struct intType = types.pop();
        if (!intType.equals(ExtendedSymbolTable.intType)) {
            throw new CompilerException(arrayIndirection, "Array must be indexed with an int type");
        }

        Struct arrayType = types.pop();
        if (arrayType.getKind() != Struct.Array) {
            throw new CompilerException(arrayIndirection, "Only arrays can be indexed");
        }

        types.push(arrayType.getElemType());
        ExtendedSymbolTable.insert(arrayIndirection, arrayType.getElemType());
    }

    // endregion

    // region Conditions

    @Override
    public void visit(ConditionDerived1 pureCondition) {
        Struct type = types.pop();
        if (!type.equals(ExtendedSymbolTable.boolType)) {
            throw new CompilerException(pureCondition, "Condition must have a bool type");
        }
    }

    @Override
    public void visit(ConditionDerived2 identifierConfition) {
        String conditionName = identifierConfition.getI1();

        Obj objectNode = ExtendedSymbolTable.find(conditionName);
        if (objectNode == ExtendedSymbolTable.noObj && classStruct != null) {
            objectNode = ExtendedSymbolTable.findInBaseClasses(conditionName, classStruct);
        }

        Struct type = objectNode.getType();

        if (!type.equals(ExtendedSymbolTable.boolType)) {
            throw new CompilerException(identifierConfition, conditionName + " is not a bool type");
        }
    }

    @Override
    public void visit(OptionalConditionFactorsDerived1 optionalConditionFactors) {
        visitBinaryOperation(optionalConditionFactors);
    }

    @Override
    public void visit(ConditionFactorDerived1 conditionFactor) {
        visitBinaryOperation(conditionFactor);
        types.pop();
        types.push(ExtendedSymbolTable.boolType);
    }

    // endregion

    // region Expressions

    @Override
    public void visit(ExpressionDerived1 expression) {
        types.pop();
    }

    @Override
    public void visit(ExpressionDerived2 expression) {
        Struct rightValue = types.pop();
        Struct leftValue = types.pop();

        if (!rightValue.assignableTo(leftValue)) {
            throw new CompilerException(expression, "Assignment not possible");
        }
    }

    // endregion

    // region Arithmetic expressions

    @Override
    public void visit(OptionalTermsDerived1 optionalTerms) {
        visitBinaryOperation(optionalTerms);
    }

    @Override
    public void visit(OptionalFactorsDerived1 optionalFactors) {
        visitBinaryOperation(optionalFactors);
    }

    // endregion

    // region Allocation

    @Override
    public void visit(AllocationDerived1 allocation) {
        Struct type = getType(allocation.getType());

        ExtendedSymbolTable.insert(allocation, type);

        if (checkIfIsArray(allocation.getOptionalArrayDefinition())) {
            // Removes the int type of the parameter passed to the allocation
            Struct intType = types.pop();
            if (!intType.equals(ExtendedSymbolTable.intType)) {
                throw new CompilerException(allocation, "Arrays must be allocated with an integer number of objects");
            }

            type = new Struct(Struct.Array, type);
        }

        types.push(type);
    }

    // endregion

    // region Function calls

    private Obj function;

    @Override
    public void visit(FunctionCallStartDerived1 functionCallStart) {
        ExtendedStruct classType = classStruct;
        if (functionCallStart.getParent().getParent() instanceof Indirection) {
            classType = (ExtendedStruct)types.pop();
        }

        String methodName = functionCallStart.getI1();

        if (classType != null) {
            function = ExtendedSymbolTable.findInBaseClasses(methodName, classType);
        } else {
            function = ExtendedSymbolTable.find(methodName);
        }

        if (function == ExtendedSymbolTable.noObj) {
            throw new CompilerException(functionCallStart,
                    "Method " + methodName + " does not exist");
        }

        if (function.getKind() != Obj.Meth) {
            throw new CompilerException(functionCallStart, methodName + " is not a function");
        }

        ExtendedSymbolTable.insert(functionCallStart, function);
    }

    @Override
    public void visit(FunctionCallDerived1 functionCall) {
        int numberOfFormalParameters = function.getLevel();

        if (types.size() < numberOfFormalParameters) {
            throw new CompilerException(functionCall, "Invalid number of actual parameters");
        }

        if (numberOfFormalParameters != 0) {
            Object[] locals = function.getLocalSymbols().toArray();

            for (int i = numberOfFormalParameters - 1; i >= 0; i--) {
                Obj localSymbol = (Obj) locals[i];
                Struct target = localSymbol.getType();
                Struct actual = types.pop();
                if (!actual.assignableTo(target)) {
                    throw new CompilerException(functionCall,
                            target.toString() + " not assignible to " + actual.toString());
                }
            }
        }

        //if (function.getType() != ExtendedSymbolTable.noType) {
            types.push(function.getType());
        //}
    }

    // endregion

    // region Built in functions

    @Override
    public void visit(BuiltInFunctionDerived1 readFunction) {
        types.pop();
    }

    @Override
    public void visit(BuiltInFunctionDerived2 printFunction) {
        Struct type = types.pop();
        if (printFunction.getOptionalPrintParameter() instanceof OptionalPrintParameterDerived1) {
            type = types.pop();
        }

        ExtendedSymbolTable.insert(printFunction, type);
    }

    @Override
    public void visit(PredefinedFunctionDerived1 chrFunction) {
        Struct type = types.pop();
        if (type != ExtendedSymbolTable.intType) {
            throw new CompilerException(chrFunction, "chr argument must have int type");
        }

        types.push(ExtendedSymbolTable.charType);
    }

    @Override
    public void visit(PredefinedFunctionDerived2 ordFunction) {
        Struct type = types.pop();
        if (type != ExtendedSymbolTable.charType) {
            throw new CompilerException(ordFunction, "ord argument must have char type");
        }

        types.push(ExtendedSymbolTable.intType);
    }

    @Override
    public void visit(PredefinedFunctionDerived3 lenFunction) {
        Struct type = types.pop();
        if (type.getKind() != Struct.Array) {
            throw new CompilerException(lenFunction, "len argument must have array type");
        }

        types.push(ExtendedSymbolTable.intType);
    }

    // endregion

    // region Increment/decrement

    @Override
    public void visit(IncrementDecrementDerived1 increment) {
        Struct type = types.peek();
        if (!type.equals(ExtendedSymbolTable.intType) && !type.equals(ExtendedSymbolTable.charType)) {
            throw new CompilerException(increment, "Only int and char can be incremented");
        }
    }

    @Override
    public void visit(IncrementDecrementDerived2 decrement) {
        Struct type = types.peek();
        if (!type.equals(ExtendedSymbolTable.intType) && !type.equals(ExtendedSymbolTable.charType)) {
            throw new CompilerException(decrement, "Only int and char can be incremented");
        }
    }

    // endregion

    // endregion
}
