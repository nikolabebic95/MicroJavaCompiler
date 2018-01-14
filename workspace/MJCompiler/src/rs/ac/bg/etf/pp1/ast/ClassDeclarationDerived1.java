// generated with ast extension for cup
// version 0.8
// 14/0/2018 2:25:50


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarationDerived1 extends ClassDeclaration {

    private String I1;
    private BaseClassDeclaration BaseClassDeclaration;
    private LocalVariablesList LocalVariablesList;
    private OptionalMethodsList OptionalMethodsList;

    public ClassDeclarationDerived1 (String I1, BaseClassDeclaration BaseClassDeclaration, LocalVariablesList LocalVariablesList, OptionalMethodsList OptionalMethodsList) {
        this.I1=I1;
        this.BaseClassDeclaration=BaseClassDeclaration;
        if(BaseClassDeclaration!=null) BaseClassDeclaration.setParent(this);
        this.LocalVariablesList=LocalVariablesList;
        if(LocalVariablesList!=null) LocalVariablesList.setParent(this);
        this.OptionalMethodsList=OptionalMethodsList;
        if(OptionalMethodsList!=null) OptionalMethodsList.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public BaseClassDeclaration getBaseClassDeclaration() {
        return BaseClassDeclaration;
    }

    public void setBaseClassDeclaration(BaseClassDeclaration BaseClassDeclaration) {
        this.BaseClassDeclaration=BaseClassDeclaration;
    }

    public LocalVariablesList getLocalVariablesList() {
        return LocalVariablesList;
    }

    public void setLocalVariablesList(LocalVariablesList LocalVariablesList) {
        this.LocalVariablesList=LocalVariablesList;
    }

    public OptionalMethodsList getOptionalMethodsList() {
        return OptionalMethodsList;
    }

    public void setOptionalMethodsList(OptionalMethodsList OptionalMethodsList) {
        this.OptionalMethodsList=OptionalMethodsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BaseClassDeclaration!=null) BaseClassDeclaration.accept(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.accept(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BaseClassDeclaration!=null) BaseClassDeclaration.traverseTopDown(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.traverseTopDown(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BaseClassDeclaration!=null) BaseClassDeclaration.traverseBottomUp(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.traverseBottomUp(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarationDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(BaseClassDeclaration!=null)
            buffer.append(BaseClassDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVariablesList!=null)
            buffer.append(LocalVariablesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalMethodsList!=null)
            buffer.append(OptionalMethodsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarationDerived1]");
        return buffer.toString();
    }
}
