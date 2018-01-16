// generated with ast extension for cup
// version 0.8
// 16/0/2018 22:14:37


package rs.ac.bg.etf.pp1.ast;

public class PredefinedFunctionDerived2 extends PredefinedFunction {

    private RightValue RightValue;

    public PredefinedFunctionDerived2 (RightValue RightValue) {
        this.RightValue=RightValue;
        if(RightValue!=null) RightValue.setParent(this);
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
        if(RightValue!=null) RightValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RightValue!=null) RightValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RightValue!=null) RightValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PredefinedFunctionDerived2(\n");

        if(RightValue!=null)
            buffer.append(RightValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PredefinedFunctionDerived2]");
        return buffer.toString();
    }
}
