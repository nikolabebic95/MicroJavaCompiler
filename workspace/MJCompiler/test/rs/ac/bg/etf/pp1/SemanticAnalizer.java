package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.Extensions.ExtendedSymbolTable;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

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
                throw new RuntimeException(className + " is not a type name");
            }

            return objectNode.getType();
        } else {
            throw new NotImplementedException();
        }
    }

    private boolean checkIfIsArray(OptionalArrayDeclaration optionalArrayDeclaration) {
        return optionalArrayDeclaration instanceof OptionalArrayDeclarationDerived1;
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
            throw new RuntimeException(constantName + " already exists in the current scope");
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
                throw new RuntimeException(variable.getName() + "already exists in the current scope");
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

    private static class LocalVariableStruct {
        private ArrayList<VariableStruct> variables;
        private Struct type;

        public LocalVariableStruct(ArrayList<VariableStruct> variables, Struct type) {
            this.variables = variables;
            this.type = type;
        }

        public ArrayList<VariableStruct> getVariables() {
            return variables;
        }

        public Struct getType() {
            return type;
        }
    }

    private ArrayList<LocalVariableStruct> localVariables = new ArrayList<>();

    private static class FormalParameterStruct {
        private Struct type;
        private String name;
        private boolean isArray;

        public FormalParameterStruct(Struct type, String name, boolean isArray) {
            this.type = type;
            this.name = name;
            this.isArray = isArray;
        }

        public Struct getType() {
            return type;
        }

        public String getName() {
            return name;
        }

        public boolean isArray() {
            return isArray;
        }
    }

    private ArrayList<FormalParameterStruct> formalParameters = new ArrayList<>();

    @Override
    public void visit(LocalVariableDeclarationDerived1 variableDeclaration) {
        Struct variableType = getType(variableDeclaration.getType());
        localVariables.add(new LocalVariableStruct(variables, variableType));
        variables = new ArrayList<>();
    }

    @Override
    public void visit(FormalParameterDerived1 formalParameter) {
        Struct type = getType(formalParameter.getType());
        String name = formalParameter.getI2();
        boolean isArray = checkIfIsArray(formalParameter.getOptionalArrayDeclaration());
        formalParameters.add(new FormalParameterStruct(type, name, isArray));
    }

    @Override
    public void visit(MethodDerived1 method) {
        String methodName = method.getI2();

        if (checkIfNameExistsInCurrentScope(methodName)) {
            throw new RuntimeException(methodName + " exists in the current scope");
        }

        Struct returnType = getReturnType(method.getReturnType());

        Obj outerScope = ExtendedSymbolTable.insertMethod(methodName, returnType, formalParameters.size());

        ExtendedSymbolTable.openScope();

        formalParameters.forEach(formalParameter -> {
            Struct type = formalParameter.isArray() ?
                    new Struct(Struct.Array, formalParameter.getType()) : formalParameter.getType();
            ExtendedSymbolTable.insert(Obj.Var, formalParameter.getName(), type);
        });

        localVariables.forEach(localVariableArr -> {
            Struct type = localVariableArr.getType();
            Struct arrType = new Struct(Struct.Array, type);
            localVariableArr.variables.forEach(variable ->
                    ExtendedSymbolTable.insert(Obj.Var, variable.getName(), variable.isArray() ? arrType : type));
        });

        ExtendedSymbolTable.chainLocalSymbols(outerScope);

        ExtendedSymbolTable.closeScope();

        localVariables.clear();
        formalParameters.clear();
    }

    // endregion

}
