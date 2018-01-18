// generated with ast extension for cup
// version 0.8
// 18/0/2018 2:29:28


package rs.ac.bg.etf.pp1.ast;

public class ElseStartDerived1 extends ElseStart {

    public ElseStartDerived1 () {
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
        buffer.append("ElseStartDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ElseStartDerived1]");
        return buffer.toString();
    }
}
