// generated with ast extension for cup
// version 0.8
// 14/0/2018 2:25:50


package rs.ac.bg.etf.pp1.ast;

public class ReturnDerived2 extends Return {

    public ReturnDerived2 () {
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
        buffer.append("ReturnDerived2(\n");

        buffer.append(tab);
        buffer.append(") [ReturnDerived2]");
        return buffer.toString();
    }
}
