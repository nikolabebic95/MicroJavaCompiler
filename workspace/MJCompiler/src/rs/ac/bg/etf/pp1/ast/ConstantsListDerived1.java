// generated with ast extension for cup
// version 0.8
// 13/0/2018 14:8:4


package rs.ac.bg.etf.pp1.ast;

public class ConstantsListDerived1 extends ConstantsList {

    private ConstantsList ConstantsList;
    private ConstantDefinition ConstantDefinition;

    public ConstantsListDerived1 (ConstantsList ConstantsList, ConstantDefinition ConstantDefinition) {
        this.ConstantsList=ConstantsList;
        if(ConstantsList!=null) ConstantsList.setParent(this);
        this.ConstantDefinition=ConstantDefinition;
        if(ConstantDefinition!=null) ConstantDefinition.setParent(this);
    }

    public ConstantsList getConstantsList() {
        return ConstantsList;
    }

    public void setConstantsList(ConstantsList ConstantsList) {
        this.ConstantsList=ConstantsList;
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
        if(ConstantsList!=null) ConstantsList.accept(visitor);
        if(ConstantDefinition!=null) ConstantDefinition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstantsList!=null) ConstantsList.traverseTopDown(visitor);
        if(ConstantDefinition!=null) ConstantDefinition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstantsList!=null) ConstantsList.traverseBottomUp(visitor);
        if(ConstantDefinition!=null) ConstantDefinition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantsListDerived1(\n");

        if(ConstantsList!=null)
            buffer.append(ConstantsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstantDefinition!=null)
            buffer.append(ConstantDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantsListDerived1]");
        return buffer.toString();
    }
}
