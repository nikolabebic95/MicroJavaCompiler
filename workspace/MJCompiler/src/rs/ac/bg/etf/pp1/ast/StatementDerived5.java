// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:21


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived5 extends Statement {

    private Loop Loop;

    public StatementDerived5 (Loop Loop) {
        this.Loop=Loop;
        if(Loop!=null) Loop.setParent(this);
    }

    public Loop getLoop() {
        return Loop;
    }

    public void setLoop(Loop Loop) {
        this.Loop=Loop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Loop!=null) Loop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Loop!=null) Loop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Loop!=null) Loop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived5(\n");

        if(Loop!=null)
            buffer.append(Loop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived5]");
        return buffer.toString();
    }
}
