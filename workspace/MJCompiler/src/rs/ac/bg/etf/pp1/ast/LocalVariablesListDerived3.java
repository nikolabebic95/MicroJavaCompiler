// generated with ast extension for cup
// version 0.8
// 18/0/2018 2:29:20


package rs.ac.bg.etf.pp1.ast;

public class LocalVariablesListDerived3 extends LocalVariablesList {

    private VariableDeclaration VariableDeclaration;

    public LocalVariablesListDerived3 (VariableDeclaration VariableDeclaration) {
        this.VariableDeclaration=VariableDeclaration;
        if(VariableDeclaration!=null) VariableDeclaration.setParent(this);
    }

    public VariableDeclaration getVariableDeclaration() {
        return VariableDeclaration;
    }

    public void setVariableDeclaration(VariableDeclaration VariableDeclaration) {
        this.VariableDeclaration=VariableDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariableDeclaration!=null) VariableDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableDeclaration!=null) VariableDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableDeclaration!=null) VariableDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LocalVariablesListDerived3(\n");

        if(VariableDeclaration!=null)
            buffer.append(VariableDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LocalVariablesListDerived3]");
        return buffer.toString();
    }
}
