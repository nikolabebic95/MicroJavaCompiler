package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.Extensions.ExtendedSymbolTable;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Stack;

public class SemanticAnalizer extends VisitorAdaptor {

    // region Helpers

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
            return null;
        }

        return objectNode.getType();
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

    @Override
    public void visit(VariableDeclarationDerived1 variableDeclaration) {
        Struct variableType = getType(variableDeclaration.getType());
        Struct arrayType = new Struct(Struct.Array, variableType);
        variables.forEach(variable -> {
            if (checkIfNameExistsInCurrentScope(variable.getName())) {
                throw new CompilerException(variableDeclaration, variable.getName() + "already exists in the current scope");
            }

            ExtendedSymbolTable.insert(Obj.Var, variable.getName(), variable.isArray() ? arrayType : variableType);
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
    }

    @Override
    public void visit(MethodDerived1 method) {
        if (outerScope.getType() != ExtendedSymbolTable.noType && !wasReturned) {
            throw new CompilerException(method, "Method " + outerScope.getName() + " never returns");
        }

        outerScope.setLevel(numberOfFormalParameters);
        ExtendedSymbolTable.chainLocalSymbols(outerScope);
        ExtendedSymbolTable.closeScope();
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

    // region Return statement

    @Override
    public void visit(ReturnDerived1 valueReturn) {
        wasReturned = true;
        // TODO: Check type
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

    @Override
    public void visit(LeftValueStartDerived1 identifier) {
        Struct type = getIdentifierType(identifier.getI1());
        if (type == null) {
            throw new CompilerException(identifier, identifier.getI1() + " - undeclared identifier");
        }

        types.push(type);
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
    }

    @Override
    public void visit(ExpressionDerived2 expression) {
        Struct rightValue = types.pop();
        Struct leftValue = types.pop();

        if (!rightValue.assignableTo(leftValue)) {
            throw new CompilerException(expression, "Assignment not possible");
        }
    }

    private void visitBinaryOperation(SyntaxNode syntaxNode) {
        Struct right = types.pop();
        Struct left = types.peek();

        if (!right.equals(left)) {
            throw new CompilerException(syntaxNode, "Arithmetic operation not possible");
        }
    }

    @Override
    public void visit(OptionalTermsDerived1 optionalTerms) {
        visitBinaryOperation(optionalTerms);
    }

    @Override
    public void visit(OptionalFactorsDerived1 optionalFactors) {
        visitBinaryOperation(optionalFactors);
    }

    @Override
    public void visit(AllocationDerived1 allocation) {
        Struct type = getType(allocation.getType());
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
}