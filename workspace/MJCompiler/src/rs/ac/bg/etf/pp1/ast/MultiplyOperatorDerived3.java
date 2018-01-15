// generated with ast extension for cup
// version 0.8
// 15/0/2018 16:25:53


package rs.ac.bg.etf.pp1.ast;

public class MultiplyOperatorDerived3 extends MultiplyOperator {

    public MultiplyOperatorDerived3 () {
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
        buffer.append("MultiplyOperatorDerived3(\n");

        buffer.append(tab);
        buffer.append(") [MultiplyOperatorDerived3]");
        return buffer.toString();
    }
}
