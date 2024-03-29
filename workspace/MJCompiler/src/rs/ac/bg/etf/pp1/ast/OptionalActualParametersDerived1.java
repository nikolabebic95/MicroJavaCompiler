// generated with ast extension for cup
// version 0.8
// 18/0/2018 3:6:22


package rs.ac.bg.etf.pp1.ast;

public class OptionalActualParametersDerived1 extends OptionalActualParameters {

    private ActualParametersListAtLeastOne ActualParametersListAtLeastOne;

    public OptionalActualParametersDerived1 (ActualParametersListAtLeastOne ActualParametersListAtLeastOne) {
        this.ActualParametersListAtLeastOne=ActualParametersListAtLeastOne;
        if(ActualParametersListAtLeastOne!=null) ActualParametersListAtLeastOne.setParent(this);
    }

    public ActualParametersListAtLeastOne getActualParametersListAtLeastOne() {
        return ActualParametersListAtLeastOne;
    }

    public void setActualParametersListAtLeastOne(ActualParametersListAtLeastOne ActualParametersListAtLeastOne) {
        this.ActualParametersListAtLeastOne=ActualParametersListAtLeastOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActualParametersListAtLeastOne!=null) ActualParametersListAtLeastOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParametersListAtLeastOne!=null) ActualParametersListAtLeastOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParametersListAtLeastOne!=null) ActualParametersListAtLeastOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalActualParametersDerived1(\n");

        if(ActualParametersListAtLeastOne!=null)
            buffer.append(ActualParametersListAtLeastOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalActualParametersDerived1]");
        return buffer.toString();
    }
}
