// generated with ast extension for cup
// version 0.8
// 16/0/2018 23:23:43


package rs.ac.bg.etf.pp1.ast;

public class ConditionalStartDerived1 extends ConditionalStart {

    public ConditionalStartDerived1 () {
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
        buffer.append("ConditionalStartDerived1(\n");

        buffer.append(tab);
        buffer.append(") [ConditionalStartDerived1]");
        return buffer.toString();
    }
}