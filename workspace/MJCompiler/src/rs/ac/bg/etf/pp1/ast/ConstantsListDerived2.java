// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:21


package rs.ac.bg.etf.pp1.ast;

public class ConstantsListDerived2 extends ConstantsList {

    private ConstantDefinition ConstantDefinition;

    public ConstantsListDerived2 (ConstantDefinition ConstantDefinition) {
        this.ConstantDefinition=ConstantDefinition;
        if(ConstantDefinition!=null) ConstantDefinition.setParent(this);
    }

    public ConstantDefinition getConstantDefinition() {
        return ConstantDefinition;
    }

    public void setConstantDefinition(ConstantDefinition ConstantDefinition) {
        this.ConstantDefinition=ConstantDefinition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstantDefinition!=null) ConstantDefinition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantDefinition!=null) ConstantDefinition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantDefinition!=null) ConstantDefinition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantsListDerived2(\n");

        if(ConstantDefinition!=null)
            buffer.append(ConstantDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantsListDerived2]");
        return buffer.toString();
    }
}
