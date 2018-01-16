// generated with ast extension for cup
// version 0.8
// 16/0/2018 22:14:38


package rs.ac.bg.etf.pp1.ast;

public class IndirectionDerived3 extends Indirection {

    private ArrayIndirectionStart ArrayIndirectionStart;
    private RightValue RightValue;

    public IndirectionDerived3 (ArrayIndirectionStart ArrayIndirectionStart, RightValue RightValue) {
        this.ArrayIndirectionStart=ArrayIndirectionStart;
        if(ArrayIndirectionStart!=null) ArrayIndirectionStart.setParent(this);
        this.RightValue=RightValue;
        if(RightValue!=null) RightValue.setParent(this);
    }

    public ArrayIndirectionStart getArrayIndirectionStart() {
        return ArrayIndirectionStart;
    }

    public void setArrayIndirectionStart(ArrayIndirectionStart ArrayIndirectionStart) {
        this.ArrayIndirectionStart=ArrayIndirectionStart;
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
        if(ArrayIndirectionStart!=null) ArrayIndirectionStart.accept(visitor);
        if(RightValue!=null) RightValue.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayIndirectionStart!=null) ArrayIndirectionStart.traverseTopDown(visitor);
        if(RightValue!=null) RightValue.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayIndirectionStart!=null) ArrayIndirectionStart.traverseBottomUp(visitor);
        if(RightValue!=null) RightValue.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IndirectionDerived3(\n");

        if(ArrayIndirectionStart!=null)
            buffer.append(ArrayIndirectionStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RightValue!=null)
            buffer.append(RightValue.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IndirectionDerived3]");
        return buffer.toString();
    }
}
