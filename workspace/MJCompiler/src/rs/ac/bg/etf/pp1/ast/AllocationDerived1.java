// generated with ast extension for cup
// version 0.8
// 10/0/2018 16:2:30


package rs.ac.bg.etf.pp1.ast;

public class AllocationDerived1 extends Allocation {

    private Type Type;
    private OptionalArrayDefinition OptionalArrayDefinition;

    public AllocationDerived1 (Type Type, OptionalArrayDefinition OptionalArrayDefinition) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.OptionalArrayDefinition=OptionalArrayDefinition;
        if(OptionalArrayDefinition!=null) OptionalArrayDefinition.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public OptionalArrayDefinition getOptionalArrayDefinition() {
        return OptionalArrayDefinition;
    }

    public void setOptionalArrayDefinition(OptionalArrayDefinition OptionalArrayDefinition) {
        this.OptionalArrayDefinition=OptionalArrayDefinition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(OptionalArrayDefinition!=null) OptionalArrayDefinition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalArrayDefinition!=null) OptionalArrayDefinition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalArrayDefinition!=null) OptionalArrayDefinition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AllocationDerived1(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalArrayDefinition!=null)
            buffer.append(OptionalArrayDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AllocationDerived1]");
        return buffer.toString();
    }
}
