// generated with ast extension for cup
// version 0.8
// 16/0/2018 19:5:1


package rs.ac.bg.etf.pp1.ast;

public class DeclarationDerived2 extends Declaration {

    private ConstantDeclaration ConstantDeclaration;

    public DeclarationDerived2 (ConstantDeclaration ConstantDeclaration) {
        this.ConstantDeclaration=ConstantDeclaration;
        if(ConstantDeclaration!=null) ConstantDeclaration.setParent(this);
    }

    public ConstantDeclaration getConstantDeclaration() {
        return ConstantDeclaration;
    }

    public void setConstantDeclaration(ConstantDeclaration ConstantDeclaration) {
        this.ConstantDeclaration=ConstantDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstantDeclaration!=null) ConstantDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantDeclaration!=null) ConstantDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantDeclaration!=null) ConstantDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationDerived2(\n");

        if(ConstantDeclaration!=null)
            buffer.append(ConstantDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationDerived2]");
        return buffer.toString();
    }
}
