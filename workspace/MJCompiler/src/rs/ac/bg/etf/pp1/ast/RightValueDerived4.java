// generated with ast extension for cup
// version 0.8
// 11/0/2018 22:8:2


package rs.ac.bg.etf.pp1.ast;

public class RightValueDerived4 extends RightValue {

    public RightValueDerived4 () {
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
        buffer.append("RightValueDerived4(\n");

        buffer.append(tab);
        buffer.append(") [RightValueDerived4]");
        return buffer.toString();
    }
}
