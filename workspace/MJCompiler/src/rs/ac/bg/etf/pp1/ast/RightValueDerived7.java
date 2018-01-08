// generated with ast extension for cup
// version 0.8
// 8/0/2018 2:6:32


package rs.ac.bg.etf.pp1.ast;

public class RightValueDerived7 extends RightValue {

    public RightValueDerived7 () {
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
        buffer.append("RightValueDerived7(\n");

        buffer.append(tab);
        buffer.append(") [RightValueDerived7]");
        return buffer.toString();
    }
}
