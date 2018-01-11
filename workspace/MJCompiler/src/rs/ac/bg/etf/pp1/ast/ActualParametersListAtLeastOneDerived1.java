// generated with ast extension for cup
// version 0.8
// 11/0/2018 22:8:2


package rs.ac.bg.etf.pp1.ast;

public class ActualParametersListAtLeastOneDerived1 extends ActualParametersListAtLeastOne {

    private ActualParameter ActualParameter;
    private OptionalActualParameters OptionalActualParameters;

    public ActualParametersListAtLeastOneDerived1 (ActualParameter ActualParameter, OptionalActualParameters OptionalActualParameters) {
        this.ActualParameter=ActualParameter;
        if(ActualParameter!=null) ActualParameter.setParent(this);
        this.OptionalActualParameters=OptionalActualParameters;
        if(OptionalActualParameters!=null) OptionalActualParameters.setParent(this);
    }

    public ActualParameter getActualParameter() {
        return ActualParameter;
    }

    public void setActualParameter(ActualParameter ActualParameter) {
        this.ActualParameter=ActualParameter;
    }

    public OptionalActualParameters getOptionalActualParameters() {
        return OptionalActualParameters;
    }

    public void setOptionalActualParameters(OptionalActualParameters OptionalActualParameters) {
        this.OptionalActualParameters=OptionalActualParameters;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActualParameter!=null) ActualParameter.accept(visitor);
        if(OptionalActualParameters!=null) OptionalActualParameters.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParameter!=null) ActualParameter.traverseTopDown(visitor);
        if(OptionalActualParameters!=null) OptionalActualParameters.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParameter!=null) ActualParameter.traverseBottomUp(visitor);
        if(OptionalActualParameters!=null) OptionalActualParameters.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParametersListAtLeastOneDerived1(\n");

        if(ActualParameter!=null)
            buffer.append(ActualParameter.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalActualParameters!=null)
            buffer.append(OptionalActualParameters.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParametersListAtLeastOneDerived1]");
        return buffer.toString();
    }
}
