// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:21


package rs.ac.bg.etf.pp1.ast;

public class BaseClassDeclarationDerived2 extends BaseClassDeclaration {

    public BaseClassDeclarationDerived2 () {
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
        buffer.append("BaseClassDeclarationDerived2(\n");

        buffer.append(tab);
        buffer.append(") [BaseClassDeclarationDerived2]");
        return buffer.toString();
    }
}
