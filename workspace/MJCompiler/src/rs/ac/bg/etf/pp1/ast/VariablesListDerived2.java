// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:21


package rs.ac.bg.etf.pp1.ast;

public class VariablesListDerived2 extends VariablesList {

    private VariableDefinition VariableDefinition;

    public VariablesListDerived2 (VariableDefinition VariableDefinition) {
        this.VariableDefinition=VariableDefinition;
        if(VariableDefinition!=null) VariableDefinition.setParent(this);
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
        if(VariableDefinition!=null) VariableDefinition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VariableDefinition!=null) VariableDefinition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VariableDefinition!=null) VariableDefinition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariablesListDerived2(\n");

        if(VariableDefinition!=null)
            buffer.append(VariableDefinition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariablesListDerived2]");
        return buffer.toString();
    }
}
