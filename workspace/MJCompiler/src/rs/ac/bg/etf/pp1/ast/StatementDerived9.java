// generated with ast extension for cup
// version 0.8
// 11/0/2018 22:8:2


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived9 extends Statement {

    private IncrementDecrement IncrementDecrement;

    public StatementDerived9 (IncrementDecrement IncrementDecrement) {
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
        buffer.append("StatementDerived9(\n");

        if(IncrementDecrement!=null)
            buffer.append(IncrementDecrement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived9]");
        return buffer.toString();
    }
}
