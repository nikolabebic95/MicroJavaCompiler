// generated with ast extension for cup
// version 0.8
// 13/0/2018 14:8:4


package rs.ac.bg.etf.pp1.ast;

public class LocalVariablesListDerived2 extends LocalVariablesList {

    public LocalVariablesListDerived2 () {
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
        buffer.append("LocalVariablesListDerived2(\n");

        buffer.append(tab);
        buffer.append(") [LocalVariablesListDerived2]");
        return buffer.toString();
    }
}
