// generated with ast extension for cup
// version 0.8
// 14/0/2018 2:25:51


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(OptionalConditionFactors OptionalConditionFactors);
    public void visit(ReturnType ReturnType);
    public void visit(OptionalPrintParameter OptionalPrintParameter);
    public void visit(Constant Constant);
    public void visit(AddOperator AddOperator);
    public void visit(OptionalMethodsList OptionalMethodsList);
    public void visit(LeftValueStart LeftValueStart);
    public void visit(FormalParametersList FormalParametersList);
    public void visit(ActualParameter ActualParameter);
    public void visit(VariableDefinition VariableDefinition);
    public void visit(RelationalOperator RelationalOperator);
    public void visit(ArithmeticExpression ArithmeticExpression);
    public void visit(FunctionCall FunctionCall);
    public void visit(FormalParameter FormalParameter);
    public void visit(OptionalActualParameters OptionalActualParameters);
    public void visit(ConditionFactorToken ConditionFactorToken);
    public void visit(ClassName ClassName);
    public void visit(ConditionTerm ConditionTerm);
    public void visit(BaseClassDeclaration BaseClassDeclaration);
    public void visit(MethodStart MethodStart);
    public void visit(OptionalIndirections OptionalIndirections);
    public void visit(FormalParametersListNonEmpty FormalParametersListNonEmpty);
    public void visit(Factor Factor);
    public void visit(PureCondition PureCondition);
    public void visit(LocalVariablesList LocalVariablesList);
    public void visit(VariablesList VariablesList);
    public void visit(PureArithmeticExpression PureArithmeticExpression);
    public void visit(ActualParametersListAtLeastOne ActualParametersListAtLeastOne);
    public void visit(OptionalConditionFactorTokens OptionalConditionFactorTokens);
    public void visit(IncrementDecrement IncrementDecrement);
    public void visit(Return Return);
    public void visit(OptionalArrayDeclaration OptionalArrayDeclaration);
    public void visit(Method Method);
    public void visit(Term Term);
    public void visit(Conditional Conditional);
    public void visit(MultiplyOperator MultiplyOperator);
    public void visit(Condition Condition);
    public void visit(OptionalFactors OptionalFactors);
    public void visit(RightValue RightValue);
    public void visit(OptionalTerms OptionalTerms);
    public void visit(OptionalConditionTerms OptionalConditionTerms);
    public void visit(ConstantsList ConstantsList);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(LocalVariableDeclaration LocalVariableDeclaration);
    public void visit(BuiltInFunction BuiltInFunction);
    public void visit(ConstantDeclaration ConstantDeclaration);
    public void visit(VariableDeclaration VariableDeclaration);
    public void visit(DeclarationsList DeclarationsList);
    public void visit(LogicalExpression LogicalExpression);
    public void visit(LoopExit LoopExit);
    public void visit(Statement Statement);
    public void visit(Expression Expression);
    public void visit(Type Type);
    public void visit(MethodsList MethodsList);
    public void visit(Allocation Allocation);
    public void visit(Declaration Declaration);
    public void visit(ConstantDefinition ConstantDefinition);
    public void visit(ConditionFactor ConditionFactor);
    public void visit(OptionalArrayDefinition OptionalArrayDefinition);
    public void visit(Program Program);
    public void visit(LeftValue LeftValue);
    public void visit(Indirection Indirection);
    public void visit(Loop Loop);
    public void visit(ActualParametersList ActualParametersList);
    public void visit(OptionalElse OptionalElse);
    public void visit(Block Block);
    public void visit(RelationalOperatorDerived6 RelationalOperatorDerived6);
    public void visit(RelationalOperatorDerived5 RelationalOperatorDerived5);
    public void visit(RelationalOperatorDerived4 RelationalOperatorDerived4);
    public void visit(RelationalOperatorDerived3 RelationalOperatorDerived3);
    public void visit(RelationalOperatorDerived2 RelationalOperatorDerived2);
    public void visit(RelationalOperatorDerived1 RelationalOperatorDerived1);
    public void visit(MultiplyOperatorDerived3 MultiplyOperatorDerived3);
    public void visit(MultiplyOperatorDerived2 MultiplyOperatorDerived2);
    public void visit(MultiplyOperatorDerived1 MultiplyOperatorDerived1);
    public void visit(OptionalActualParametersDerived2 OptionalActualParametersDerived2);
    public void visit(OptionalActualParametersDerived1 OptionalActualParametersDerived1);
    public void visit(ActualParameterDerived1 ActualParameterDerived1);
    public void visit(OptionalConditionFactorTokensDerived2 OptionalConditionFactorTokensDerived2);
    public void visit(OptionalConditionFactorTokensDerived1 OptionalConditionFactorTokensDerived1);
    public void visit(ConditionFactorTokenDerived1 ConditionFactorTokenDerived1);
    public void visit(AddOperatorDerived2 AddOperatorDerived2);
    public void visit(AddOperatorDerived1 AddOperatorDerived1);
    public void visit(OptionalFactorsDerived2 OptionalFactorsDerived2);
    public void visit(OptionalFactorsDerived1 OptionalFactorsDerived1);
    public void visit(FactorDerived3 FactorDerived3);
    public void visit(FactorDerived2 FactorDerived2);
    public void visit(FactorDerived1 FactorDerived1);
    public void visit(ActualParametersListAtLeastOneDerived1 ActualParametersListAtLeastOneDerived1);
    public void visit(ActualParametersListDerived2 ActualParametersListDerived2);
    public void visit(ActualParametersListDerived1 ActualParametersListDerived1);
    public void visit(OptionalConditionFactorsDerived2 OptionalConditionFactorsDerived2);
    public void visit(OptionalConditionFactorsDerived1 OptionalConditionFactorsDerived1);
    public void visit(ConditionFactorDerived1 ConditionFactorDerived1);
    public void visit(OptionalArrayDefinitionDerived2 OptionalArrayDefinitionDerived2);
    public void visit(OptionalArrayDefinitionDerived1 OptionalArrayDefinitionDerived1);
    public void visit(OptionalTermsDerived2 OptionalTermsDerived2);
    public void visit(OptionalTermsDerived1 OptionalTermsDerived1);
    public void visit(TermDerived1 TermDerived1);
    public void visit(IndirectionDerived3 IndirectionDerived3);
    public void visit(IndirectionDerived2 IndirectionDerived2);
    public void visit(IndirectionDerived1 IndirectionDerived1);
    public void visit(FunctionCallDerived1 FunctionCallDerived1);
    public void visit(OptionalConditionTermsDerived2 OptionalConditionTermsDerived2);
    public void visit(OptionalConditionTermsDerived1 OptionalConditionTermsDerived1);
    public void visit(ConditionTermDerived1 ConditionTermDerived1);
    public void visit(IncrementDecrementDerived2 IncrementDecrementDerived2);
    public void visit(IncrementDecrementDerived1 IncrementDecrementDerived1);
    public void visit(AllocationDerived1 AllocationDerived1);
    public void visit(LogicalExpressionDerived1 LogicalExpressionDerived1);
    public void visit(PureArithmeticExpressionDerived1 PureArithmeticExpressionDerived1);
    public void visit(ArithmeticExpressionDerived2 ArithmeticExpressionDerived2);
    public void visit(ArithmeticExpressionDerived1 ArithmeticExpressionDerived1);
    public void visit(OptionalIndirectionsDerived2 OptionalIndirectionsDerived2);
    public void visit(OptionalIndirectionsDerived1 OptionalIndirectionsDerived1);
    public void visit(LeftValueStartDerived2 LeftValueStartDerived2);
    public void visit(LeftValueStartDerived1 LeftValueStartDerived1);
    public void visit(OptionalPrintParameterDerived2 OptionalPrintParameterDerived2);
    public void visit(OptionalPrintParameterDerived1 OptionalPrintParameterDerived1);
    public void visit(OptionalElseDerived2 OptionalElseDerived2);
    public void visit(OptionalElseDerived1 OptionalElseDerived1);
    public void visit(PureConditionDerived1 PureConditionDerived1);
    public void visit(ConditionDerived3 ConditionDerived3);
    public void visit(ConditionDerived2 ConditionDerived2);
    public void visit(ConditionDerived1 ConditionDerived1);
    public void visit(RightValueDerived3 RightValueDerived3);
    public void visit(RightValueDerived2 RightValueDerived2);
    public void visit(RightValueDerived1 RightValueDerived1);
    public void visit(LeftValueDerived1 LeftValueDerived1);
    public void visit(ConstantDerived4 ConstantDerived4);
    public void visit(ConstantDerived3 ConstantDerived3);
    public void visit(ConstantDerived2 ConstantDerived2);
    public void visit(ConstantDerived1 ConstantDerived1);
    public void visit(BuiltInFunctionDerived2 BuiltInFunctionDerived2);
    public void visit(BuiltInFunctionDerived1 BuiltInFunctionDerived1);
    public void visit(ReturnDerived2 ReturnDerived2);
    public void visit(ReturnDerived1 ReturnDerived1);
    public void visit(LoopExitDerived2 LoopExitDerived2);
    public void visit(LoopExitDerived1 LoopExitDerived1);
    public void visit(LoopDerived1 LoopDerived1);
    public void visit(ConditionalDerived1 ConditionalDerived1);
    public void visit(ExpressionDerived2 ExpressionDerived2);
    public void visit(ExpressionDerived1 ExpressionDerived1);
    public void visit(OptionalArrayDeclarationDerived2 OptionalArrayDeclarationDerived2);
    public void visit(OptionalArrayDeclarationDerived1 OptionalArrayDeclarationDerived1);
    public void visit(VariableDefinitionDerived1 VariableDefinitionDerived1);
    public void visit(ConstantDefinitionDerived1 ConstantDefinitionDerived1);
    public void visit(StatementDerived9 StatementDerived9);
    public void visit(StatementDerived8 StatementDerived8);
    public void visit(StatementDerived7 StatementDerived7);
    public void visit(StatementDerived6 StatementDerived6);
    public void visit(StatementDerived5 StatementDerived5);
    public void visit(StatementDerived4 StatementDerived4);
    public void visit(StatementDerived3 StatementDerived3);
    public void visit(StatementDerived2 StatementDerived2);
    public void visit(StatementDerived1 StatementDerived1);
    public void visit(FormalParameterDerived1 FormalParameterDerived1);
    public void visit(VariablesListDerived2 VariablesListDerived2);
    public void visit(VariablesListDerived1 VariablesListDerived1);
    public void visit(ConstantsListDerived2 ConstantsListDerived2);
    public void visit(ConstantsListDerived1 ConstantsListDerived1);
    public void visit(BlockDerived2 BlockDerived2);
    public void visit(BlockDerived1 BlockDerived1);
    public void visit(LocalVariablesListDerived2 LocalVariablesListDerived2);
    public void visit(LocalVariablesListDerived1 LocalVariablesListDerived1);
    public void visit(FormalParametersListNonEmptyDerived2 FormalParametersListNonEmptyDerived2);
    public void visit(FormalParametersListNonEmptyDerived1 FormalParametersListNonEmptyDerived1);
    public void visit(FormalParametersListDerived2 FormalParametersListDerived2);
    public void visit(FormalParametersListDerived1 FormalParametersListDerived1);
    public void visit(VariableDeclarationDerived1 VariableDeclarationDerived1);
    public void visit(ConstantDeclarationDerived1 ConstantDeclarationDerived1);
    public void visit(ClassDeclarationDerived1 ClassDeclarationDerived1);
    public void visit(BaseClassDeclarationDerived2 BaseClassDeclarationDerived2);
    public void visit(BaseClassDeclarationDerived1 BaseClassDeclarationDerived1);
    public void visit(MethodStartDerived1 MethodStartDerived1);
    public void visit(MethodDerived1 MethodDerived1);
    public void visit(ReturnTypeDerived2 ReturnTypeDerived2);
    public void visit(ReturnTypeDerived1 ReturnTypeDerived1);
    public void visit(TypeDerived4 TypeDerived4);
    public void visit(TypeDerived3 TypeDerived3);
    public void visit(TypeDerived2 TypeDerived2);
    public void visit(TypeDerived1 TypeDerived1);
    public void visit(ClassNameDerived1 ClassNameDerived1);
    public void visit(DeclarationDerived3 DeclarationDerived3);
    public void visit(DeclarationDerived2 DeclarationDerived2);
    public void visit(DeclarationDerived1 DeclarationDerived1);
    public void visit(OptionalMethodsListDerived2 OptionalMethodsListDerived2);
    public void visit(OptionalMethodsListDerived1 OptionalMethodsListDerived1);
    public void visit(MethodsListDerived2 MethodsListDerived2);
    public void visit(MethodsListDerived1 MethodsListDerived1);
    public void visit(DeclarationsListDerived2 DeclarationsListDerived2);
    public void visit(DeclarationsListDerived1 DeclarationsListDerived1);
    public void visit(ProgramDerived1 ProgramDerived1);

}
