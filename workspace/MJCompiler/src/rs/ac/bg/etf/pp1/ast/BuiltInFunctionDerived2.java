// generated with ast extension for cup
// version 0.8
// 13/0/2018 22:49:31


package rs.ac.bg.etf.pp1.ast;

public class BuiltInFunctionDerived2 extends BuiltInFunction {

    private RightValue RightValue;
    private OptionalPrintParameter OptionalPrintParameter;

    public BuiltInFunctionDerived2 (RightValue RightValue, OptionalPrintParameter OptionalPrintParameter) {
        this.RightValue=RightValue;
        if(RightValue!=null) RightValue.setParent(this);
        this.OptionalPrintParameter=OptionalPrintParameter;
        if(OptionalPrintParameter!=null) OptionalPrintParameter.setParent(this);
    }

    public RightValue getRightValue() {
        return RightValue;
    }

    public void setRightValue(RightValue RightValue) {
        this.RightValue=RightValue;
    }

    public OptionalPrintParameter getOptionalPrintParameter() {
        return OptionalPrintParameter;
    }

    public void setOptionalPrintParameter(OptionalPrintParameter OptionalPrintParameter) {
        this.OptionalPrintParameter=OptionalPrintParameter;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RightValue!=null) RightValue.accept(visitor);
        if(OptionalPrintParameter!=null) OptionalPrintParameter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RightValue!=null) RightValue.traverseTopDown(visitor);
        if(OptionalPrintParameter!=null) OptionalPrintParameter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RightValue!=null) RightValue.traverseBottomUp(visitor);
        if(OptionalPrintParameter!=null) OptionalPrintParameter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BuiltInFunctionDerived2(\n");

        if(RightValue!=null)
            buffer.append(RightValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalPrintParameter!=null)
            buffer.append(OptionalPrintParameter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [BuiltInFunctionDerived2]");
        return buffer.toString();
    }
}
