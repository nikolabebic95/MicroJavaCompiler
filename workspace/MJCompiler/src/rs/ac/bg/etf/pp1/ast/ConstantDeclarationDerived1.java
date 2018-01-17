// generated with ast extension for cup
// version 0.8
// 17/0/2018 18:3:11


package rs.ac.bg.etf.pp1.ast;

public class ConstantDeclarationDerived1 extends ConstantDeclaration {

    private Type Type;
    private ConstantsList ConstantsList;

    public ConstantDeclarationDerived1 (Type Type, ConstantsList ConstantsList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstantsList=ConstantsList;
        if(ConstantsList!=null) ConstantsList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstantsList getConstantsList() {
        return ConstantsList;
    }

    public void setConstantsList(ConstantsList ConstantsList) {
        this.ConstantsList=ConstantsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstantsList!=null) ConstantsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstantsList!=null) ConstantsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstantsList!=null) ConstantsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantDeclarationDerived1(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstantsList!=null)
            buffer.append(ConstantsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantDeclarationDerived1]");
        return buffer.toString();
    }
}
