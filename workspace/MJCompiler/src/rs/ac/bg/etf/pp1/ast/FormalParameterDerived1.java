// generated with ast extension for cup
// version 0.8
// 16/0/2018 19:5:1


package rs.ac.bg.etf.pp1.ast;

public class FormalParameterDerived1 extends FormalParameter {

    private Type Type;
    private String I2;
    private OptionalArrayDeclaration OptionalArrayDeclaration;

    public FormalParameterDerived1 (Type Type, String I2, OptionalArrayDeclaration OptionalArrayDeclaration) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.OptionalArrayDeclaration=OptionalArrayDeclaration;
        if(OptionalArrayDeclaration!=null) OptionalArrayDeclaration.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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
        if(Type!=null) Type.accept(visitor);
        if(OptionalArrayDeclaration!=null) OptionalArrayDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalArrayDeclaration!=null) OptionalArrayDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalArrayDeclaration!=null) OptionalArrayDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormalParameterDerived1(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(OptionalArrayDeclaration!=null)
            buffer.append(OptionalArrayDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormalParameterDerived1]");
        return buffer.toString();
    }
}
