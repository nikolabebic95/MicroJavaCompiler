// generated with ast extension for cup
// version 0.8
// 17/0/2018 0:47:21


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarationDerived1 extends ClassDeclaration {

    private ClassStart ClassStart;
    private LocalVariablesList LocalVariablesList;
    private DummyClassSeparator DummyClassSeparator;
    private OptionalMethodsList OptionalMethodsList;

    public ClassDeclarationDerived1 (ClassStart ClassStart, LocalVariablesList LocalVariablesList, DummyClassSeparator DummyClassSeparator, OptionalMethodsList OptionalMethodsList) {
        this.ClassStart=ClassStart;
        if(ClassStart!=null) ClassStart.setParent(this);
        this.LocalVariablesList=LocalVariablesList;
        if(LocalVariablesList!=null) LocalVariablesList.setParent(this);
        this.DummyClassSeparator=DummyClassSeparator;
        if(DummyClassSeparator!=null) DummyClassSeparator.setParent(this);
        this.OptionalMethodsList=OptionalMethodsList;
        if(OptionalMethodsList!=null) OptionalMethodsList.setParent(this);
    }

    public ClassStart getClassStart() {
        return ClassStart;
    }

    public void setClassStart(ClassStart ClassStart) {
        this.ClassStart=ClassStart;
    }

    public LocalVariablesList getLocalVariablesList() {
        return LocalVariablesList;
    }

    public void setLocalVariablesList(LocalVariablesList LocalVariablesList) {
        this.LocalVariablesList=LocalVariablesList;
    }

    public DummyClassSeparator getDummyClassSeparator() {
        return DummyClassSeparator;
    }

    public void setDummyClassSeparator(DummyClassSeparator DummyClassSeparator) {
        this.DummyClassSeparator=DummyClassSeparator;
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
        if(ClassStart!=null) ClassStart.accept(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.accept(visitor);
        if(DummyClassSeparator!=null) DummyClassSeparator.accept(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassStart!=null) ClassStart.traverseTopDown(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.traverseTopDown(visitor);
        if(DummyClassSeparator!=null) DummyClassSeparator.traverseTopDown(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassStart!=null) ClassStart.traverseBottomUp(visitor);
        if(LocalVariablesList!=null) LocalVariablesList.traverseBottomUp(visitor);
        if(DummyClassSeparator!=null) DummyClassSeparator.traverseBottomUp(visitor);
        if(OptionalMethodsList!=null) OptionalMethodsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarationDerived1(\n");

        if(ClassStart!=null)
            buffer.append(ClassStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(LocalVariablesList!=null)
            buffer.append(LocalVariablesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DummyClassSeparator!=null)
            buffer.append(DummyClassSeparator.toString("  "+tab));
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
