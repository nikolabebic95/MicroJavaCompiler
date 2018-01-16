// generated with ast extension for cup
// version 0.8
// 16/0/2018 22:14:37


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived7 extends Statement {

    private Return Return;

    public StatementDerived7 (Return Return) {
        this.Return=Return;
        if(Return!=null) Return.setParent(this);
    }

    public Return getReturn() {
        return Return;
    }

    public void setReturn(Return Return) {
        this.Return=Return;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Return!=null) Return.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Return!=null) Return.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Return!=null) Return.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived7(\n");

        if(Return!=null)
            buffer.append(Return.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived7]");
        return buffer.toString();
    }
}
