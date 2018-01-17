// generated with ast extension for cup
// version 0.8
// 17/0/2018 1:1:30


package rs.ac.bg.etf.pp1.ast;

public class VariableDefinitionDerived1 extends VariableDefinition {

    private String I1;
    private OptionalArrayDeclaration OptionalArrayDeclaration;

    public VariableDefinitionDerived1 (String I1, OptionalArrayDeclaration OptionalArrayDeclaration) {
        this.I1=I1;
        this.OptionalArrayDeclaration=OptionalArrayDeclaration;
        if(OptionalArrayDeclaration!=null) OptionalArrayDeclaration.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public OptionalArrayDeclaration getOptionalArrayDeclaration() {
        return OptionalArrayDeclaration;
    }

    public void setOptionalArrayDeclaration(OptionalArrayDeclaration OptionalArrayDeclaration) {
        this.OptionalArrayDeclaration=OptionalArrayDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalArrayDeclaration!=null) OptionalArrayDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalArrayDeclaration!=null) OptionalArrayDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalArrayDeclaration!=null) OptionalArrayDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariableDefinitionDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(OptionalArrayDeclaration!=null)
            buffer.append(OptionalArrayDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariableDefinitionDerived1]");
        return buffer.toString();
    }
}
