// generated with ast extension for cup
// version 0.8
// 8/0/2018 2:11:43


package rs.ac.bg.etf.pp1.ast;

public class ProgramDerived1 extends Program {

    private String I1;
    private DeclarationsList DeclarationsList;
    private MethodsList MethodsList;

    public ProgramDerived1 (String I1, DeclarationsList DeclarationsList, MethodsList MethodsList) {
        this.I1=I1;
        this.DeclarationsList=DeclarationsList;
        if(DeclarationsList!=null) DeclarationsList.setParent(this);
        this.MethodsList=MethodsList;
        if(MethodsList!=null) MethodsList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public DeclarationsList getDeclarationsList() {
        return DeclarationsList;
    }

    public void setDeclarationsList(DeclarationsList DeclarationsList) {
        this.DeclarationsList=DeclarationsList;
    }

    public MethodsList getMethodsList() {
        return MethodsList;
    }

    public void setMethodsList(MethodsList MethodsList) {
        this.MethodsList=MethodsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclarationsList!=null) DeclarationsList.accept(visitor);
        if(MethodsList!=null) MethodsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclarationsList!=null) DeclarationsList.traverseTopDown(visitor);
        if(MethodsList!=null) MethodsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclarationsList!=null) DeclarationsList.traverseBottomUp(visitor);
        if(MethodsList!=null) MethodsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(DeclarationsList!=null)
            buffer.append(DeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodsList!=null)
            buffer.append(MethodsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramDerived1]");
        return buffer.toString();
    }
}
