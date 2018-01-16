// generated with ast extension for cup
// version 0.8
// 16/0/2018 23:23:43


package rs.ac.bg.etf.pp1.ast;

public class ExpressionDerived2 extends Expression {

    private LeftValue LeftValue;
    private AssignOperator AssignOperator;
    private RightValue RightValue;

    public ExpressionDerived2 (LeftValue LeftValue, AssignOperator AssignOperator, RightValue RightValue) {
        this.LeftValue=LeftValue;
        if(LeftValue!=null) LeftValue.setParent(this);
        this.AssignOperator=AssignOperator;
        if(AssignOperator!=null) AssignOperator.setParent(this);
        this.RightValue=RightValue;
        if(RightValue!=null) RightValue.setParent(this);
    }

    public LeftValue getLeftValue() {
        return LeftValue;
    }

    public void setLeftValue(LeftValue LeftValue) {
        this.LeftValue=LeftValue;
    }

    public AssignOperator getAssignOperator() {
        return AssignOperator;
    }

    public void setAssignOperator(AssignOperator AssignOperator) {
        this.AssignOperator=AssignOperator;
    }

    public RightValue getRightValue() {
        return RightValue;
    }

    public void setRightValue(RightValue RightValue) {
        this.RightValue=RightValue;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LeftValue!=null) LeftValue.accept(visitor);
        if(AssignOperator!=null) AssignOperator.accept(visitor);
        if(RightValue!=null) RightValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LeftValue!=null) LeftValue.traverseTopDown(visitor);
        if(AssignOperator!=null) AssignOperator.traverseTopDown(visitor);
        if(RightValue!=null) RightValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LeftValue!=null) LeftValue.traverseBottomUp(visitor);
        if(AssignOperator!=null) AssignOperator.traverseBottomUp(visitor);
        if(RightValue!=null) RightValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionDerived2(\n");

        if(LeftValue!=null)
            buffer.append(LeftValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AssignOperator!=null)
            buffer.append(AssignOperator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RightValue!=null)
            buffer.append(RightValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionDerived2]");
        return buffer.toString();
    }
}
