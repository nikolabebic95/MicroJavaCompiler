// generated with ast extension for cup
// version 0.8
// 17/0/2018 1:1:30


package rs.ac.bg.etf.pp1.ast;

public class OptionalElseDerived2 extends OptionalElse {

    public OptionalElseDerived2 () {
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
        buffer.append("OptionalElseDerived2(\n");

        buffer.append(tab);
        buffer.append(") [OptionalElseDerived2]");
        return buffer.toString();
    }
}
