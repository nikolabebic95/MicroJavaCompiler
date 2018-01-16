// generated with ast extension for cup
// version 0.8
// 16/0/2018 22:14:37


package rs.ac.bg.etf.pp1.ast;

public class ReturnDerived1 extends Return {

    private ReturnStart ReturnStart;
    private RightValue RightValue;

    public ReturnDerived1 (ReturnStart ReturnStart, RightValue RightValue) {
        this.ReturnStart=ReturnStart;
        if(ReturnStart!=null) ReturnStart.setParent(this);
        this.RightValue=RightValue;
        if(RightValue!=null) RightValue.setParent(this);
    }

    public ReturnStart getReturnStart() {
        return ReturnStart;
    }

    public void setReturnStart(ReturnStart ReturnStart) {
        this.ReturnStart=ReturnStart;
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
        if(ReturnStart!=null) ReturnStart.accept(visitor);
        if(RightValue!=null) RightValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ReturnStart!=null) ReturnStart.traverseTopDown(visitor);
        if(RightValue!=null) RightValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ReturnStart!=null) ReturnStart.traverseBottomUp(visitor);
        if(RightValue!=null) RightValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnDerived1(\n");

        if(ReturnStart!=null)
            buffer.append(ReturnStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RightValue!=null)
            buffer.append(RightValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnDerived1]");
        return buffer.toString();
    }
}
