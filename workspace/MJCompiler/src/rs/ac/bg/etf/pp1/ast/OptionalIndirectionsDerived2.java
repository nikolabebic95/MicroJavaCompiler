// generated with ast extension for cup
// version 0.8
// 13/0/2018 22:49:31


package rs.ac.bg.etf.pp1.ast;

public class OptionalIndirectionsDerived2 extends OptionalIndirections {

    public OptionalIndirectionsDerived2 () {
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
        buffer.append("OptionalIndirectionsDerived2(\n");

        buffer.append(tab);
        buffer.append(") [OptionalIndirectionsDerived2]");
        return buffer.toString();
    }
}
