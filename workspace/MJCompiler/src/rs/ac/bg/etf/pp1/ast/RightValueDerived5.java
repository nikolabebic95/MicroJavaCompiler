// generated with ast extension for cup
// version 0.8
// 11/0/2018 21:15:24


package rs.ac.bg.etf.pp1.ast;

public class RightValueDerived5 extends RightValue {

    public RightValueDerived5 () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RightValueDerived5(\n");

        buffer.append(tab);
        buffer.append(") [RightValueDerived5]");
        return buffer.toString();
    }
}