// generated with ast extension for cup
// version 0.8
// 16/0/2018 19:5:1


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived6 extends Statement {

    private LoopExit LoopExit;

    public StatementDerived6 (LoopExit LoopExit) {
        this.LoopExit=LoopExit;
        if(LoopExit!=null) LoopExit.setParent(this);
    }

    public LoopExit getLoopExit() {
        return LoopExit;
    }

    public void setLoopExit(LoopExit LoopExit) {
        this.LoopExit=LoopExit;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LoopExit!=null) LoopExit.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LoopExit!=null) LoopExit.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LoopExit!=null) LoopExit.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived6(\n");

        if(LoopExit!=null)
            buffer.append(LoopExit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived6]");
        return buffer.toString();
    }
}
