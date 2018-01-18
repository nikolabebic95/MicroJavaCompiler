// generated with ast extension for cup
// version 0.8
// 18/0/2018 2:29:27


package rs.ac.bg.etf.pp1.ast;

public class ClassStartDerived1 extends ClassStart {

    private String I1;
    private BaseClassDeclaration BaseClassDeclaration;

    public ClassStartDerived1 (String I1, BaseClassDeclaration BaseClassDeclaration) {
        this.I1=I1;
        this.BaseClassDeclaration=BaseClassDeclaration;
        if(BaseClassDeclaration!=null) BaseClassDeclaration.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BaseClassDeclaration!=null) BaseClassDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BaseClassDeclaration!=null) BaseClassDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BaseClassDeclaration!=null) BaseClassDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassStartDerived1(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(BaseClassDeclaration!=null)
            buffer.append(BaseClassDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassStartDerived1]");
        return buffer.toString();
    }
}
