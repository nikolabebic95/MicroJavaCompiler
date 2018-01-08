// generated with ast extension for cup
// version 0.8
// 8/0/2018 2:11:43


package rs.ac.bg.etf.pp1.ast;

public class DeclarationsListDerived1 extends DeclarationsList {

    private DeclarationsList DeclarationsList;
    private Declaration Declaration;

    public DeclarationsListDerived1 (DeclarationsList DeclarationsList, Declaration Declaration) {
        this.DeclarationsList=DeclarationsList;
        if(DeclarationsList!=null) DeclarationsList.setParent(this);
        this.Declaration=Declaration;
        if(Declaration!=null) Declaration.setParent(this);
    }

    public DeclarationsList getDeclarationsList() {
        return DeclarationsList;
    }

    public void setDeclarationsList(DeclarationsList DeclarationsList) {
        this.DeclarationsList=DeclarationsList;
    }

    public Declaration getDeclaration() {
        return Declaration;
    }

    public void setDeclaration(Declaration Declaration) {
        this.Declaration=Declaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclarationsList!=null) DeclarationsList.accept(visitor);
        if(Declaration!=null) Declaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclarationsList!=null) DeclarationsList.traverseTopDown(visitor);
        if(Declaration!=null) Declaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclarationsList!=null) DeclarationsList.traverseBottomUp(visitor);
        if(Declaration!=null) Declaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclarationsListDerived1(\n");

        if(DeclarationsList!=null)
            buffer.append(DeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Declaration!=null)
            buffer.append(Declaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclarationsListDerived1]");
        return buffer.toString();
    }
}
