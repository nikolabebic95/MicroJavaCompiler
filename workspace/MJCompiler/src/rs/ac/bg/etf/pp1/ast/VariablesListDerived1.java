// generated with ast extension for cup
// version 0.8
// 13/0/2018 14:8:4


package rs.ac.bg.etf.pp1.ast;

public class VariablesListDerived1 extends VariablesList {

    private VariablesList VariablesList;
    private VariableDefinition VariableDefinition;

    public VariablesListDerived1 (VariablesList VariablesList, VariableDefinition VariableDefinition) {
        this.VariablesList=VariablesList;
        if(VariablesList!=null) VariablesList.setParent(this);
        this.VariableDefinition=VariableDefinition;
        if(VariableDefinition!=null) VariableDefinition.setParent(this);
    }

    public VariablesList getVariablesList() {
        return VariablesList;
    }

    public void setVariablesList(VariablesList VariablesList) {
        this.VariablesList=VariablesList;
    }

    public VariableDefinition getVariableDefinition() {
        return VariableDefinition;
    }

    public void setVariableDefinition(VariableDefinition VariableDefinition) {
        this.VariableDefinition=VariableDefinition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VariablesList!=null) VariablesList.accept(visitor);
        if(VariableDefinition!=null) VariableDefinition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariablesList!=null) VariablesList.traverseTopDown(visitor);
        if(VariableDefinition!=null) VariableDefinition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariablesList!=null) VariablesList.traverseBottomUp(visitor);
        if(VariableDefinition!=null) VariableDefinition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariablesListDerived1(\n");

        if(VariablesList!=null)
            buffer.append(VariablesList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VariableDefinition!=null)
            buffer.append(VariableDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariablesListDerived1]");
        return buffer.toString();
    }
}
