// generated with ast extension for cup
// version 0.8
// 13/0/2018 22:49:31


package rs.ac.bg.etf.pp1.ast;

public class LocalVariableDeclarationDerived1 extends LocalVariableDeclaration {

    private Type Type;
    private VariablesList VariablesList;

    public LocalVariableDeclarationDerived1 (Type Type, VariablesList VariablesList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VariablesList=VariablesList;
        if(VariablesList!=null) VariablesList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VariablesList getVariablesList() {
        return VariablesList;
    }

    public void setVariablesList(VariablesList VariablesList) {
        this.VariablesList=VariablesList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VariablesList!=null) VariablesList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VariablesList!=null) VariablesList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VariablesList!=null) VariablesList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVariableDeclarationDerived1(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariablesList!=null)
            buffer.append(VariablesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVariableDeclarationDerived1]");
        return buffer.toString();
    }
}
