// generated with ast extension for cup
// version 0.8
// 13/0/2018 14:8:5


package rs.ac.bg.etf.pp1.ast;

public class RelationalOperatorDerived3 extends RelationalOperator {

    public RelationalOperatorDerived3 () {
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
        buffer.append("RelationalOperatorDerived3(\n");

        buffer.append(tab);
        buffer.append(") [RelationalOperatorDerived3]");
        return buffer.toString();
    }
}
