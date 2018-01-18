// generated with ast extension for cup
// version 0.8
// 18/0/2018 2:28:33


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclarationDerived2 extends ClassDeclaration {

    private ClassStart ClassStart;

    public ClassDeclarationDerived2 (ClassStart ClassStart) {
        this.ClassStart=ClassStart;
        if(ClassStart!=null) ClassStart.setParent(this);
    }

    public ClassStart getClassStart() {
        return ClassStart;
    }

    public void setClassStart(ClassStart ClassStart) {
        this.ClassStart=ClassStart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassStart!=null) ClassStart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassStart!=null) ClassStart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassStart!=null) ClassStart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclarationDerived2(\n");

        if(ClassStart!=null)
            buffer.append(ClassStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclarationDerived2]");
        return buffer.toString();
    }
}
