// generated with ast extension for cup
// version 0.8
// 15/0/2018 23:38:22


package rs.ac.bg.etf.pp1.ast;

public class OptionalArrayDeclarationDerived2 extends OptionalArrayDeclaration {

    public OptionalArrayDeclarationDerived2 () {
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
        buffer.append("OptionalArrayDeclarationDerived2(\n");

        buffer.append(tab);
        buffer.append(") [OptionalArrayDeclarationDerived2]");
        return buffer.toString();
    }
}
