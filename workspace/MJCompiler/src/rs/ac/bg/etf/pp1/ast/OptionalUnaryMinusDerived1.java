// generated with ast extension for cup
// version 0.8
// 7/0/2018 16:9:24


package rs.ac.bg.etf.pp1.ast;

public class OptionalUnaryMinusDerived1 extends OptionalUnaryMinus {

    public OptionalUnaryMinusDerived1 () {
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
        buffer.append("OptionalUnaryMinusDerived1(\n");

        buffer.append(tab);
        buffer.append(") [OptionalUnaryMinusDerived1]");
        return buffer.toString();
    }
}
