// generated with ast extension for cup
// version 0.8
// 15/0/2018 23:38:22


package rs.ac.bg.etf.pp1.ast;

public class AddOperatorDerived1 extends AddOperator {

    public AddOperatorDerived1 () {
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
        buffer.append("AddOperatorDerived1(\n");

        buffer.append(tab);
        buffer.append(") [AddOperatorDerived1]");
        return buffer.toString();
    }
}
