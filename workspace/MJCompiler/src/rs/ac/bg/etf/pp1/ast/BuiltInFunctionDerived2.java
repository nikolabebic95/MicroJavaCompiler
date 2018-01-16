// generated with ast extension for cup
// version 0.8
// 16/0/2018 20:56:45


package rs.ac.bg.etf.pp1.ast;

public class BuiltInFunctionDerived2 extends BuiltInFunction {

    private PrintStart PrintStart;
    private RightValue RightValue;
    private OptionalPrintParameter OptionalPrintParameter;

    public BuiltInFunctionDerived2 (PrintStart PrintStart, RightValue RightValue, OptionalPrintParameter OptionalPrintParameter) {
        this.PrintStart=PrintStart;
        if(PrintStart!=null) PrintStart.setParent(this);
        this.RightValue=RightValue;
        if(RightValue!=null) RightValue.setParent(this);
        this.OptionalPrintParameter=OptionalPrintParameter;
        if(OptionalPrintParameter!=null) OptionalPrintParameter.setParent(this);
    }

    public PrintStart getPrintStart() {
        return PrintStart;
    }

    public void setPrintStart(PrintStart PrintStart) {
        this.PrintStart=PrintStart;
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
        if(PrintStart!=null) PrintStart.accept(visitor);
        if(RightValue!=null) RightValue.accept(visitor);
        if(OptionalPrintParameter!=null) OptionalPrintParameter.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintStart!=null) PrintStart.traverseTopDown(visitor);
        if(RightValue!=null) RightValue.traverseTopDown(visitor);
        if(OptionalPrintParameter!=null) OptionalPrintParameter.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintStart!=null) PrintStart.traverseBottomUp(visitor);
        if(RightValue!=null) RightValue.traverseBottomUp(visitor);
        if(OptionalPrintParameter!=null) OptionalPrintParameter.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("BuiltInFunctionDerived2(\n");

        if(PrintStart!=null)
            buffer.append(PrintStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
