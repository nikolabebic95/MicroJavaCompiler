// generated with ast extension for cup
// version 0.8
// 8/0/2018 2:11:43


package rs.ac.bg.etf.pp1.ast;

public class RightValueDerived4 extends RightValue {

    private IncrementDecrement IncrementDecrement;

    public RightValueDerived4 (IncrementDecrement IncrementDecrement) {
        this.IncrementDecrement=IncrementDecrement;
        if(IncrementDecrement!=null) IncrementDecrement.setParent(this);
    }

    public IncrementDecrement getIncrementDecrement() {
        return IncrementDecrement;
    }

    public void setIncrementDecrement(IncrementDecrement IncrementDecrement) {
        this.IncrementDecrement=IncrementDecrement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IncrementDecrement!=null) IncrementDecrement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IncrementDecrement!=null) IncrementDecrement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IncrementDecrement!=null) IncrementDecrement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RightValueDerived4(\n");

        if(IncrementDecrement!=null)
            buffer.append(IncrementDecrement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RightValueDerived4]");
        return buffer.toString();
    }
}
