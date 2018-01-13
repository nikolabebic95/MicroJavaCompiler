// generated with ast extension for cup
// version 0.8
// 13/0/2018 22:49:31


package rs.ac.bg.etf.pp1.ast;

public class LocalVariablesListDerived1 extends LocalVariablesList {

    private LocalVariablesList LocalVariablesList;
    private LocalVariableDeclaration LocalVariableDeclaration;

    public LocalVariablesListDerived1 (LocalVariablesList LocalVariablesList, LocalVariableDeclaration LocalVariableDeclaration) {
        this.LocalVariablesList=LocalVariablesList;
        if(LocalVariablesList!=null) LocalVariablesList.setParent(this);
        this.LocalVariableDeclaration=LocalVariableDeclaration;
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.setParent(this);
    }

    public LocalVariablesList getLocalVariablesList() {
        return LocalVariablesList;
    }

    public void setLocalVariablesList(LocalVariablesList LocalVariablesList) {
        this.LocalVariablesList=LocalVariablesList;
    }

    public LocalVariableDeclaration getLocalVariableDeclaration() {
        return LocalVariableDeclaration;
    }

    public void setLocalVariableDeclaration(LocalVariableDeclaration LocalVariableDeclaration) {
        this.LocalVariableDeclaration=LocalVariableDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LocalVariablesList!=null) LocalVariablesList.accept(visitor);
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.traverseTopDown(visitor);
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LocalVariablesList!=null) LocalVariablesList.traverseBottomUp(visitor);
        if(LocalVariableDeclaration!=null) LocalVariableDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVariablesListDerived1(\n");

        if(LocalVariablesList!=null)
            buffer.append(LocalVariablesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVariableDeclaration!=null)
            buffer.append(LocalVariableDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVariablesListDerived1]");
        return buffer.toString();
    }
}
