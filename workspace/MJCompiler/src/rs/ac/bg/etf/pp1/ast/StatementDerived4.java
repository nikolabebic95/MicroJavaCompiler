// generated with ast extension for cup
// version 0.8
// 17/0/2018 18:3:11


package rs.ac.bg.etf.pp1.ast;

public class StatementDerived4 extends Statement {

    private Conditional Conditional;

    public StatementDerived4 (Conditional Conditional) {
        this.Conditional=Conditional;
        if(Conditional!=null) Conditional.setParent(this);
    }

    public Conditional getConditional() {
        return Conditional;
    }

    public void setConditional(Conditional Conditional) {
        this.Conditional=Conditional;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Conditional!=null) Conditional.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Conditional!=null) Conditional.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Conditional!=null) Conditional.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDerived4(\n");

        if(Conditional!=null)
            buffer.append(Conditional.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDerived4]");
        return buffer.toString();
    }
}
